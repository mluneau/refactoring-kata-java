package com.sipios.refactoring.enums;

public enum CustomerDiscountEnum {
    
    STANDARD("STANDARD_CUSTOMER", 1),
    PREMIUM("PREMIUM_CUSTOMER", 0.9),
    PLATINIUM("PLATINIUM_CUSTOMER", 0.5),
    YOUTH("YOUNG_CUSTOMER", 0.85);

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

