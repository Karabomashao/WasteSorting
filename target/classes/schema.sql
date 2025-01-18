CREATE TABLE IF NOT EXISTS Waste_classification (
    classification_id INT AUTO_INCREMENT PRIMARY KEY,
    waste_classification VARCHAR(100),
    description TEXT
);

-- CREATE TABLE IF NOT EXISTS Hazardous_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
--     );
--
-- CREATE TABLE IF NOT EXISTS Non_hazardous_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );
--
-- CREATE TABLE IF NOT EXISTS Recyclable_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );
--
-- CREATE TABLE IF NOT EXISTS Non_recyclable_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );
--
-- CREATE TABLE IF NOT EXISTS E_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );
--
-- CREATE TABLE IF NOT EXISTS Organic_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );
--
-- CREATE TABLE IF NOT EXISTS Special_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );
--
-- CREATE TABLE IF NOT EXISTS Construction_and_demolition_waste (
--     waste_id INT PRIMARY KEY,
--     type_of_waste TEXT,
--     waste_examples TEXT
-- );

CREATE TABLE IF NOT EXISTS Waste_Types (
    waste_id INT AUTO_INCREMENT PRIMARY KEY,
    type_of_waste TEXT,
    waste_examples TEXT,
    classification_id INT,
    FOREIGN KEY (classification_id) REFERENCES Waste_classification (classification_id)
);