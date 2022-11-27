package com.sipios.refactoring.enums;

public enum CustomerDiscountEnum {
    
    STANDARD("STANDARD", 30.00),
    PREMIUM("PREMIUM", 50.00),
    PLATINIUM("PLATINIUM", 80.00),
    YOUTH("YOUTH", 100.00);

    private double discount;
    private final String name;

    CustomerDiscountEnum(String name, double discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return this.name;
    }

    public double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}

