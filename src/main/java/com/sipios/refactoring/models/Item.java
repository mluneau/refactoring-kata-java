package com.sipios.refactoring.models;

import javax.persistence.Entity;

import com.sipios.refactoring.enums.ItemEnum;

import lombok.Getter;
import lombok.Setter;

@Entity
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
