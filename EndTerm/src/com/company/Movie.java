package com.company;

public class Movie extends Item{
    private String director;

    public Movie(){
        super();
        this.director = null;
    }

    public Movie(String name, int price, String description,int quantity, String director){
        super(name,price,description,quantity);
        this.director = director;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie game = (Movie) o;
        return this.name == game.name &&
                this.price == game.price &&
                this.description == game.description &&
                this.quantity == game.quantity &&
                this.director == game.director;
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

    public void setDirector(String director){
        this.director = director;
    }

    public String getDirector(){
        return this.director;
    }
}
