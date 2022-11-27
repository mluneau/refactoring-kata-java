package com.sipios.refactoring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.models.Item;
import com.sipios.refactoring.services.CartService;
import com.sipios.refactoring.services.ItemService;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    private Logger logger = LoggerFactory.getLogger(ShoppingController.class);

    @Autowired
    CartService cartService;

    @PostMapping
    public String getPrice(@RequestBody Cart cart) {
        
        String price = String.valueOf(cartService.getCartPrice(cart));
        // Add maximum price to Enum Customer
        try {
            switch (cart.getCustomerType().getName()) {
                case CustomerDiscountEnum.STANDARD.getName():
                    if (price > 200) {
                        throw new Exception("Price (" + price + ") is too high for standard customer");
                    }
            }
        }
        
        try {
            if (cart.getCustomerType().getName().equals("STANDARD_CUSTOMER")) {
                if (price > 200) {
                    throw new Exception("Price (" + price + ") is too high for standard customer");
                }
            } else if (cart.getCustomerType().getName().equals("PREMIUM_CUSTOMER")) {
                if (price > 800) {
                    throw new Exception("Price (" + price + ") is too high for premium customer");
                }
            } else if (cart.getCustomerType().getName().equals("PLATINUM_CUSTOMER")) {
                if (price > 2000) {
                    throw new Exception("Price (" + price + ") is too high for platinum customer");
                }
            } else {
                if (price > 200) {
                    throw new Exception("Price (" + price + ") is too high for standard customer");
                }
            }


        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

        return String.valueOf(price);
    }
}
