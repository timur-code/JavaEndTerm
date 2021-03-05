package com.company;

import java.util.NoSuchElementException;
import java.sql.*;

public interface CartOperations {
    public default Item add(String name){
        String itemSql = "SELECT * FROM Item WHERE name=? AND quantity>0";
        PreparedStatement itemStatement;
        try {
            itemStatement = DB.getConn().prepareStatement(itemSql);
            itemStatement.setString(1,name);
            ResultSet resultItem = itemStatement.executeQuery();

            while (resultItem.next()) {
                if(resultItem.getInt("typeId")==1) {
                    /** Create a Book object with data from Database */
                    Book book = new Book(resultItem.getString("name"),
                            resultItem.getInt("price"),
                            resultItem.getString("description"),
                            resultItem.getInt("quantity"),
                            resultItem.getString("creator"));
                    if(book.quantity>0 && deductQuantity(name))
                        return book;
                    else
                        return null;
                }
                else if(resultItem.getInt("typeId")==2) {
                    /** Create a Movie object with data from Database */
                    Movie movie = new Movie(resultItem.getString("name"),
                            resultItem.getInt("price"),
                            resultItem.getString("description"),
                            resultItem.getInt("quantity"),
                            resultItem.getString("creator"));
                    if(movie.quantity>0 && deductQuantity(name))
                        return movie;
                    else
                        return null;
                }
                else if(resultItem.getInt("typeId")==3) {
                    /** Create a Game object with data from Database */
                    Game game = new Game(resultItem.getString("name"),
                            resultItem.getInt("price"),
                            resultItem.getString("description"),
                            resultItem.getInt("quantity"),
                            resultItem.getString("creator"));
                    if(game.quantity>0 && deductQuantity(name))
                        return game;
                    else
                        return null;
                }
            }
        } catch (Exception e) {
            throw new NoSuchElementException("Item wasn't found.");
        }
        return null;
    }

    public default boolean deductQuantity(String name){
        String deductQuantity = "UPDATE Item SET quantity = quantity - 1 WHERE name=?";
        PreparedStatement deductStatement;
        try {
            deductStatement = DB.getConn().prepareStatement(deductQuantity);
            deductStatement.setString(1, name);

            int rowsUpdated = deductStatement.executeUpdate();

            return rowsUpdated>0;
        } catch (Exception ex){
            System.out.println("Couldn't deduct quantity.");
            return false;
        }
    }

    public default boolean addQuantity(String name){
        String deductQuantity = "UPDATE Item SET quantity = quantity + 1 WHERE name=?";
        PreparedStatement addStatement;
        try {
            addStatement = DB.getConn().prepareStatement(deductQuantity);
            addStatement.setString(1, name);

            int rowsUpdated = addStatement.executeUpdate();

            return rowsUpdated>0;
        } catch (Exception ex){
            System.out.println("Couldn't deduct quantity.");
            return false;
        }
    }
}
