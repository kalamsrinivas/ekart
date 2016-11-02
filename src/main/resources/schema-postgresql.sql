DROP TABLE IF EXISTS customer;
 
CREATE TABLE customer (
    CUST_ID int PRIMARY KEY NOT NULL,
    NAME varchar(100) NOT NULL,
    AGE smallint NOT NULL
);

INSERT INTO customer values (1, 'srinivas', 26);
INSERT INTO customer values (2, 'pranay', 30);
INSERT INTO customer values (3, 'bhanu', 20);

DROP TABLE IF EXISTS address;

CREATE TABLE address (
	CUST_ID int PRIMARY KEY NOT NULL,
	street varchar(20) NOT NULL,
	zip int NOT NULL
);

INSERT INTO address values (1, 'judges colony', 1070);
INSERT INTO address values (2, 'kphb', 1071);
INSERT INTO address values (3, 'chandanagar', 1072);