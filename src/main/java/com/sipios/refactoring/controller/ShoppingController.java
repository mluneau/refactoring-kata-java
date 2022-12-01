package com.sipios.refactoring.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);

        double price = cartService.getCartPrice(cart, cart.getCustomer(), cal);
        
        return String.valueOf(price);
    }
}
