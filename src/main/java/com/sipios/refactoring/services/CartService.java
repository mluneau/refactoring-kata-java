package com.sipios.refactoring.services;

import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.models.Item;

public class CartService {
    
    private ItemService itemService;

    public double getCartPrice(Cart cart) {
        double price = 0;
        double discount = cart.getCustomerType().getDiscount();

        if (cart.getItems() == null) {
            return "0";
        }

        for (int i=0; i<cart.getItems().length; i++) {
            
            Item item = cart.getItems()[i];
            price += (itemService.seasonalDiscount(item) * item.getNb());
        }

        return (price * discount);
    }

}
