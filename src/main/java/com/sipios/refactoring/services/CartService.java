package com.sipios.refactoring.services;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.exceptions.BadRequestException;
import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.models.Customer;
import com.sipios.refactoring.models.Item;

@Service
public class CartService {
    
    private ItemService itemService;
    private CustomerService customerService;

    public double getCartPrice(Cart cart, Customer customer) {
        double price = 0;
        double discount = cart.getCustomer().getType().getDiscount();

        if (cart.getItems() == null) {
            return price;
        }

        for (int i=0; i<cart.getItems().length; i++) {
            
            Item item = cart.getItems()[i];
            price += (itemService.applySeasonalDiscount(item) * item.getNb());
        }

        return (price * discount);
    }

    public double applySeasonalDiscount(Item item, Customer customer) {
        
        boolean seasonalDiscount = itemService.getSeasonalDiscount();
        if (seasonalDiscount == true) {
                switch (item.getType().getName()) {
                    case "DRESS":
                        item.getType().setPrice(item.getType().getPrice() * 0.8);
                        break; 
                    case "JACKET":
                        item.getType().setPrice(item.getType().getPrice() * 0.9);     
                        break;
                    default:
                        item.getType().getPrice();
                    }
        }
        return item.getType().getPrice();
    }


}
