package com.company;

import java.sql.*;

public class DB {
    private static Connection conn = null;

    public static boolean ConnectDB() {
        /** Creating the connection to the postgresql database "Store" */
        String connectionUrl = "jdbc:postgresql://localhost:5432/Store";
        /** Username and password are stored here */
        String username = "postgres";
        String password = "postgres";
        try {
            conn = DriverManager.getConnection(connectionUrl,username,password);
        }
        catch (Exception e) {
            System.out.println("Couldn't connect to Database.");
        }
        if(conn != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public static void CloseDB() {
        try {
            conn.close();
        }
        catch (Exception e) {
            System.out.println("Couldn't close the connection to Database");
        }
    }

    public static Connection getConn(){
        return conn;
    }
}
