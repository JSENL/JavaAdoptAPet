DROP TABLE IF EXISTS adoptable_pets;
CREATE TABLE adoptable_pets (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    img_url VARCHAR(255) NOT NULL,
    age INTEGER,
    vaccination_status BOOLEAN,
    adoption_story VARCHAR(255) NOT NULL,
    adoption_status VARCHAR(255) NOT NULL,
    pet_type_id INTEGER REFERENCES pet_types(id)
);