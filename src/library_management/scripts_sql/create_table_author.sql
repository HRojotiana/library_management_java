CREATE TABLE IF NOT EXISTS "author"(
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    sex VARCHAR(1) CHECK(sex ILIKE 'F' OR sex ILIKE 'M')
);

INSERT INTO "author" (id, name, sex)  VALUES ('auth1', 'Karine Giebel', 'F');
INSERT INTO "author" (id, name, sex)  VALUES ('auth2', 'J.K Rowling', 'F');
INSERT INTO "author" (id, name, sex)  VALUES ('auth3', 'Victor Hugo', 'M');
