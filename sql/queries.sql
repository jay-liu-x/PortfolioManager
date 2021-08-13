CREATE TABLE person
(
    name VARCHAR(50),
    email VARCHAR(50),
    PRIMARY KEY (email)

)

CREATE TABLE investmentAccount
(
    investmentId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    email VARCHAR(50),
    investmentValue DOUBLE,
    FOREIGN KEY (email) REFERENCES person (email)
)

CREATE TABLE cashAccount
(
    cashId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    date DATE,
    email VARCHAR(50),
    cashValue DOUBLE,
    FOREIGN KEY (email) REFERENCES person (email)

)

CREATE TABLE investments
(
    tradeId int NOT NULL AUTO_INCREMENT,
    investmentId int NOT NULL AUTO_INCREMENT,
    symbol VARCHAR(50),
    purchasePrice DOUBLE,
    purchaseDate DATE,
    date DATE,
    quantity INTEGER,
    closePrice DOUBLE,
    PRIMARY KEY (tradeId,investmentId),
    FOREIGN KEY (investmentId) REFERENCES investmentAccount(investmentId)

)
