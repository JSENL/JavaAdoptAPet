DROP TABLE IF EXISTS pet_types;
CREATE TABLE pet_types(
    id SERIAL PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE UNIQUE INDEX index ON pet_types(type);


