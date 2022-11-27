package com.sipios.refactoring.enums;

public enum ItemEnum {
    
    TSHIRT("TSHIRT", 30.00),
    DRESS("DRESS", 50.00),
    SWEATSHIRT("SWEATSHIRT", 80.00),
    JACKET("JACKET", 100.00);

    private double price;
    private final String name;

    ItemEnum(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}


