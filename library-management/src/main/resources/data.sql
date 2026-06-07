ALTER TABLE authors ALTER COLUMN id RESTART WITH 10;
ALTER TABLE categories ALTER COLUMN id RESTART WITH 10;
ALTER TABLE books ALTER COLUMN id RESTART WITH 10;
ALTER TABLE members ALTER COLUMN id RESTART WITH 10;
ALTER TABLE borrowing_records ALTER COLUMN id RESTART WITH 10;


-- Categories
INSERT INTO categories (id, name) VALUES (1, 'Fiction');
INSERT INTO categories (id, name) VALUES (2, 'Science');
INSERT INTO categories (id, name) VALUES (3, 'History');
INSERT INTO categories (id, name) VALUES (4, 'Technology');

-- Authors
INSERT INTO authors (id, first_name, last_name, email) VALUES (1, 'George', 'Orwell', 'george@example.com');
INSERT INTO authors (id, first_name, last_name, email) VALUES (2, 'Stephen', 'Hawking', 'stephen@example.com');
INSERT INTO authors (id, first_name, last_name, email) VALUES (3, 'Yuval', 'Harari', 'yuval@example.com');

-- Books
INSERT INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (1, '1984', '978-0451524935', 1949, 5, 1, 1);
INSERT INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (2, 'Animal Farm', '978-0451526342', 1945, 3, 1, 1);
INSERT INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (3, 'A Brief History of Time', '978-0553380163', 1988, 4, 2, 2);
INSERT INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (4, 'Sapiens', '978-0062316097', 2011, 6, 3, 3);

-- Members
INSERT INTO members (id, first_name, last_name, email, phone, membership_date, role) VALUES (1, 'Sobia', 'Bashir', 'sobia@example.com', '0739818941', '2024-01-01', 'ADMIN');
INSERT INTO members (id, first_name, last_name, email, phone, membership_date, role) VALUES (2, 'Ali', 'Ahmed', 'ali@example.com', '0700111222', '2024-02-01', 'MEMBER');
INSERT INTO members (id, first_name, last_name, email, phone, membership_date, role) VALUES (3, 'Sara', 'Malik', 'sara@example.com', '0700333444', '2024-03-01', 'MEMBER');

-- Borrowing Records
INSERT INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (1, '2024-05-01', '2024-05-15', 'RETURNED', 1, 2);
INSERT INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (2, '2024-06-01', null, 'BORROWED', 3, 3);
INSERT INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (3, '2024-06-03', null, 'BORROWED', 4, 2);