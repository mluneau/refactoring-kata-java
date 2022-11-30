package com.sipios.refactoring.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor 
@AllArgsConstructor
@Getter @Setter
@ToString
public class Item {

    @Id
    private Long itemId;
    private String name;
    private double unitPrice;

}
