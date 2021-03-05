package com.company;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserMenu implements Login, CartOperations, displayItems{

    public UserMenu(){}

    public void mainMenu(){
        Account acc = new Account();
        /** Opening Scanner for menu */
        Scanner scan = new Scanner(System.in);
        int choice = 0;
        while(choice<1 || choice>31) {
            System.out.println("Welcome to the Store!\n" +
                    "Before buying anything, please register or log in!\n" +
                    "Choose one of two options:\n" +
                    "1)Login.\n" +
                    "2)Register.\n" +
                    "3)Exit.");
            try {
                choice = scan.nextInt();
            } catch (Exception ex) {
                System.out.println("Wrong option.");
            } finally {
                scan.nextLine();
            }
        }
        switch (choice) {
            case 1:
                acc = loginAccount();
                if (acc == null) {
                    System.out.println("No such account exists. Try again.");
                    mainMenu(); //Restart the menu if we couldn't login
                }
                else
                    System.out.println("You have successfully entered your account!");
                break;
            case 2:
                try {
                    acc = createAccount();
                    if (acc == null) {
                        mainMenu(); //Restart the menu if we couldn't register
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                    mainMenu(); //Restart the menu if we couldn't register an account
                }
                break;
            case 3:
                return;
        }

        choice = 0;
        while(choice!=9){
            System.out.println("Choose what you want:\n" +
                    "1)Add product to your cart.\n" +
                    "2)Print your cart.\n" +
                    "3)Delete an item from your cart.\n" +
                    "4)Display products.\n" +
                    "5)Show your wallet.\n" +
                    "6)Add money to your wallet.\n" +
                    "7)Buy products in your cart.\n" +
                    "8)Clean your cart.\n" +
                    "9)Exit");
            try {
                choice = scan.nextInt();
            } catch (Exception ex) {
                System.out.println("Wrong option.");
            } finally {
                scan.nextLine();
            }

            switch (choice){
                case 1:
                    if(acc.getCart().addItemToCart(addItem()))
                        System.out.println("Item was added successfully!");
                    else
                        System.out.println("Couldn't add an item.");
                    break;
                case 2:
                    acc.getCart().printCart();
                    break;
                case 3:
                    acc = deleteItem(acc);
                    break;
                case 4:
                    displayAllItems();
                    break;
                case 5:
                    System.out.println("You have " + acc.getWallet() + " in your wallet.");
                    break;
                case 6:
                    acc = depositWallet(acc);
                    break;
                case 7:
                    acc = buyCart(acc);
                    break;
                case 8:
                    acc = cleanCart(acc);
                    break;
                case 9:
                    System.out.println("Thank You for your visit!");
                    return;
            }
        }
    }

    public Account createAccount() throws InputMismatchException {
        /** Opening Scanner for the new Account */
        Scanner scan = new Scanner(System.in);
        String email, password, name;
        Integer wallet;
        System.out.println("Enter your email: ");
        email = scan.nextLine();
        System.out.println("Enter password for your new account: ");
        password = scan.nextLine();
        System.out.println("Enter your name: ");
        name = scan.nextLine();
        try{
            System.out.println("Please enter your wallet: ");
            wallet = scan.nextInt();
        } catch (Exception ex){
            throw new InputMismatchException("Wrong type. Integer expected."); //Throw exception
        } finally {
            scan.nextLine();
        }

        Account acc = new Account(email, password, name, wallet); //Creates new Account and stores it in the DB
        if(acc.registerAccount(acc))
            return acc;
        else
            return null;
    }

    public Account loginAccount(){
        /** Opening Scanner to login */
        Scanner scan = new Scanner(System.in);
        String email, password;
        System.out.println("Enter your email: ");
        email = scan.nextLine();
        System.out.println("Enter password for your account: ");
        password = scan.nextLine();

        try{
            Account acc = login(email, password);
            return acc;
        }catch (NoSuchElementException ex){
            System.out.println(ex);
            return null;
        }
    }

    public Item addItem(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the item: ");
        String itemName = scan.nextLine();
        return add(itemName);
    }

    //TODO: ADD Buy option
    public Account deleteItem(Account acc){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the name of the item you wish to delete: ");
        String itemName = scan.nextLine();
        /** returns false if the item wasn't found/deleted */
        if(acc.getCart().deleteItemFromCart(itemName))
            System.out.println("Delete was successfull!");
        else
            System.out.println("Couldn't delete this item.");
        return acc;
    }

    public void displayAllItems(){
        Scanner scanner = new Scanner(System.in);
        Integer typeId = 0;
        while (typeId < 1 || typeId > 3) {
            System.out.println("What products do you wish to display?\n" +
                    "1)Books\n" +
                    "2)Movies\n" +
                    "3)Games");
            try {
                typeId = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Wrong input. Integer expected.");
            } finally {
                scanner.nextLine();
            }
        }
        getItems(typeId);
    }

    public Account depositWallet(Account acc){
        Scanner scan = new Scanner(System.in);
        Integer deposit = 0;
        try{
            System.out.println("Please enter the amount: ");
            deposit = scan.nextInt();
        } catch (Exception e){
            System.out.println("Wrong input. Integer needed");
            acc = depositWallet(acc);
            return acc;
        } finally {
            scan.nextLine();
        }
        acc.addToWallet(deposit);
        return acc;
    }

    public Account buyCart(Account acc){
        if(!acc.getCart().isEmpty()){
            if(acc.getWallet() >= acc.getCart().totalSum())
            {
                acc.setWallet(acc.getWallet() - acc.getCart().totalSum());
                acc.getCart().clearCart();
                System.out.println("You have successfully bought products from the cart.");
            }
            else{
                System.out.println("Not enough money.");
            }
        }
        else{
            System.out.println("Cart is empty.");
        }
        return acc;
    }

    public Account cleanCart(Account acc){
        if(!acc.getCart().isEmpty()){
            for(int i = 0; i < acc.getCart().getSize(); i++){
                addQuantity(acc.getCart().get(i).getName()); //returns every item in cart to the DB
            }
            acc.getCart().clearCart(); //And then clears the cart
            System.out.println("Cart is cleaned.");
        }
        else{
            System.out.println("Cart is empty.");
        }
        return acc;
    }
}
