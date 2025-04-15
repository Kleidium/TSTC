USE itse2333pbesp24;


/* 1. Write a SELECT statement that returns all of the columns from the Customers table. */
SELECT * FROM kpolandsp242333.Customers;


/* 2. Write a SELECT statement that returns three columns from the Customers table: LastName, FirstName, EmailAddress.
Return only the customers who have a CustomerID from 100-200 inclusively.  Also, ORDER BY LastName in descending order. */
SELECT LastName, FirstName, EmailAddress
FROM kpolandsp242333.Customers
WHERE CustomerID >= 100 AND CustomerID <= 200
ORDER BY LastName DESC;


/* 3. Write a SELECT statement that returns the following columns from the Customers table:
FullName that joins LastName and FirstName columns (Format this column with the last name, a comma, and the first name like this:  Doe, John),
EmailAddress that uses the Email column, ShippingAddress that uses the Shipping Address column, BillingAddress that uses the Billing Address column.
Sort the result set by last name in ascending sequence.  Return only the customers whose last name begins with a letter from P to S. */
SELECT (LastName + ', ' + FirstName) AS FullName, EmailAddress AS Email, ShippingAddressID AS "Shipping Address", BillingAddressID AS "Billing Address"
FROM kpolandsp242333.Customers
WHERE LastName LIKE '[P-S]%'
ORDER BY LastName;


/* 4. Write a SELECT statement that returns the following from the Customers table: FirstName, LastName.
Return only the customers whose FirstName follows this format: ‘ eddy’ (first letter is anything in the alphabet). */
SELECT FirstName, LastName
FROM kpolandsp242333.Customers
WHERE FirstName LIKE '[A-Z]eddy';


/* 5. Write a SELECT statement that returns the following columns from the Students table:
FullName that joins FirstName and LastName columns (Format this column with the first name, a space, and the last name like this:  John Doe),
EnrollmentDate that uses the Enrollment Date column.  Sort the result set by last name in descending sequence.
Return only the students whose FirstName begins with the letter ‘b’. */
SELECT (FirstName + ' ' + LastName) AS FullName, EnrollmentDate AS "Enrollment Date"
FROM kpolandsp242333.Students
WHERE FirstName LIKE 'b%'
ORDER BY LastName DESC;


/* 6. Write a SELECT statement that returns the following from the Customers table: EmailAddress.
Return only the customers whose EmailAddress is from CustomerID’s 1-100 inclusively. */
SELECT EmailAddress
FROM kpolandsp242333.Customers
WHERE CustomerID >= 1 AND CustomerID <= 100;


/* 7. Write a SELECT statement that returns the following columns from the Products table:
ProductCode-Code column, ProductName-Product column, Description-as itself, ListPrice-Price column.
Sort the result set by product code in descending sequence.
Return only the products whose DateAdded includes the entire day of 2019-11-01. */
SELECT ProductCode AS Code, ProductName AS Product, Description, ListPrice AS Price
FROM kpolandsp242333.Products
WHERE datediff(day, DateAdded, '2019-11-01') = 0
ORDER BY ProductCode DESC;


/* 8. Write a SELECT statement that returns the following from the Vendors table: VendorName, VendorPhone.
Return only the vendors that have a city=Fresno and state = California.
Sort the result by the vendor name in descending order. */
SELECT VendorName, VendorPhone
FROM kpolandsp242333.Vendors
WHERE VendorCity = 'Fresno' AND VendorState = 'CA'
ORDER BY VendorName DESC;


/* 9. Write a SELECT statement that returns the following columns from the Products table:
ProductName-Product Name column, ListPrice-Price column, DiscountPercent-Discount Percent column.
Sort the result set by product name in ascending sequence.
Return only the products whose ProductCode includes the letters B-T inclusively as the first letter. */
SELECT ProductName AS "Product Name", ListPrice AS Price, DiscountPercent AS "Discount Percent"
FROM kpolandsp242333.Products
WHERE ProductCode LIKE '[B-T]%'
ORDER BY ProductName;


/* 10. Write a SELECT statement that returns the following columns from the Orders table:
CustomerID-Customer ID column, CardType-Credit Card Type column, CardNumber-Credit Card # column, CardExpires-Credit Card Expiration column.
Sort the result set by card number in descending sequence.
Return only the customer id and credit card info for whose CardType does not equal American Express and does not equal MasterCard. */
SELECT CustomerID AS "Customer ID", CardType AS "Credit Card Type", CardNumber AS "Credit Card #", CardExpires AS "Credit Card Expiration"
FROM kpolandsp242333.Orders
WHERE CardType <> 'American Express' AND CardType <> 'MasterCard'
ORDER BY CardNumber DESC;