INSERT IGNORE INTO categories (id, name) VALUES (1, 'Fiction');
INSERT IGNORE INTO categories (id, name) VALUES (2, 'Science');
INSERT IGNORE INTO categories (id, name) VALUES (3, 'History');
INSERT IGNORE INTO categories (id, name) VALUES (4, 'Technology');
INSERT IGNORE INTO categories (id, name) VALUES (5, 'Biography');
INSERT IGNORE INTO categories (id, name) VALUES (6, 'Self Help');
INSERT IGNORE INTO categories (id, name) VALUES (7, 'Philosophy');
INSERT IGNORE INTO categories (id, name) VALUES (8, 'Psychology');
INSERT IGNORE INTO categories (id, name) VALUES (9, 'Business');
INSERT IGNORE INTO categories (id, name) VALUES (10, 'Science Fiction');

INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (1, 'George', 'Orwell', 'george@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (2, 'Stephen', 'Hawking', 'stephen@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (3, 'Yuval', 'Harari', 'yuval@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (4, 'Dale', 'Carnegie', 'dale@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (5, 'Walter', 'Isaacson', 'walter@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (6, 'Paulo', 'Coelho', 'paulo@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (7, 'Malcolm', 'Gladwell', 'malcolm@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (8, 'Frank', 'Herbert', 'frank@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (9, 'J.K.', 'Rowling', 'jk@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (10, 'Robert', 'Kiyosaki', 'robert@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (11, 'Viktor', 'Frankl', 'viktor@example.com');
INSERT IGNORE INTO authors (id, first_name, last_name, email) VALUES (12, 'Fyodor', 'Dostoevsky', 'fyodor@example.com');


INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (1, '1984', '978-0451524935', 1949, 5, 1, 1);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (2, 'Animal Farm', '978-0451526342', 1945, 3, 1, 1);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (3, 'A Brief History of Time', '978-0553380163', 1988, 4, 2, 2);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (4, 'Sapiens', '978-0062316097', 2011, 6, 3, 3);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (5, 'How to Win Friends', '978-0671027032', 1936, 4, 4, 6);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (6, 'Steve Jobs', '978-1451648539', 2011, 3, 5, 5);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (7, 'The Alchemist', '978-0062315007', 1988, 5, 6, 1);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (8, 'Outliers', '978-0316017930', 2008, 4, 7, 8);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (9, 'Dune', '978-0441013593', 1965, 3, 8, 10);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (10, 'Harry Potter and the Philosophers Stone', '978-0439708180', 1997, 6, 9, 1);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (11, 'Rich Dad Poor Dad', '978-1612680194', 1997, 5, 10, 9);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (12, 'Mans Search for Meaning', '978-0807014295', 1946, 4, 11, 7);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (13, 'The Brothers Karamazov', '978-0374528379', 1880, 2, 12, 1);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (14, 'Homo Deus', '978-0062464316', 2015, 4, 3, 3);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (15, 'The Tipping Point', '978-0316346627', 2000, 3, 7, 8);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (16, 'Leonardo da Vinci', '978-1501139154', 2017, 3, 5, 5);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (17, 'The Grand Design', '978-0553384666', 2010, 2, 2, 2);
INSERT IGNORE INTO books (id, title, isbn, published_year, available_copies, author_id, category_id) VALUES (18, 'Crime and Punishment', '978-0486415871', 1866, 3, 12, 1);

INSERT IGNORE INTO members (id, first_name, last_name, email, phone, membership_date, role, password) VALUES (1, 'Sobia', 'Bashir', 'sobiaasim2017@gmail.com', '0739818941', '2024-01-01', 'ADMIN',
'$2a$10$PYWo8hJ/omneF2G9ankOzuIg0B.zAuMY4TjtXtSjoscZ2xFpkLRhe');
INSERT IGNORE INTO members (id, first_name, last_name, email, phone, membership_date, role, password) VALUES (2, 'Ali', 'Ahmed', 'sobiabashir_786@hotmail.com', '0700111222', '2024-02-01', 'MEMBER', '$2a$10$/QbhNRnCjs/Qi5i.VBn50uzqgxg0/ehebH7Nwjyiw2AWUxE09.QHO');
INSERT IGNORE INTO members (id, first_name, last_name, email, phone, membership_date, role, password) VALUES (3, 'Sara', 'Malik', 'saimashokat094@gmail.com', '0700333444', '2024-03-01', 'MEMBER', '$2a$10$/QbhNRnCjs/Qi5i.VBn50uzqgxg0/ehebH7Nwjyiw2AWUxE09.QHO');
INSERT IGNORE INTO members (id, first_name, last_name, email, phone, membership_date, role, password) VALUES (4, 'Ahmed', 'Khan', 'ahmed@example.com', '0700555666', '2024-04-01', 'MEMBER', '$2a$10$/QbhNRnCjs/Qi5i.VBn50uzqgxg0/ehebH7Nwjyiw2AWUxE09.QHO');
INSERT IGNORE INTO members (id, first_name, last_name, email, phone, membership_date, role, password) VALUES (5, 'Fatima', 'Zahra', 'fatima@example.com', '0700777888', '2024-05-01', 'MEMBER', '$2a$10$/QbhNRnCjs/Qi5i.VBn50uzqgxg0/ehebH7Nwjyiw2AWUxE09.QHO');



INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (1, '2024-05-01', '2024-05-15', 'RETURNED', 1, 2);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (2, '2024-06-01', '2024-06-20', 'RETURNED', 3, 3);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (3, '2024-06-03', null, 'BORROWED', 4, 2);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (4, '2024-07-01', null, 'BORROWED', 2, 3);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (5, '2024-07-10', '2024-07-25', 'RETURNED', 7, 4);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (6, '2024-08-01', null, 'BORROWED', 10, 5);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (7, '2024-08-05', null, 'BORROWED', 11, 4);
INSERT IGNORE INTO borrowing_records (id, borrow_date, return_date, status, book_id, member_id) VALUES (8, '2024-08-10', '2024-08-20', 'RETURNED', 9, 2);