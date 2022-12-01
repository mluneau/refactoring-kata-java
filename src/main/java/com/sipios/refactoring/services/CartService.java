package com.sipios.refactoring.services;

import java.util.Calendar;
import org.springframework.stereotype.Service;

import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.models.Customer;
import com.sipios.refactoring.repositories.CartRepository;

@Service
public class CartService {

    private CartRepository cartRepository;


    public CartService() {} 

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public int checkSeason(Calendar cal) {
        if (ItemService.getSeasonalDiscount(cal) == true) {
            return 1;
        }
        return 0;
    }

    public double getCartPrice(Cart cart, Customer customer, Calendar cal) {
        double price = 0;
        double discount = cart.getCustomer().getType().getDiscount();
        boolean seasonalDiscount = ItemService.getSeasonalDiscount(cal);

        if (cart.getItems() == null) {
            return price;
        }

        for (int i=0; i<cart.getItems().length; i++) {    
            price += (ItemService.applySeasonalDiscount(cart.getItems()[i], seasonalDiscount) * cart.getItems()[i].getQuantity());
        }

        return (price * discount);
    }

}
