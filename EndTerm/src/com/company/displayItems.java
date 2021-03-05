package com.company;

import java.sql.*;

public interface displayItems {
    public default void getItems(Integer typeId){
        String availableSql = "SELECT * FROM Item WHERE typeId=? ORDER BY name ASC";
        PreparedStatement displayStatement;
        try {
            displayStatement = DB.getConn().prepareStatement(availableSql);
            displayStatement.setInt(1,typeId);
            ResultSet resultSet = displayStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("-------------------------------" +
                        "\nName: " + resultSet.getString("name") +
                        "\nPrice: " + resultSet.getInt("price") +
                        "\nDescription: " + resultSet.getString("description") +
                        "\nQuantity: " + resultSet.getInt("quantity"));
                if(typeId == 1)
                    System.out.println("Author: " + resultSet.getString("creator"));
                else if(typeId == 2)
                    System.out.println("Director: " + resultSet.getString("creator"));
                else if(typeId == 3)
                    System.out.println("Studio: " + resultSet.getString("creator"));
            }
            System.out.println("-------------------------------");
        } catch (Exception e) {
            System.out.println("Couldn't display products.");
            return;
        }
    }
}
