CREATE TABLE IF NOT EXISTS "subscriber" (
    id VARCHAR(100) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL, -- for age restriction
    reference VARCHAR(100) NOT NULL
);

INSERT INTO "subscriber" (id, name, birthdate, reference)
VALUES ('subs1', 'Sophie Martin', 'jklk011');

INSERT INTO "subscriber" (id, name, birthdate, reference)
VALUES ('subs2', 'Lucas Dupont','djkh232');

INSERT INTO "subscriber" (id, name,birthdate, reference)
VALUES ('subs3', 'Marie Leblanc','mpol326');
