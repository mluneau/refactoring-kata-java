package com.sipios.refactoring.services;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.sipios.refactoring.models.Item;

@Service
public class ItemService {
    
    public double seasonalDiscount(Item item) {
        
        Date date = new Date();
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(date);

        if ((
                cal.get(Calendar.DAY_OF_MONTH) < 15 &&
                cal.get(Calendar.DAY_OF_MONTH) > 5 &&
                cal.get(Calendar.MONTH) == 5
            ) &&
            (
                cal.get(Calendar.DAY_OF_MONTH) < 15 &&
                cal.get(Calendar.DAY_OF_MONTH) > 5 &&
                cal.get(Calendar.MONTH) == 0
            )) {
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
