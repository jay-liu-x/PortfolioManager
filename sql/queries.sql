DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS investment_account;
DROP TABLE IF EXISTS cash_account;
DROP TABLE IF EXISTS investments;
DROP TABLE IF EXISTS marketmover;

CREATE TABLE person
(
    name VARCHAR(50),
    email VARCHAR(50),
    PRIMARY KEY (email)
);

CREATE TABLE investment_account
(
    investment_account_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    date DATE,
    email VARCHAR(50),
    investment_value DOUBLE,
    FOREIGN KEY (email) REFERENCES person (email)
);

CREATE TABLE cash_account
(
    cash_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    date DATE,
    email VARCHAR(50),
    cash_value DOUBLE,
    FOREIGN KEY (email) REFERENCES person (email)

);

CREATE TABLE investments
(
    investment_id int NOT NULL AUTO_INCREMENT,
    investment_account_id int NOT NULL,
    symbol VARCHAR(50),
    purchase_price DOUBLE,
    purchase_date DATE,
    date DATE,
    quantity INTEGER,
    close_price DOUBLE,
    PRIMARY KEY (investment_id),
    FOREIGN KEY (investment_account_id) REFERENCES investment_account(investment_account_id)
);

CREATE TABLE marketmover
(
    marketmover_id int NOT NULL AUTO_INCREMENT,
    index_name VARCHAR(50),
    date DATE,
    change_rate DOUBLE,
    index_value DOUBLE,
    PRIMARY KEY(marketmover_id)
);

USE conygre;

insert into person (name, email) values ('John Doe', 'j.d@citi.com');

insert into investment_account (name, date, email, investment_value) values ('RRSP', '2021-01-01', 'j.d@citi.com', null);
insert into investment_account (name, date, email, investment_value) values ('TFSA', '2021-02-01', 'j.d@citi.com', null);

insert into cash_account (name, date, email, cash_value) values ('Chequing','2021-01-01', 'j.d@citi.com', null);
insert into cash_account (name, date, email, cash_value) values ('Savings','2021-02-01', 'j.d@citi.com', null);


insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2021-08-12', 53.00, '2021-08-12', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2020-08-12', 51.00, '2021-08-13', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2021-08-12', 42.00, '2021-08-14', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2021-08-12', 35.00, '2021-08-15', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2021-08-12', 45.00, '2021-08-16', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2021-08-12', 53.00, '2021-08-17', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AB', 56.00, '2021-08-12', 59.00, '2021-08-18', 15, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TB', 12.00, '2021-08-13', 15.00, '2021-08-13', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TB', 12.00, '2021-08-13', 16.00, '2021-08-14', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TB', 12.00, '2021-08-13', 18.00, '2021-08-15', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TB', 12.00, '2021-08-13', 23.00, '2021-08-16', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('COMP', 145, '2021-08-12', 143, '2021-08-12', 10, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('COMP', 145, '2021-08-12', 141, '2021-08-13', 10, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('COMP', 145, '2021-08-12', 147, '2021-08-14', 10, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('COMP', 145, '2021-08-12', 155, '2021-08-15', 10, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('COMP', 145, '2021-08-12', 158, '2021-08-16', 10, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('COMP', 145, '2021-08-12', 165, '2021-08-17', 10, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TT', 205, '2021-08-15', 180, '2021-08-15', 30, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TT', 205, '2021-08-15', 160, '2021-08-16', 30, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TT', 205, '2021-08-15', 190, '2021-08-17', 30, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('TT', 205, '2021-08-15', 196, '2021-08-18', 30, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 81, '2021-08-13', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 89, '2021-08-14', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 100, '2021-08-15', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 105, '2021-08-16', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 110, '2021-08-17', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 123, '2021-08-18', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AA', 80, '2021-08-13', 81, '2021-08-13', 50, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('OREX', 468.64, '2020-08-15', 486.27, '2021-08-12', 12, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('OREX', 468.64, '2020-08-15', 480.01, '2021-08-13', 12, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('OREX', 468.64, '2020-08-15', 491.20, '2021-08-14', 12, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('OREX', 468.64, '2020-08-15', 509.01, '2021-08-15', 12, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('OREX', 468.64, '2020-08-15', 510.04, '2021-08-16', 12, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('OREX', 468.64, '2020-08-15', 511.20, '2021-08-17', 12, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('FEX', 98.40, '2021-08-15', 98.40, '2021-08-15', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('FEX', 98.40, '2021-08-15', 100.25, '2021-08-16', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('FEX', 98.40, '2021-08-15', 89.90, '2021-08-17', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('FEX', 98.40, '2021-08-15', 83.95, '2021-08-18', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 100.24, '2021-08-12', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 111.24, '2021-08-13', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 120.35, '2021-08-14', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 115.22, '2021-08-15', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 127.89, '2021-08-16', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 120.66, '2021-08-17', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('LAV', 150.53, '2021-03-18', 127.54, '2021-08-18', 20, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 201.35, '2021-08-12', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 222.31, '2021-08-13', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 220.04, '2021-08-14', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 211.35, '2021-08-15', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 230.88, '2021-08-16', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 221.59, '2021-08-17', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('QWSD', 200.03, '2021-04-11', 225.75, '2021-08-18', 30, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('DAS', 100.25, '2021-08-14', 100.25, '2021-08-14', 10, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('DAS', 100.25, '2021-08-14', 90.20, '2021-08-15', 10, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('DAS', 100.25, '2021-08-14', 88.75, '2021-08-16', 10, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',74.09, '2021-08-12', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',75.11, '2021-08-13', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',78.33, '2021-08-14', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',85.18, '2021-08-14', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',84.67, '2021-08-15', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',85.22, '2021-08-16', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',86.00, '2021-08-17', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('NTZ', 73.82, '2021-08-01',87.96, '2021-08-18', 8, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('GS^C', 170.97, '2021-08-15',180.24, '2021-08-15', 42, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('GS^C', 170.97, '2021-08-15',178.64, '2021-08-16', 42, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('GS^C', 170.97, '2021-08-15',179.33, '2021-08-17', 42, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AKBA', 462.49, '2021-08-13',468.99, '2021-08-13', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AKBA', 462.49, '2021-08-13', 469.03, '2020-08-14', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AKBA', 462.49, '2021-08-13', 481.55, '2020-08-15', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AKBA', 462.49, '2021-08-13', 488.68, '2020-08-16', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('AKBA', 462.49, '2021-08-13', 487.01, '2020-08-17', 25, 2);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('CHSCO', 325.78, '2021-08-12',328.04, '2021-08-12', 18, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('CHSCO', 325.78, '2020-08-13', 333.92, '2021-08-13', 18, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10', 415.32, '2021-08-12', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10', 400.93, '2021-08-13', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10', 405.77, '2021-08-14', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10', 425.80, '2021-08-15', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10', 417.62, '2021-08-16', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10', 399.93, '2021-08-17', 20, 1);
insert into investments (symbol, purchase_price, purchase_date, close_price, date, quantity, investment_account_id) values ('UONE', 463.75, '2021-08-10',413.06, '2021-08-18', 20, 1);

insert into marketmover(index_name,date,change_rate,index_value) values ('NASDAQ','2021-01-01',2.1,15000.0);
insert into marketmover(index_name,date,change_rate,index_value) values ('NASDAQ','2021-02-01',-1.1,14000.0);
