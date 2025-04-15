/* 1. Write an SQL query that uses a subquery to list products from the Products table
that have a greater than average list price. */

SELECT *
FROM kpolandsp242333.Products
WHERE ListPrice > (SELECT AVG(ListPrice) FROM kpolandsp242333.Products);


/* 2. Create a Select statement with a NOT EXISTS subquery to list Customer information from
the customers table that have no orders in the Orders Table. */

SELECT *
FROM kpolandsp242333.Customers
WHERE NOT EXISTS
	(SELECT *
	FROM kpolandsp242333.Orders
	WHERE kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID);


/* 3. Create a Select query that lists CustomerID, Last Name, OrderID and Card Type for
customers that have Orders that used a Visa card. */

SELECT kpolandsp242333.Customers.CustomerID, LastName, OrderID, CardType
FROM kpolandsp242333.Customers JOIN
	(SELECT * FROM kpolandsp242333.Orders WHERE CardType = 'Visa') AS DerivedOrders
ON kpolandsp242333.Customers.CustomerID = DerivedOrders.CustomerID
WHERE CardType = 'Visa';


/* 4. Create a Select query that lists CustomerID, Customer Last Name, OrderID and Order Date
for orders that were placed after the single order placed by the customer with CustomerID 22.
Use a Subquery. */

SELECT kpolandsp242333.Customers.CustomerID, LastName, OrderID, OrderDate
FROM kpolandsp242333.Customers JOIN kpolandsp242333.Orders
ON kpolandsp242333.Customers.CustomerID = kpolandsp242333.Orders.CustomerID
WHERE OrderDate > (SELECT OrderDate FROM kpolandsp242333.Orders WHERE CustomerID = 22)
ORDER BY OrderDate;



/*-------------------------------------------------------------------------------
	Important before you begin, run the following SQL commands.
	Replace the item in brackets [ ] with your information.
	This will create a copy of your Products and Categories tables.

	USE [Your Database];

	SELECT * 

	INTO [Your Schema].ProductsCopy

	FROM [Your Schema].Products */

	USE itse2333pbesp24;

	SELECT *
	INTO kpolandsp242333.ProductsCopy
	FROM kpolandsp242333.Products;

	DROP TABLE kpolandsp242333.ProductsCopy;

/*--------------------------------------------------------------------------------
	
	USE [Your Database];

	SELECT * 

	INTO [Your Schema].CategoriesCopy

	FROM [Your Schema].Categories */

	USE itse2333pbesp24;

	SELECT *
	INTO kpolandsp242333.CategoriesCopy
	FROM kpolandsp242333.Categories;

	DROP TABLE kpolandsp242333.CategoriesCopy;

/*--------------------------------------------------------------------------------*/



/* 5. Insert into the CategoriesCopy table a new category named ‘Horns’. */

INSERT INTO kpolandsp242333.CategoriesCopy
VALUES ('Horns');


/* 6. Insert into the ProductsCopy table a new product with the data for a saxophone.
You can look up info for saxophone online at a website like GuitarCenter.com.
Use the CategoryID for horns and today’s date and time. */

INSERT INTO kpolandsp242333.ProductsCopy
VALUES (5, 'etude', 'Etude EAS-200 Student Series Alto Saxophone Lacquer',
'The Etude EAS-200 Student Series alto saxophone is an ideal instrument for beginner saxophonists.
Its durable yet lightweight design and high-quality components allow students to achieve a beautiful tone as they learn proper playing technique.
The EAS-200 features premium-grade valves, pads and springs for enhanced playability and reduced sticking.
Its adjustable thumb rest and comfortable hand position also make it easy for students of any age to handle and play with confidence.',
399.99, 25.00, GETDATE());


/* 7. Update the ProductsCopy table to change the price of the Fender Stratocaster from
$699 to $899. */

UPDATE kpolandsp242333.ProductsCopy
SET ListPrice = 899.00
WHERE ProductID = 1;


/* 8. Delete the saxophone record you added in query 6. */

DELETE FROM kpolandsp242333.ProductsCopy
WHERE ProductCode = 'etude';


/* 9. Update the ProductsCopy table to add 5 dollars to the discount for all drums. */

UPDATE kpolandsp242333.ProductsCopy
SET DiscountPercent = (DiscountPercent + 5.00)
WHERE CategoryID = 3;


/* 10. Delete all records with a list price less than $500 from the ProductsCopy table. */

DELETE FROM kpolandsp242333.ProductsCopy
WHERE ListPrice < 500.00;