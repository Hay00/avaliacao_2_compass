USE teste;

DROP TABLE IF EXISTS emoticons;

CREATE TABLE emoticons (
    id INT NOT NULL AUTO_INCREMENT,
    sentiment VARCHAR(255),
    PRIMARY KEY (id)
);