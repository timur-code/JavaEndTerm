package com.company;

public class Account implements AccountOperations{
    private String email;
    private String password;
    private String name;
    private Integer wallet;
    private Cart cart;

    public Account(){
        email = null;
        password = null;
        name = null;
        wallet = 0;
        cart = new Cart();
    }

    public Account(String email, String password, String name, Integer wallet){
        cart = new Cart();
        this.email = email;
        this.password = password;
        this.name = name;
        this.wallet = wallet;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToWallet(Integer add){
        this.wallet += add;
        if(updateWallet(this))
            System.out.println("You have successfully added money to your wallet!");
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
        updateWallet(this);
    }

    public Cart getCart() {
        return cart;
    }
}
