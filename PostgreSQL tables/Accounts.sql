CREATE TABLE Accounts(
	accountId SERIAL PRIMARY KEY,
	email VARCHAR(100) UNIQUE,
	password VARCHAR(100),
	name VARCHAR(100),
	wallet BIGINT
);