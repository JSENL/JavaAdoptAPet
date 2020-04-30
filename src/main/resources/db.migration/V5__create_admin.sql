
DROP TABLE IF EXISTS admin_table;
CREATE TABLE admin_table (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);