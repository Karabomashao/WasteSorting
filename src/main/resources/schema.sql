CREATE TABLE IF NOT EXISTS Waste_classification (
    classification_id INT AUTO_INCREMENT PRIMARY KEY,
    waste_classification VARCHAR(100),
    description TEXT
);

CREATE TABLE IF NOT EXISTS Waste_Types (
    waste_id INT AUTO_INCREMENT PRIMARY KEY,
    type_of_waste TEXT,
    waste_examples TEXT,
    classification_id INT,
    FOREIGN KEY (classification_id) REFERENCES Waste_classification (classification_id)
);