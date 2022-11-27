package com.sipios.refactoring.models;

import com.sipios.refactoring.enums.ItemEnum;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Item {

    private int nb;
    private ItemEnum type;

    public Item() {}

    public Item(int quantity, ItemEnum type) {
        this.type = type;
        this.nb = quantity;
    }
}
