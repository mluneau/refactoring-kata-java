package com.sipios.refactoring.models;

import javax.persistence.Entity;

import com.sipios.refactoring.enums.CustomerDiscountEnum;

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
public class Customer {
    
    private Long customerId;
    private String username;
    private CustomerDiscountEnum type;

}
