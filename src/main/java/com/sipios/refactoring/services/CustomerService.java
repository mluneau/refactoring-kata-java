package com.sipios.refactoring.services;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.exceptions.BadRequestException;
import com.sipios.refactoring.models.Customer;

public class CustomerService {
    
    public String customerPriceLimit(Customer customer, double price) {

        try {
            String errorMessage = "Price (" + price + ") is too high for " + customer.getType().getName() + " customer";
            if (customer.getType().equals(CustomerDiscountEnum.STANDARD)) {
                if (price > CustomerDiscountEnum.STANDARD.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            } else if (customer.getType().equals(CustomerDiscountEnum.PREMIUM)) {
                if (price > CustomerDiscountEnum.PREMIUM.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            } else if (customer.getType().equals(CustomerDiscountEnum.PLATINIUM)) {
                if (price > CustomerDiscountEnum.PLATINIUM.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            } else if (customer.getType().equals(CustomerDiscountEnum.YOUTH)){
                if (price > CustomerDiscountEnum.YOUTH.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            }

        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }

        return String.valueOf(price);
    }


}
