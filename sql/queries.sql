DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS investmentAccount;
DROP TABLE IF EXISTS cashAccount;
DROP TABLE IF EXISTS investments;

CREATE TABLE person
(
    name VARCHAR(50),
    email VARCHAR(50),
    PRIMARY KEY (email)
);

CREATE TABLE investmentAccount
(
    investmentAccountId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    date DATE,
    email VARCHAR(50),
    investmentValue DOUBLE,
    FOREIGN KEY (email) REFERENCES person (email)
);

CREATE TABLE cashAccount
(
    cashId int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    date DATE,
    email VARCHAR(50),
    cashValue DOUBLE,
    FOREIGN KEY (email) REFERENCES person (email)

);

CREATE TABLE investments
(
    investmentId int NOT NULL AUTO_INCREMENT,
    investmentAccountId int NOT NULL,
    symbol VARCHAR(50),
    purchasePrice DOUBLE,
    purchaseDate DATE,
    date DATE,
    quantity INTEGER,
    closePrice DOUBLE,
    PRIMARY KEY (investmentId),
    FOREIGN KEY (investmentAccountId) REFERENCES investmentAccount(investmentAccountId)
);


USE conygre;

insert into person (name, email) values ('John Doe', 'j.d@citi.com');

insert into investmentAccount (name, date, email, investmentValue) values ('RRSP', '2021-01-01', 'j.d@citi.com', null);
insert into investmentAccount (name, date, email, investmentValue) values ('TFSA', '2021-02-01', 'j.d@citi.com', null);

insert into cashAccount (name, date, email, cashValue) values ('Chequing','2021-01-01', 'j.d@citi.com', null);
insert into cashAccount (name, date, email, cashValue) values ('Savings','2021-02-01', 'j.d@citi.com', null);


insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('ED', 198.52, '2020-01-25', 463.23, '2021-01-11', 15, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('EGP', 102.41, '2020-07-26', 136.74, '2020-09-19', 9, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('DWAQ', 308.29, '2020-09-14', 141.61, '2021-01-12', 36, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('FEO', 391.48, '2020-05-31', 308.68, '2021-01-17', 33, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('ACRE', 422.34, '2020-03-26', 260.24, '2020-07-10', 26, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('VLY', 140.13, '2020-10-13', 70.78, '2020-07-16', 22, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CCK', 315.04, '2020-06-19', 472.1, '2021-04-04', 7, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('JHS', 173.84, '2020-02-11', 423.37, '2020-08-08', 46, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('TNP^C', 213.18, '2020-03-13', 364.02, '2021-07-04', 44, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CLNT', 66.64, '2020-01-26', 225.57, '2020-10-29', 35, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('TANH', 333.18, '2020-03-11', 394.99, '2021-08-12', 30, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('SCE^H', 359.57, '2020-02-02', 145.89, '2020-04-25', 11, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('I', 390.7, '2020-08-02', 187.32, '2020-06-05', 25, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CCNE', 52.57, '2020-07-27', 293.07, '2021-03-28', 40, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('LPI', 297.16, '2021-01-04', 221.9, '2020-10-02', 13, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CAT', 125.97, '2021-01-02', 479.52, '2021-02-24', 27, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('FCAP', 234.4, '2020-11-20', 94.49, '2021-03-17', 18, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('HIFS', 389.57, '2020-07-10', 82.89, '2021-03-20', 40, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('LTEA', 408.81, '2021-02-08', 398.4, '2020-04-03', 27, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('TRVG', 363.83, '2020-04-20', 93.68, '2021-05-07', 42, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CIG.C', 340.29, '2020-01-16', 359.63, '2021-05-11', 14, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('MMT', 130.32, '2020-02-27', 176.78, '2021-01-01', 23, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('DTY', 301.52, '2020-02-27', 381.78, '2021-07-24', 13, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('FNGN', 61.16, '2020-05-09', 307.59, '2021-04-28', 15, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('RDN', 316.29, '2020-02-09', 77.01, '2021-06-06', 46, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('SALM', 303.6, '2021-03-22', 83.69, '2021-05-11', 50, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('GNRT', 487.45, '2020-09-10', 97.14, '2020-09-20', 14, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('TICC', 152.14, '2020-06-15', 332.33, '2020-07-19', 44, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('PGZ', 366.79, '2020-05-24', 286.9, '2021-06-11', 35, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('EXP', 162.18, '2020-06-25', 77.39, '2021-03-21', 50, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('UTSI', 354.21, '2020-01-11', 253.79, '2021-05-07', 15, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('ATTU', 232.38, '2020-03-04', 339.26, '2020-12-09', 3, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('TAP', 454.37, '2021-01-08', 109.2, '2020-05-16', 13, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('WPT', 192.94, '2020-03-23', 139.88, '2021-01-25', 13, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('TPC', 362.05, '2020-06-06', 449.14, '2020-09-02', 25, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('VFC', 380.68, '2020-04-17', 79.68, '2020-04-26', 22, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('IFGL', 460.69, '2020-12-29', 153.23, '2020-10-27', 43, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('EMD', 284.31, '2020-04-28', 119.09, '2020-10-12', 21, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('PHIIK', 179.23, '2020-02-06', 280.95, '2021-07-10', 4, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CMRE^C', 496.53, '2020-08-29', 55.57, '2020-09-01', 3, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CNBKA', 263.4, '2020-01-28', 54.51, '2020-08-18', 29, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CLDR', 230.31, '2020-02-26', 76.8, '2020-11-23', 34, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('JCOM', 273.45, '2020-02-23', 321.27, '2021-08-03', 7, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('PSCE', 104.86, '2020-01-09', 229.52, '2020-07-14', 19, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('NTZ', 473.82, '2020-07-23', 419.64, '2020-11-22', 8, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('GS^C', 170.97, '2020-08-07', 473.11, '2021-02-19', 42, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('AKBA', 462.49, '2020-02-17', 344.3, '2020-11-05', 25, 2);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('CHSCO', 325.78, '2020-06-16', 415.04, '2021-08-05', 18, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('UONE', 463.75, '2021-02-10', 415.32, '2020-10-02', 20, 1);
insert into investments (symbol, purchasePrice, purchaseDate, closePrice, date, quantity, investmentAccountId) values ('OREX', 468.64, '2020-08-15', 486.27, '2020-09-29', 12, 1);
