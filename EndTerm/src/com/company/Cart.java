package com.company;

import java.util.ArrayList;

public class Cart implements CartOperations{
    private ArrayList<Item> cart;

    public Cart(){
        cart = new ArrayList<Item>();
    }

    public int getSize(){
        return cart.size();
    }

    public Item get(int i){
        return cart.get(i);
    }

    public boolean addItemToCart(Item obj){
        if(obj!=null)
            return cart.add(obj);
        else
            return false;
    }

    public boolean deleteItemFromCart(String name){
        /** Items are removed by their name, since user shouldn't know the id of items
         * And names are Unique*/
        for(int i = 0; i < cart.size(); i++){
            if(cart.get(i).getName().equals(name)) { //Using equals since == doesn't work properly (compares if objects are the same instances)
                cart.remove(i);
                addQuantity(name); //Calls for the interface method to add quantity to SQL database
                return true; //Break from the method and return true if the item was found and deleted
            }
        }
        return false; //Returns false if the item wasn't deleted
    }

    public void printCart(){
        for(int i = 0; i < cart.size(); i++)
            System.out.println("------------------------" +
                    "\nName: " + cart.get(i).getName() +
                    "\nPrice: " + cart.get(i).getPrice() +
                    "\nDescription: " + cart.get(i).getDescription());
        System.out.println("------------------------\n" +
                "Total sum is: " + totalSum());

    }

    public Integer totalSum(){
        Integer sum = 0;
        for(int i = 0; i < cart.size(); i++)
            sum += cart.get(i).price;
        return sum;
    }

    public boolean isEmpty(){
        return cart.isEmpty();
    }

    public void clearCart(){
        cart.clear();
    }
}
