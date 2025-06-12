SQL command to create database usable in the project:

CREATE DATABASE IF NOT EXISTS autoCRUDmvc;
USE autoCRUDmvc;

CREATE TABLE Items (
	ItemID INT NOT NULL AUTO_INCREMENT,
    ItemName CHAR(255) NOT NULL,
    ItemType CHAR(255) NOT NULL,
    ItemValue DOUBLE(255, 2) UNSIGNED,
    ItemStock MEDIUMINT NOT NULL,
    PRIMARY KEY(ItemID)
);

INSERT INTO Items (ItemName, ItemType, ItemValue, ItemStock) VALUES
("Ajazz AK680", "Keyboard", 179.99, 80),
("Razer Viper Mini", "Mouse", 299.99, 50),
("XFX RX 6650 XT", "Video Card", 1799.99, 30);
