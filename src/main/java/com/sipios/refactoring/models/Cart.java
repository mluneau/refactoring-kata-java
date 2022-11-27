package com.sipios.refactoring.models;

import javax.persistence.Entity;

import com.sipios.refactoring.enums.CustomerDiscountEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
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
