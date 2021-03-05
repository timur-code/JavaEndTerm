package com.company;

import java.util.Objects;

public abstract class Item {
    protected String name;
    protected int price;
    protected String description;
    protected int quantity;

    public Item(){
        this.name = null;
        this.price = 0;
        this.description = null;
        this.quantity = 0;
    }

    public Item(String name, int price, String description, int quantity){
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    @Override
    public abstract boolean equals(Object o);

    public abstract void setName(String name);

    public abstract String getName();

    public abstract void setPrice(int price);

    public abstract int getPrice();

    public abstract void setDescription(String description);

    public abstract String getDescription();

    public abstract void setQuantity(int quantity);

    public abstract int getQuantity();
}
