/* 1. Design a database diagram for a database that stores ownership of an item. You can choose the item (examples: pets, games, luxury items, etc.)
Each Owner must have an email address, phone number,  first name, and last name, and birth date.
	*Each user can own multiple items.
	*Each item can be owned by multiple owners.
	*Design a table for the items with 6 fields that represent relevant information for the item you chose.
	*Your Design needs to have a way to link owners to items.
	*Submit a diagram of your design. */

/* SUBMITTED AS PDF */



/* 2. Write a script that implements the database designed in Exercise 1. Name the database Module5Mastery_LastNameFirstInitial_smYR (ex Module5Mastery_HallK_FA22)
	Create the Primary and Foreign keys based on your designs.

	Include a statement to drop the database if it already exists.

	Include statements to create and select the database.

	Include indexes for the foreign keys. */

USE master;
DROP DATABASE IF EXISTS Module5Mastery_PolandK_SP24;
GO
CREATE DATABASE Module5Mastery_PolandK_SP24;
GO

USE Module5Mastery_PolandK_SP24;

CREATE TABLE Owners
(OwnerID		INT				NOT NULL PRIMARY KEY IDENTITY,
FirstName		varchar(255)	NOT NULL,
LastName		varchar(255)	NOT NULL,
BirthDate		date			NOT NULL,
Email			varchar(255)	NOT NULL,
Phone			varchar(50)		NOT NULL);

CREATE TABLE Games
(GameID			INT				NOT NULL PRIMARY KEY IDENTITY,
Title			varchar(255)	NOT NULL,
Price			smallmoney, /* Games can be free. */
PlayerLimit		int				NOT NULL,
ReleaseDate		date			NOT NULL, /* For an owner to own a game, it must already be released. */
Genre			varchar(255)	NOT NULL,
Platform		varchar(255)	NOT NULL)

CREATE TABLE GameOwnerships
(OwnerID		INT				NOT NULL REFERENCES Owners(OwnerID),
GameID			INT				NOT NULL REFERENCES Games(GameID),
PRIMARY KEY (OwnerID, GameID)); /* Composite Primary Key: Avoids Duplicate Combinations and creates a CLUSTERED INDEX on both foriegn keys. */



/* 3. Write a script that adds rows to the database that you created in exercise 2.
	Add three rows to the Owners tables.

	Add 5 rows to the table that stores the items.  You choose who owns the items, but at least one of the items must be owned by two Owners.  All items must be owned.

	Write a SELECT statement that joins the three tables and gives a report of owners and all items owned, show in order by owner name. */

/* Owners */
INSERT INTO Module5Mastery_PolandK_SP24.dbo.Owners
VALUES ('Harold', 'Ligmar', '10/23/94', 'hey_ligmar@gmail.com', '(123) 456-7890'),
	   ('Jimithy', 'Geraldson', '02/11/91', 'jimgerald@yahoo.com', '(342) 780-1010'),
	   ('Linda', 'Reddi', '07/18/76', 'im_reddi@sbcglobal.net', '(900) 652-8935');

/* Games */
INSERT INTO Module5Mastery_PolandK_SP24.dbo.Games
VALUES ('Final Fantasy IX', 29.99, 1, '07/07/00', 'Role Playing Game', 'Playstation'),
	   ('The Elder Scrolls III: Morrowind', 19.99, 1, '05/01/02', 'Role Playing Game', 'PC'),
	   ('Bioshock', 39.99, 1, '08/21/07', 'First Person Shooter', 'Playstation 3'),
	   ('Phoenix Wright: Ace Attorney', 14.99, 1, '10/12/01', 'Visual Novel', 'Gameboy Advance'),
	   ('Halo 2', 19.99, 2, '11/09/04', 'First Person Shooter', 'Xbox');

/* Game Ownerships */
INSERT INTO Module5Mastery_PolandK_SP24.dbo.GameOwnerships
VALUES (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (2, 3), (2, 5), (3, 4);

/* View Owned Games */
SELECT FirstName + ' ' + LastName AS Owner, BirthDate, Title, ReleaseDate
FROM Module5Mastery_PolandK_SP24.dbo.Owners
JOIN Module5Mastery_PolandK_SP24.dbo.GameOwnerships ON Module5Mastery_PolandK_SP24.dbo.Owners.OwnerID = Module5Mastery_PolandK_SP24.dbo.GameOwnerships.OwnerID
JOIN Module5Mastery_PolandK_SP24.dbo.Games ON Module5Mastery_PolandK_SP24.dbo.GameOwnerships.GameID = Module5Mastery_PolandK_SP24.dbo.Games.GameID
ORDER BY Owner;



/* 4. Write an ALTER TABLE statement that adds two new columns to the Owners table created in exercise 2. You choose the items, but they should store relevant values.*/

ALTER TABLE Module5Mastery_PolandK_SP24.dbo.Owners
ADD FavoriteGame varchar(255) NULL,
	FavoritePlatform varchar(255) NULL;



/* 5. Write an ALTER TABLE statement that modifies the Owners so the EmailAddress column can store a maximum of 45 characters.
	Code another UPDATE statement that attempts to insert an email address that’s longer than 45 characters. It should fail due to the length of the column. */

ALTER TABLE Module5Mastery_PolandK_SP24.dbo.Owners
ALTER COLUMN Email varchar(45);

UPDATE Module5Mastery_PolandK_SP24.dbo.Owners
SET Email = 'really_long_and_unnecessary_email_address@mymail.tstc.edu'
WHERE OwnerID = 1;



/* 6. Write an ALTER TABLE statement that modifies the Owners table created in exercise 1 so the EmailAddress column must be unique.
	Code an UPDATE statement that attempts to insert a non-unique value into this column. It should fail due to the unique constraint.*/

ALTER TABLE Module5Mastery_PolandK_SP24.dbo.Owners
ADD UNIQUE (Email);

UPDATE Module5Mastery_PolandK_SP24.dbo.Owners
SET Email = 'hey_ligmar@gmail.com'
WHERE (FirstName + LastName) = 'LindaReddi';