-- create database, drop if exists
DROP DATABASE IF EXISTS poland_module6;
CREATE DATABASE poland_module6;
USE poland_module6;

-- authors table
CREATE TABLE authors
(
	author_id int PRIMARY KEY AUTO_INCREMENT,
    author_first_name varchar(100) NOT NULL,
    author_last_name varchar(100) NOT NULL,
    author_code varchar(100) UNIQUE NOT NULL
);
INSERT INTO authors VALUES
(DEFAULT, 'Frank', 'Herbert', 'FH145'),
(DEFAULT, 'George', 'Orwell', 'GO198'),
(DEFAULT, 'Ayn', 'Rand', 'AR808'),
(DEFAULT, 'Edward', 'Wortis', 'EW231'),
(DEFAULT, 'Suzanne', 'Collins', 'SC100');

-- genres table
CREATE TABLE genres
(
	genre_id int PRIMARY KEY AUTO_INCREMENT,
    genre_name varchar(100) NOT NULL
);
INSERT INTO genres VALUES
(DEFAULT, 'Science Fiction'),
(DEFAULT, 'Dystopian'),
(DEFAULT, 'Philosophy'),
(DEFAULT, 'Children''s Fiction'),
(DEFAULT, 'Biography');

-- students table
CREATE TABLE students
(
	student_id int PRIMARY KEY AUTO_INCREMENT,
    student_first_name varchar(100) NOT NULL,
    student_last_name varchar(100) NOT NULL,
    student_phone int NOT NULL
);
INSERT INTO students VALUES
(DEFAULT, 'David', 'Castello', 9908765),
(DEFAULT, 'Helen', 'Gruntman', 9991023),
(DEFAULT, 'Nigel', 'Tief', 4567890),
(DEFAULT, 'Michael', 'Fork', 1002000),
(DEFAULT, 'Jimmy', 'Dean', 5559000),
(DEFAULT, 'Melissa', 'Garfield', 7779921),
(DEFAULT, 'Mark', 'Torrez', 5558888);

-- books table
CREATE TABLE books
(
	book_id int PRIMARY KEY AUTO_INCREMENT,
    book_isbn bigint NOT NULL,
    book_title varchar(100) NOT NULL,
    book_author_id int NOT NULL,
	book_genre_id int NOT NULL,
    FOREIGN KEY (book_author_id) REFERENCES authors(author_id),
    FOREIGN KEY (book_genre_id) REFERENCES genres(genre_id)
);
INSERT INTO books VALUES
(DEFAULT, 425054713, 'Dune', 1, 1),
(DEFAULT, 452284236, '1984', 2, 2),
(DEFAULT, 451191153, 'The Fountainhead', 3, 3),
(DEFAULT, 380727692, 'Poppy', 4, 4),
(DEFAULT, 380976900, 'Ragweed', 4, 4),
(DEFAULT, 9780439023528, 'The Hunger Games', 5, 2);

-- loans table
CREATE TABLE loans
(
	 loan_id int PRIMARY KEY AUTO_INCREMENT,
     loan_date date NOT NULL,
     loan_due_date date NOT NULL,
     loan_status varchar(100) NOT NULL,
     loan_book_id int NOT NULL,
     loan_borrower_id int NOT NULL,
     FOREIGN KEY (loan_book_id) REFERENCES books(book_id),
     FOREIGN KEY (loan_borrower_id) REFERENCES students(student_id)
);
INSERT INTO loans VALUES
(DEFAULT, '2022-12-05', '2022-12-12', 'Loaned', 1, 1),
(DEFAULT, '2022-11-12', '2022-11-19', 'Returned', 2, 2),
(DEFAULT, '2022-10-20', '2022-10-27', 'Loaned', 3, 3),
(DEFAULT, '2022-12-01', '2022-12-08', 'Returned', 4, 4),
(DEFAULT, '2022-10-02', '2022-12-09', 'Returned', 5, 5),
(DEFAULT, '2022-11-20', '2022-11-27', 'Loaned', 6, 6),
(DEFAULT, '2022-10-12', '2022-10-19', 'Returned', 2, 7);


-- Order in which to drop tables

-- DROP TABLE loans;
-- DROP TABLE books;
-- DROP TABLE authors;
-- DROP TABLE students;
-- DROP TABLE genres;


-- Example Queries

-- Query 1: List of currently loaned books with the full borrower name and loan ID
SELECT loan_id AS 'Loan ID', book_title AS 'Title', CONCAT(student_first_name, ' ', student_last_name) AS 'Borrower', loan_status AS 'Status'
FROM loans lo 
JOIN students st
    ON lo.loan_borrower_id = st.student_id
JOIN books bo
    ON lo.loan_book_id = bo.book_id
WHERE loan_status <> 'Returned';

-- Query 2: Total books loaned in October
SELECT COUNT(*) AS 'Total October Books Loaned'
FROM loans
WHERE MONTH(loan_date) = 10;

-- Query 3: List of all genres and the amount of books in each genre
SELECT genre_name AS 'Genre', COUNT(book_genre_id) AS 'Books in Genre'
FROM genres ge LEFT OUTER JOIN books bo
	ON ge.genre_id = bo.book_genre_id
GROUP BY genre_id
ORDER BY COUNT(book_genre_id) DESC;

-- Query 4: List all non-overdue loans that haven't been returned yet
SELECT loan_id AS 'Loan ID', loan_due_date AS 'Date Due', DATEDIFF(loan_due_date, CURDATE()) AS 'Days Until Due'
FROM loans
WHERE loan_due_date >= CURDATE() AND loan_status <> 'Returned';

-- Query 5: List of all authors with more than one book available, with the amount they have available
SELECT CONCAT(author_first_name, ' ', author_last_name) AS 'Author', COUNT(book_author_id) AS 'Books by Author'
FROM authors au JOIN books bo
	ON au.author_id = bo.book_author_id
GROUP BY author_id
HAVING COUNT(book_author_id) > 1;

-- Query 6: List of all books with their author and ISBN
SELECT book_title AS 'Title', CONCAT(author_first_name, ' ', author_last_name) AS 'Author', book_isbn AS 'ISBN'
FROM books bo JOIN authors au
	ON bo.book_author_id = au.author_id
ORDER BY book_title;