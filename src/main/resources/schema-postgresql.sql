DROP TABLE IF EXISTS address;

CREATE TABLE address (
	id serial PRIMARY KEY NOT NULL,
	street varchar(20) NOT NULL,
	zip int NOT NULL
);

DROP TABLE IF EXISTS customer;

CREATE TABLE customer (
    CUST_ID serial PRIMARY KEY NOT NULL,
    NAME varchar(100) NOT NULL,
    AGE smallint NOT NULL,
    address_id int DEFAULT NULL REFERENCES address(id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO customer values (1, 'srinivas', 26);
INSERT INTO customer values (2, 'pranay', 30);
INSERT INTO customer values (3, 'bhanu', 20);

INSERT INTO address values (1, 'judges colony', 1070);
INSERT INTO address values (2, 'kphb', 1071);
INSERT INTO address values (3, 'chandanagar', 1072);