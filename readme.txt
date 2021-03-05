Theme of the project is online store.

User first has to login or register.
Next he is presented with 9 options like displaying all products in the store, adding to the cart, buying and others.

Project has 9 classes and 4 interfaces. Item(abstract) and its subclasses are for the products.
Account is connected directly to the cart since every user has one.
DB class is to establish the connection with the PostgreSQL Database 'Store'.
All operations with databases, aside from connection, are implemented in default methods in interfaces.
Main class invokes the DB connection and UserMenu which allows user to choose what he wants to do.
UserMenu also has some methods directly tied to the options. 