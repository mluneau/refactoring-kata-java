package com.sipios.refactoring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.services.CartService;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @Autowired
    CartService cartService;

    // What is logger?

    @PostMapping
    public String getPrice(@RequestBody Cart cart) {
        
        double price = cartService.getCartPrice(cart);
        String message = cartService.customerPriceLimit(cart, price);
        
        return message;
    }
}
