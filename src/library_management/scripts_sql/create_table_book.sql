CREATE TABLE IF NOT EXISTS "book" (
    id VARCHAR(100) PRIMARY KEY,
    book_name VARCHAR(100) NOT NULL,
    page_numbers INT CHECK(page_numbers > 0),
    topic VARCHAR(100) CHECK(topic ILIKE 'romance' OR topic ILIKE 'comedy' OR topic ILIKE 'other'),
    release_date DATE,
    status VARCHAR(100) CHECK(status ILIKE 'borrowed' OR status ILIKE 'available') DEFAULT 'available',
    id_author VARCHAR(100) REFERENCES author(id)
);

INSERT INTO "book" (id, book_name, page_numbers, topic, release_date, status, id_author)
VALUES ('bk1', 'Terminus Elicius', 300, 'other', '2005/03/05', 'available', 'auth1');
INSERT INTO "book" (id, book_name, page_numbers, topic, release_date, status, id_author)
VALUES ('bk2', 'Les misérables', 300, 'other', '1862/05/10', 'available', 'auth1');
INSERT INTO "book" (id, book_name, page_numbers, topic, release_date, status, id_author)
VALUES ('bk3', 'Harry Potter', 300, 'other', '2007/07/21', 'available', 'auth2');


