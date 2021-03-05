CREATE TABLE Item(
	itemId SERIAL PRIMARY KEY,
	name VARCHAR(100) UNIQUE,
	price INT,
	description TEXT,
	quantity INT,
	creator VARCHAR(100), --author for Books, director for Movie and studio for Game
	typeId INT --1 is for Book, 2 is for Movie and 3 is for Game
);