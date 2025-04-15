/* 1. Write a SELECT Query with a JOIN that displays the customers first and last name as full name
and their billing address city, state, and zipcode. Only show records for customers from
New York and New Jersey. */

SELECT FirstName + ' ' + LastName AS "Full Name", City, State, ZipCode
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.BillingAddressID = kpolandsp242333.Addresses.AddressID
WHERE State = 'NY' OR State = 'NJ';


/* 2. Write a SELECT Query with a join that displays customers first and last name and their
order id's and order dates.The query should also show customer names for customers with no orders. */

SELECT FirstName, LastName, OrderID, OrderDate
FROM kpolandsp242333.Customers LEFT OUTER JOIN kpolandsp242333.Orders
ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID;


/* 3. Create a SELECT query with a join that display all products from the product table and their
category name from the category table. The query should also show category names that have no
products in the products table. */

SELECT Products.*, CategoryName
FROM kpolandsp242333.Products RIGHT OUTER JOIN kpolandsp242333.Categories
ON kpolandsp242333.Products.CategoryID = kpolandsp242333.Categories.CategoryID;


/* 4. Create two SELECT queries that show customer names, city and zipcode for the
customers shipping and billing addresses respectively. Create a UNION between the queries to show
unique cities and zips associated with a customer NO duplicates. Sort by the zipcodes. */

SELECT FirstName, LastName, City, ZipCode
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.ShippingAddressID = kpolandsp242333.Addresses.AddressID
UNION
SELECT FirstName, LastName, City, ZipCode
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.BillingAddressID = kpolandsp242333.Addresses.AddressID
ORDER BY ZipCode;


/* 5. Create two SELECT queries that show customer names, city and zipcode for the
customers shipping and billing addresses respectively. Create a UNION between the queries to
show cities and zips associated with customer duplicates included. Sort by the zip codes. */

SELECT FirstName, LastName, City, ZipCode
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.ShippingAddressID = kpolandsp242333.Addresses.AddressID
UNION ALL
SELECT FirstName, LastName, City, ZipCode
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Addresses
ON kpolandsp242333.Customers.BillingAddressID = kpolandsp242333.Addresses.AddressID
ORDER BY ZipCode;


/* 6. Create a SELECT query that gives the count of Orders as Count of Orders and total of the
items purchased (Price * Quantity) as Total Items Purchased from the orders table or
related tables for orders. This is the amount calculated before discounts. */

SELECT COUNT(DISTINCT OrderID) AS "Count of Orders", SUM(ItemPrice * Quantity) AS "Total Items Purchased"
FROM kpolandsp242333.OrderItems;


/* 7. Create a SELECT query that gives you the average tax amount for all orders. */

SELECT AVG(TaxAmount) AS "Average Tax"
FROM kpolandsp242333.Orders;


/* 8. Create a SELECT query that shows the customers first and last name and the total of
their orders before discounts. Group by first within last name. For this query you will have to
perform joins on 3 tables. */

SELECT FirstName, LastName, SUM(ItemPrice * Quantity) + SUM(DISTINCT ShipAmount + TaxAmount) AS "Order Total"
FROM kpolandsp242333.Customers
	JOIN kpolandsp242333.Orders ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
	JOIN kpolandsp242333.OrderItems ON kpolandsp242333.Orders.OrderID = kpolandsp242333.OrderItems.OrderID
GROUP BY FirstName, LastName;


/* 9. Create a SELECT query that will show the price of the most expensive guitar in the
products table and has a discountpercent greater than or equal to 30.00. */

SELECT MAX(ListPrice) AS "Most Expensive Guitar"
FROM kpolandsp242333.Products
WHERE DiscountPercent >= 30.00 AND CategoryID = 1;


/* 10. Create a SELECT query that will show the customers id, orders id, and the shipping for
each order. Show them in order by customer id, and give a subtotal of the shipping after each
customer and a grand total at the end. */

SELECT kpolandsp242333.Orders.CustomerID, OrderID, SUM(ShipAmount) AS "Shipping"
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Orders
ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
GROUP BY ROLLUP (kpolandsp242333.Orders.CustomerID, OrderID);