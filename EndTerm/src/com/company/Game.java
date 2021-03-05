package com.company;

public class Game extends Item{
    private String studio;

    public Game(){
        super();
        this.studio = null;
    }

    public Game(String name, int price, String description,int quantity, String studio){
        super(name,price,description,quantity);
        this.studio = studio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return this.name == game.name &&
                this.price == game.price &&
                this.description == game.description &&
                this.quantity == game.quantity &&
                this.studio == game.studio;
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

    public void setStudio(String studio){
        this.studio = studio;
    }

    public String getStudio(){
        return this.studio;
    }
}
