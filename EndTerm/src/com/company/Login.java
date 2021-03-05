package com.company;

import java.util.NoSuchElementException;
import java.sql.*;

public interface Login {
    public default Account login(String email, String password) throws NoSuchElementException {
        String loginSql = "SELECT email, password, name, wallet FROM Accounts WHERE email=? and password=?";
        PreparedStatement loginStatement;
        try {
            loginStatement = DB.getConn().prepareStatement(loginSql);
            loginStatement.setString(1,email);
            loginStatement.setString(2,password);
            ResultSet resultLogin = loginStatement.executeQuery();

            while (resultLogin.next()) {
                /** Create an Account object with data from Database */
                Account acc = new Account();
                acc.setEmail(resultLogin.getString("email"));
                acc.setPassword(resultLogin.getString("password"));
                acc.setName(resultLogin.getString("name"));
                acc.setWallet(resultLogin.getInt("wallet"));
                return acc;
            }
        } catch (Exception e) {
            throw new NoSuchElementException("Account wasn't found.");
        }
        return null;
    }
}
