package com.sipios.refactoring.enums;

public enum CustomerDiscountEnum {
    
    STANDARD("STANDARD_CUSTOMER", 1, 200),
    PREMIUM("PREMIUM_CUSTOMER", 0.9, 800),
    PLATINIUM("PLATINIUM_CUSTOMER", 0.5, 2000),
    YOUTH("YOUNG_CUSTOMER", 0.85, 100);

    private final String name;
    private double discount;
    private int maximum;

    CustomerDiscountEnum(String name, double discount, int maximum) {
        this.name = name;
        this.discount = discount;
        this.maximum = maximum;
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

    public int getMaximum() {
        return this.maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }
}

