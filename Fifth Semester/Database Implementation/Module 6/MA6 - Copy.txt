/******Before the names of views for the exercises, add “LastnameFirstInitialsmYR.view_”.******/
/* NOTE: The schema in the view creation instructions does not follow the correct naming convention we are using. I instead used the correct schema name. */



/* 1. Create a view named LastnameFirstInitialsmYR.view_CustomerZips that returns these columns:
	the Disabled, and Billing ZipCode columns from the Addresses table and the LastName, FirstName columns from the Customers table. */

USE itse2333pbesp24;
DROP VIEW IF EXISTS kpolandsp242333.view_CustomerZips;
GO
CREATE VIEW kpolandsp242333.view_CustomerZips AS
	SELECT Disabled, ZipCode AS "Billing ZipCode", LastName, FirstName
	FROM kpolandsp242333.Addresses JOIN kpolandsp242333.Customers
	ON kpolandsp242333.Addresses.AddressID = kpolandsp242333.Customers.BillingAddressID;
GO


/* 2. Write a SELECT statement that returns all the columns from the view that you created in exercise 1.  Only return records with Zip Codes that begin with 5. */

SELECT *
FROM kpolandsp242333.view_CustomerZips
WHERE "Billing ZipCode" LIKE '5%';


/* 3. Write an UPDATE statement that updates the view you created in exercise 1 so it changes the disabled column from 0 to 1 for all addresses with zip codes that begin with 5.
	Then, run the SELECT statement you wrote in exercise 2 to be sure this worked correctly. */

UPDATE kpolandsp242333.view_CustomerZips
SET Disabled = 1
WHERE "Billing ZipCode" LIKE '5%';


/* 4. Create a view named LastnameFirstInitialsmYR.view_GuitarOwners that returns these columns:
	the FirstName and LastName from the Customers table and the ProductsName from the Products table for customers that have ordered guitars. */

USE itse2333pbesp24;
DROP VIEW IF EXISTS kpolandsp242333.view_GuitarOwners;
GO
CREATE VIEW kpolandsp242333.view_GuitarOwners AS
	SELECT FirstName, LastName, ProductName
	FROM kpolandsp242333.Customers
	JOIN kpolandsp242333.Orders
	ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
	JOIN kpolandsp242333.OrderItems
	ON kpolandsp242333.Orders.OrderID = kpolandsp242333.OrderItems.OrderID
	JOIN kpolandsp242333.Products
	ON kpolandsp242333.OrderItems.ProductID = kpolandsp242333.Products.ProductID
	WHERE kpolandsp242333.Products.CategoryID = 1;
GO


/* 5. Write a SELECT statement that returns these columns from the view that you created in exercise 4: LastName, FirstName for customers that ordered Fender Stratocasters.
	Sort the results by FirstName. */

SELECT LastName, FirstName
FROM kpolandsp242333.view_GuitarOwners
WHERE ProductName = 'Fender Stratocaster'
ORDER BY FirstName;


/* 6. Create a view named LastnameFirstInitialsmYR.view_CustomerTotalOrders that Contains the columns LastName, FirstName from the Customers tables, and the sum of the orders placed by that particular customer.
	For each customer, you will need to multiply the quantity * list price in your sum. (you will need several joins)
	Group by lastname then firstname. */

USE itse2333pbesp24;
DROP VIEW IF EXISTS kpolandsp242333.view_CustomerTotalOrders;
GO
CREATE VIEW kpolandsp242333.view_CustomerTotalOrders AS
	SELECT LastName, FirstName, SUM(ItemPrice * Quantity) AS OrderSum
	FROM kpolandsp242333.Customers
	JOIN kpolandsp242333.Orders
	ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
	JOIN kpolandsp242333.OrderItems
	ON kpolandsp242333.Orders.OrderID = kpolandsp242333.OrderItems.OrderID
	GROUP BY LastName, FirstName;
GO


/* 7. Write a SELECT statement that uses the view that you created in exercise 6 to get the 3 customers with the highest Total purchases. Show all columns. */

SELECT TOP 3 *
FROM kpolandsp242333.view_CustomerTotalOrders
ORDER BY OrderSum DESC;


/* 8. Write a script that declares a variable and sets it to the count of customers with a billing State that is Texas.
	If the count is greater than to 25, the script should display a message that says, “The number of customers from Texas is greater than 25”.
	Otherwise, it should say, “The number of customers from Texas is 25 or less”. */

USE itse2333pbesp24;
DECLARE @TexasCustomers int;

SELECT @TexasCustomers = COUNT(*)
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.BillingAddressID = kpolandsp242333.Addresses.AddressID
WHERE State = 'TX';

IF @TexasCustomers > 25
	PRINT('The number of customers from Texas is greater than 25');
ELSE
	PRINT('The number of customers from Texas is 25 or less');


/* 9. Write a script that uses two variables to store (1) the number of guitars in the Products table and (2) the number of basses in the Products table. Display which count is greater. */

USE itse2333pbesp24;
DECLARE @GuitarCount int, @BassCount int;

SELECT @GuitarCount = COUNT(*) /* Initialize @GuitarCount */
FROM kpolandsp242333.Products
WHERE CategoryID = 1;

SELECT @BassCount = COUNT(*) /*Initialize @BassCount */
FROM kpolandsp242333.Products
WHERE CategoryID = 2;

IF @GuitarCount = @BassCount
	PRINT('The amount of Guitars (' + CAST(@GuitarCount AS varchar) + ') EQUALS the amount of Basses (' + CAST(@BassCount AS varchar) + ').');
ELSE
	IF @GuitarCount > @BassCount
		PRINT('The amount of Guitars (' + CAST(@GuitarCount AS varchar) + ') EXCEEDS the amount of Basses (' + CAST(@BassCount AS varchar) + ').');
	ELSE
		PRINT('The amount of Basses (' + CAST(@BassCount AS varchar) + ') EXCEEDS the amount of Guitars (' + CAST(@GuitarCount AS varchar) + ').');


/* 10. Write a script that creates a temporary table that includes all of the columns from the Products table.
      Loop through the temporary table as long as the average DiscountPercent is greater than 25.
	  Within the loop, decrease by .05 the discount percentage of each product.
	  Do not decrease the discount percentage of each product TO** less than 10 percent.
      Write a SELECT statement that returns the FirstName, LastName, and DiscountPercent from the temporary table. */

/* NOTE: There is no FirstName or LastName in the Product table so I used ProductCode and ProductName. */

USE itse2333pbesp24;
DROP TABLE IF EXISTS tempdb.#ProductsCopy;

SELECT * INTO #ProductsCopy
FROM kpolandsp242333.Products;

WHILE (SELECT AVG(DiscountPercent) FROM #ProductsCopy) > 25
	BEGIN
		UPDATE #ProductsCopy
		SET DiscountPercent = DiscountPercent - 0.05
		WHERE DiscountPercent >= 10.05
	END;

SELECT ProductCode, ProductName, DiscountPercent
FROM #ProductsCopy;