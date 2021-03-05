package com.company;

import java.util.Objects;

public class Book extends Item{
    private String author;

    public Book(){
        super();
        this.author = null;
    }

    public Book(String name, int price, String description,int quantity, String author){
        super(name,price,description,quantity);
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return this.name == book.name &&
                this.price == book.price &&
                this.description == book.description &&
                this.quantity == book.quantity &&
                this.author == book.author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setDescription(String description){
        this.description = description;
    }

    @Override
    public String getDescription(){
        return this.description;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int getQuantity(){
        return this.quantity;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }
}
