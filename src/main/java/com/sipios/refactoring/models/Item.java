package com.sipios.refactoring.models;

import javax.persistence.Entity;

import com.sipios.refactoring.enums.ItemEnum;

@Entity
public class Item {

    private int nb;
    private ItemEnum type;

    public Item() {}

    public Item(int quantity, ItemEnum type) {
        this.type = type;
        this.nb = quantity;
    }

    public ItemEnum getType() {
        return this.type;
    }

    public void setType(ItemEnum type) {
        this.type = type;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

}
