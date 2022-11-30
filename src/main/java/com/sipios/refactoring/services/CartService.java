package com.sipios.refactoring.services;

import org.springframework.stereotype.Service;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.exceptions.BadRequestException;
import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.models.Item;

@Service
public class CartService {
    
    private ItemService itemService;

    public double getCartPrice(Cart cart) {
        double price = 0;
        double discount = cart.getCustomerType().getDiscount();

        if (cart.getItems() == null) {
            return price;
        }

        for (int i=0; i<cart.getItems().length; i++) {
            
            Item item = cart.getItems()[i];
            price += (itemService.applySeasonalDiscount(item) * item.getNb());
        }

        return (price * discount);
    }

    public String customerPriceLimit(Cart cart, double price) {

        try {
            String errorMessage = "Price (" + price + ") is too high for " + cart.getCustomerType().getName() + " customer";
            if (cart.getCustomerType().equals(CustomerDiscountEnum.STANDARD)) {
                if (price > CustomerDiscountEnum.STANDARD.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            } else if (cart.getCustomerType().equals(CustomerDiscountEnum.PREMIUM)) {
                if (price > CustomerDiscountEnum.PREMIUM.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            } else if (cart.getCustomerType().equals(CustomerDiscountEnum.PLATINIUM)) {
                if (price > CustomerDiscountEnum.PLATINIUM.getMaximum()) {
                    throw new Exception(errorMessage);
                }
            } else if (cart.getCustomerType().equals(CustomerDiscountEnum.YOUTH)){
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
