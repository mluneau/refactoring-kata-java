package com.sipios.refactoring.models;

import com.sipios.refactoring.enums.CustomerDiscountEnum;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cart {
    
    private Item[] items;
    private CustomerDiscountEnum customerType;

    public Cart(Item[] items, CustomerDiscountEnum customerType) {
        this.items = items;
        this.customerType = customerType;
    }

    public Cart() {}
    
}
