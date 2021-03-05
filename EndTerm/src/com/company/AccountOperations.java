package com.company;

import java.sql.*;

public interface AccountOperations {
    public default boolean registerAccount(Account acc){
        String addSql = "INSERT INTO Accounts (email, password, name, wallet) VALUES (?, ?, ?, ?)";

        PreparedStatement statementAdd;
        try {
            statementAdd = DB.getConn().prepareStatement(addSql);
            statementAdd.setString(1, acc.getEmail());
            statementAdd.setString(2, acc.getPassword());
            statementAdd.setString(3, acc.getName());
            statementAdd.setInt(4, acc.getWallet());

            int rowsInserted = statementAdd.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new account was inserted successfully!");
            }
        } catch (Exception e) {
            System.out.println("Couldn't add account to the Database");
            return false;
        }
        return true;
    }

    public default boolean updateWallet(Account acc){
        String UpdateSql = "UPDATE Accounts SET wallet=? WHERE email=?";
        PreparedStatement statementUpdate;
        try {
            statementUpdate = DB.getConn().prepareStatement(UpdateSql);
            statementUpdate.setLong(1,acc.getWallet());
            statementUpdate.setString(2,acc.getEmail());

            int rowsUpdated = statementUpdate.executeUpdate();
            if (rowsUpdated > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Couldn't add money to the wallet.");
        }
        return false;
    }

    public default void updatePassword(Account acc){
        String UpdateSql = "UPDATE Accounts SET password=? WHERE email=?";
        PreparedStatement statementUpdate;
        try {
            statementUpdate = DB.getConn().prepareStatement(UpdateSql);
            statementUpdate.setString(1,acc.getPassword());
            statementUpdate.setString(2,acc.getEmail());

            int rowsUpdated = statementUpdate.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("You have successfully changed Password!");
            }
        } catch (Exception e) {
            System.out.println("Couldn't change password.");
        }
    }
}
