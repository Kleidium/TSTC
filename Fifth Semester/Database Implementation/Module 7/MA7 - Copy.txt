/******Before all the following names of stored procedures, add YourSchemaName.sp_” and before all functions add, “YourSchemaName.fn_”.******/


/* 1. Write a script that creates and calls a stored procedure named spAddCategory. First, code a statement that creates a procedure that adds a new row to the Categories table.
	To do that, this procedure should have one parameter for the category name.
	Code at least two EXEC statements that test this procedure. (Note that this table doesn’t allow duplicate category names.) */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP PROC IF EXISTS kpolandsp242333.sp_spAddCategory;
GO

CREATE PROC kpolandsp242333.sp_spAddCategory
	@CategoryName varchar(255)
AS
IF @CategoryName = NULL
	PRINT 'Please enter a valid category name. No record was added.';
ELSE
	IF EXISTS (SELECT CategoryName FROM kpolandsp242333.Categories WHERE CategoryName = @CategoryName)
		PRINT 'The ' + @CategoryName + ' category already exists. No record was added.';
	ELSE
		BEGIN
			INSERT INTO kpolandsp242333.Categories
			VALUES (@CategoryName);

			PRINT @CategoryName + ' category added.';
		END;
GO
/*******************************************/

/* Execute */
EXEC kpolandsp242333.sp_spAddCategory 'Pianos';
EXEC kpolandsp242333.sp_spAddCategory 'Harps';

/* CLEANUP:
DELETE FROM kpolandsp242333.Categories WHERE CategoryName = 'Pianos';
DELETE FROM kpolandsp242333.Categories WHERE CategoryName = 'Harps';
*/



/* 2. Write a script that creates and calls a function named fnCategoryCount return the number of Products as ProductCount in the product table that match a category name.
	To do that, this function should accept one parameter for the category name. You can use the category name to match the CategoryID in the Products table to count the items.
	The SELECT statement that calls the function passing it ‘Guitars’. */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP FUNCTION IF EXISTS kpolandsp242333.fn_fnCategoryCount;
GO

CREATE FUNCTION kpolandsp242333.fn_fnCategoryCount
	(@CategoryName varchar(255))
	RETURNS int
BEGIN
	RETURN (SELECT COUNT(*) FROM kpolandsp242333.Products WHERE CategoryID = (SELECT CategoryID FROM kpolandsp242333.Categories WHERE CategoryName = @CategoryName));
END;
GO
/*******************************************/

/* Invoke */
SELECT kpolandsp242333.fn_fnCategoryCount('Guitars') AS ProductCount;



/* 3. Write a script that creates and calls a function named fnCustomerTotal that calculates the total order purchases of a customer in the Orders and OrderItems table.
	To do that, this function should accept one parameter for the Customer ID, and it should return the sum of the item prices ordered by the Customer.
	The function should return the CustomerID and calculated sum.
	Write two SELECT statements that call the function with customer numbers 1 and 3.*/

/* NOTE: UDFs can only return a single scalar value or a table. Since this function is required to return the CustomerID and calculated sum, I decided to return a table. */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP FUNCTION IF EXISTS kpolandsp242333.fn_fnCustomerTotal;
GO

CREATE FUNCTION kpolandsp242333.fn_fnCustomerTotal
	(@CustomerID int)
	RETURNS table
RETURN (SELECT kpolandsp242333.Customers.CustomerID, SUM(ItemPrice * Quantity) AS PurchaseSum
	FROM kpolandsp242333.Customers
	JOIN kpolandsp242333.Orders
	ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
	JOIN kpolandsp242333.OrderItems
	ON kpolandsp242333.Orders.OrderID = kpolandsp242333.OrderItems.OrderID
	WHERE kpolandsp242333.Customers.CustomerID = @CustomerID
	GROUP BY kpolandsp242333.Customers.CustomerID);
GO
/*******************************************/

/* Invoke */
SELECT * FROM kpolandsp242333.fn_fnCustomerTotal(1);
SELECT * FROM kpolandsp242333.fn_fnCustomerTotal(3);



/* 4. Write a script that creates and calls a stored procedure named spInsertCustomer that inserts a row into the Customers table.
	This stored procedure should accept one parameter for each of these columns: EmailAddress, Password, LastName, FirstName.
	This stored procedure should set the Billing and Shipping addresses to NULL.
	Code at least two EXEC statements that test this procedure. */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP PROC IF EXISTS kpolandsp242333.sp_spInsertCustomer;
GO

CREATE PROC kpolandsp242333.sp_spInsertCustomer
	@EmailAddress varchar(255),
	@Password varchar(60),
	@FirstName varchar(60),
	@LastName varchar(60)
AS
	/* Validation ensures no empty values or truncated data. */
	IF @EmailAddress = NULL OR @EmailAddress = '' OR LEN(@EmailAddress) > 255
		THROW 50001, 'Invalid Email Address. EmailAddress cannot be empty or greater than 255 characters.' , 1;
	IF @Password = NULL OR @Password = '' OR LEN(@Password) > 60
		THROW 50001, 'Invalid Password. Password cannot be empty or greater than 60 characters.' , 1;
	IF @FirstName = NULL OR @FirstName = '' OR LEN(@FirstName) > 60
		THROW 50001, 'Invalid First Name. FirstName cannot be empty or greater than 60 characters.' , 1;
	IF @LastName = NULL OR @LastName = '' OR LEN(@LastName) > 60
		THROW 50001, 'Invalid Last Name. LastName cannot be empty or greater than 60 characters.' , 1;

	/* Insert */
	INSERT INTO kpolandsp242333.Customers
	VALUES (@EmailAddress, @Password, @FirstName, @LastName, NULL, NULL);
GO
/*******************************************/

/* Execute */
EXEC kpolandsp242333.sp_spInsertCustomer 'Email@domain.com', 'password', 'John', 'Doe';
EXEC kpolandsp242333.sp_spInsertCustomer 'fake@test.com', 'passward', 'Mary', 'Sue';

/* CLEANUP:
DELETE FROM kpolandsp242333.Customers WHERE Password = 'password';
DELETE FROM kpolandsp242333.Customers WHERE Password = 'passward';
*/



/* 5. Write a script that creates and calls a stored procedure named spSetPrice that updates the ListPrice column in the Products table.
	This procedure should have one parameter for the product ID and another for the new price.
	If the value for the ListPrice column is a negative number, the stored procedure should raise an error that indicates that the value for this column must be a positive number.
	Code at least two EXEC statements that test this procedure. */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP PROC IF EXISTS kpolandsp242333.sp_spSetPrice;
GO

CREATE PROC kpolandsp242333.sp_spSetPrice
	@ProductID int,
	@NewPrice money
AS
	/* Validate */
	IF NOT EXISTS (SELECT ProductID FROM kpolandsp242333.Products WHERE ProductID = @ProductID)
		BEGIN
			PRINT 'ProductID ' + CAST(@ProductID as varchar) + ' does not exist. No records were updated.';
			PRINT '';
			THROW 50001, 'Invalid ProductID.' , 1;
		END;
	IF @NewPrice < 0
		THROW 50001, 'Invalid ListPrice. ListPrice cannot be negative.' , 1;

	/* Insert */
	UPDATE kpolandsp242333.Products
	SET ListPrice = @NewPrice
	WHERE ProductID = @ProductID;
GO
/*******************************************/

/* Execute */
EXEC kpolandsp242333.sp_spSetPrice 1, 500.00;
EXEC kpolandsp242333.sp_spSetPrice 2, -500.00;

/* CLEANUP:
UPDATE kpolandsp242333.Products SET ListPrice = 699.00 WHERE ProductID = 1;
UPDATE kpolandsp242333.Products SET ListPrice = 1199.00 WHERE ProductID = 2;
*/



/* 6. Create a trigger named Products_UPDATE that checks the new value for the ListPrice column of the Instructors table.
	This trigger should raise an appropriate error if the value is negative, and Rollback the operation.
	Test this trigger by running the EXEC for problem 5 and passing a negative number. */

/* NOTE: The 'Instructors' table does not have a column named ListPrice, and is not part of the tables designated for use during Mastery Assessments.
For now, I used the 'Products' table in place of the 'Instructors' table. 
In addition, the SP from problem 5 already requires the procedure to throw an error when a negative value is passed.
This means that using the SP from problem 5 would not be an appropriate method of testing this trigger.
For now, I used a simple UPDATE statement to test this trigger. */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP TRIGGER IF EXISTS kpolandsp242333.Products_UPDATE;
GO

CREATE TRIGGER kpolandsp242333.Products_UPDATE
	ON kpolandsp242333.Products
	AFTER UPDATE
AS
	IF EXISTS (SELECT * FROM Inserted WHERE ListPrice < 0)
		BEGIN
			;
			THROW 50010, 'Invalid ListPrice. ListPrice cannot be negative. Transaction failed.' , 1;
			ROLLBACK TRAN;
		END;
GO
/*******************************************/

/* Test Trigger */
UPDATE kpolandsp242333.Products
SET ListPrice = -10.00
WHERE ProductID = 1;



/* 7. Create a trigger named Products_INSERT that inserts the current date for the DataAdded column of the Products table if the value for that column is null.
	Test this trigger with an appropriate INSERT statement. */

/*****************CREATE********************/
USE itse2333pbesp24;
DROP TRIGGER IF EXISTS kpolandsp242333.Products_INSERT;
GO

CREATE TRIGGER kpolandsp242333.Products_INSERT
	ON kpolandsp242333.Products
	AFTER INSERT
AS
	UPDATE kpolandsp242333.Products
	SET DateAdded = GETDATE()
	WHERE ProductID IN (SELECT ProductID FROM Inserted WHERE DateAdded IS NULL);

	PRINT ('DateAdded column updated automatically.');
GO
/*******************************************/

/* Test Trigger */
INSERT INTO kpolandsp242333.Products
VALUES (2, 'fake_bass', 'Fake Bass', 'Fake Description', 10.00, 0.00, NULL);

/* CLEANUP:
DELETE FROM kpolandsp242333.Products
WHERE ProductCode = 'fake_bass';
*/



/* 8. Write a script that includes SQL statements coded as a transaction to delete the row with a CustomerID of 100 from the Customers table.
	To do this, you must first delete all Addresses for that Customer from the Addresses table.
	If these statements execute successfully, commit the changes. Otherwise, roll back the changes. */

BEGIN TRY
	BEGIN TRAN;
	DELETE FROM kpolandsp242333.Addresses
	WHERE CustomerID = 100;

	DELETE FROM kpolandsp242333.Customers
	WHERE CustomerID = 100;
	COMMIT TRAN;

	PRINT('Transaction committed.');
END TRY
BEGIN CATCH
	ROLLBACK TRAN;
END CATCH;

/* CLEANUP:
BEGIN TRAN;
SET IDENTITY_INSERT kpolandsp242333.Customers ON;
INSERT INTO kpolandsp242333.Customers (CustomerID, EmailAddress, Password, FirstName, LastName, ShippingAddressID, BillingAddressID)
VALUES (100, 'cory.gibes@gmail.com', '6ba0e15dfa40f06c40e99d18dd399bc4bef2552c', 'Cory', 'Gibes', 116, 116);
SET IDENTITY_INSERT kpolandsp242333.Customers OFF;
COMMIT TRAN;

BEGIN TRAN;
SET IDENTITY_INSERT kpolandsp242333.Addresses ON;
INSERT INTO kpolandsp242333.Addresses (AddressID, CustomerID, Line1, Line2, City, State, ZipCode, Phone, Disabled)
VALUES (116, 100, '2845 Boulder Crescent St', '', 'Cleveland', 'OH', 44103, '216-270-9653', 0)
SET IDENTITY_INSERT kpolandsp242333.Addresses OFF;
COMMIT TRAN;
*/



/* 9. Write the statement to delete the Stored procedure from Problem 1. */

USE itse2333pbesp24;
DROP PROC IF EXISTS kpolandsp242333.sp_spAddCategory;
GO


/* 10. Write the statement to delete the trigger from problem 6. */

USE itse2333pbesp24;
DROP TRIGGER IF EXISTS kpolandsp242333.Products_UPDATE;
GO