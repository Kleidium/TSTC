/* 1. Write a SELECT statement that returns these columns from the Products table:
            The monthly 12 month payment (the List Price column + 30% of the List Price) divided by 12

            A column that uses the CAST function to return the monthly 12 month payment with 2 digits to the right of the decimal point

            A column that uses the CONVERT function to return the monthly 12 month payment as an integer

            A column that uses the CAST function to return the monthly 12 month payment as an varchar */


SELECT ((ListPrice * 1.30) / 12) AS "Base Monthly Payment", CAST(((ListPrice * 1.30) / 12) AS decimal(18, 2)) AS "Monthly Payment: Decimal",
	CONVERT(int, ((ListPrice * 1.30) / 12)) AS "Monthly Payment: Int", CAST(((ListPrice * 1.30) / 12) AS varchar) AS "Monthly Payment: Varchar"
FROM kpolandsp242333.Products;



/* 2. Write a SELECT statement that returns these columns from the Orders table:
            The ShipDate column

            A column that uses the CAST function to return the ShipDate column with its date only (year, month, and day)

            A column that uses the CAST function to return the ShipDate column with its full time only (hour, minutes, seconds, and milliseconds)

            A column that uses the CAST function to return the ShipDate column with just the year and month */


SELECT ShipDate, CAST(ShipDate AS date) AS "ShipDate: Date", CAST(ShipDate AS time) AS "ShipDate: Time", CAST(CAST(ShipDate AS date) AS char(7)) AS "ShipDate: Year/Month"
FROM kpolandsp242333.Orders;



/* 3. Write a SELECT statement that returns these columns from the Orders table:
            A column that uses the CONVERT function to return the OrderDate column in this format: MM/DD/YYYY.
			In other words, use 2-digit months and  days and a 4-digit year, and separate each date component with slashes.

            A column that uses the CONVERT function to return the OrderDate column with the date, and the hours and minutes on a 12-hour clock with an am/pm indicator.

            A column that uses the CONVERT function to return the OrderDate column with just the time in a 24-hour format, including the milliseconds.

            A column that uses the CONVERT function to return the OrderDate column with just the month and day. */


SELECT CONVERT(varchar, OrderDate, 101) AS "Date Slash Format", CONVERT(varchar, OrderDate, 0) AS "Date/Time AM/PM", CONVERT(varchar, OrderDate, 14) AS "Time 24hr",
	CONVERT(char(5), CONVERT(varchar, OrderDate, 1)) AS "Month/Day"
FROM kpolandsp242333.Orders;



/* 4. Write a SELECT statement that returns these columns from the Products table:
            The ListPrice column

            A column named Discount that is the result of multiplying the list price by the discount percentage (DiscountPercent / 100).

            A column named DiscountedPrice that subtracts the discount from the list price and is rounded to two decimal places. */


SELECT ListPrice, (ListPrice * (DiscountPercent / 100)) AS Discount, ROUND((ListPrice - (ListPrice * (DiscountPercent / 100))), 2) AS DiscountedPrice
FROM kpolandsp242333.Products;



/* 5. Write a SELECT statement that returns these columns from the Products table:
            The DateAdded column

            A column that returns the four-digit year that’s stored in the DateAdded column

            A column that returns only the day of the month that’s stored in the DateAdded column

            A column that returns the result from adding two years to the DateAdded column; use the CAST function so only the year is returned */


SELECT DateAdded, LEFT(CAST(DateAdded AS date), 4) AS Year, SUBSTRING(CAST(CAST(DateAdded AS date) AS varchar), 9, 2) AS Day, CAST(CAST(DATEADD(year, 2, DateAdded) AS date) AS char(4)) AS "Year + 2"
FROM kpolandsp242333.Products;



/* 6. Write a SELECT statement that returns these columns:
            The FirstName column from the Customers table

            The Last Name column from the Customers table

            The CardNumber column from the Orders table

			Add a column that includes the first letter from the FirstName column, concatenated with the first three letters from the LastName column, and the last 4 digits from CardNumber column. */


SELECT FirstName, LastName, CardNumber, LEFT(FirstName, 1) + LEFT(LastName, 3) + RIGHT(CardNumber, 4) AS Solution
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Orders
ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
ORDER BY FirstName;



/* 7. Write a SELECT statement that returns these columns from the Customers and Orders tables where CustomerIDs match between orders and customers:
            The FirstName column

            The LastName column

            The OrderDate column

            The ShipDate column

            A column that shows the number of minutes between the OrderDate and ShipDate columns */


SELECT FirstName, LastName, OrderDate, ShipDate, DATEDIFF(minute, OrderDate, ShipDate) AS "Minutes Passed"
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Orders
ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
ORDER BY "Minutes Passed";



/* 8. Create unique @guitarking.com emails for customers with data from the Customers and Addresses table. Create a Select statement that returns the following concatenated string for each customer:

			The first two letters of the first of the first name

			The first three letters from the last name

			The customerID converted to a varchar

			The zip code

			The literal string ‘@guitarking.com’ */

/* NOTE: To help avoid giving customers more than one unique email based on them having two different addresses for billing/shipping, I joined tables
based on Billing Address instead of Customer ID. */


SELECT DISTINCT LEFT(FirstName, 2) + Left(LastName, 3) + CAST(kpolandsp242333.Customers.CustomerID AS varchar) + ZipCode + '@guitarking.com' AS Email
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.BillingAddressID = kpolandsp242333.Addresses.AddressID
ORDER BY Email;



/* 9. Modify the query from question 7 to only show records with [shipped] orders. */

/*NOTE: I reworded the question per our conversation regarding this. */


SELECT FirstName, LastName, OrderDate, ShipDate, DATEDIFF(minute, OrderDate, ShipDate) AS "Minutes Passed"
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Orders
ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
WHERE ShipDate IS NOT NULL
ORDER BY "Minutes Passed";



/* 10. Modify the query from question 8 create emails only for customers not from California. */

/* NOTE: Billing Addresses are not necessarily where a customer lives. Neither are their Shipping Addresses. 
For now, I assumed that a customer's Billing Address is more likely to be their home than the Shipping Address. */


SELECT DISTINCT LEFT(FirstName, 2) + Left(LastName, 3) + CAST(kpolandsp242333.Customers.CustomerID AS varchar) + ZipCode + '@guitarking.com' AS Email
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.BillingAddressID = kpolandsp242333.Addresses.AddressID
WHERE State <> 'CA'
ORDER BY Email;