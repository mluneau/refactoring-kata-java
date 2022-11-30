package com.sipios.refactoring.services;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.sipios.refactoring.models.Item;
import com.sipios.refactoring.repositories.ItemRepository;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService() {}

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    public boolean getSeasonalDiscount() {
        
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
                return true;
            }

        return false;
    }

    public double applySeasonalDiscount(Item item) {
        
        boolean seasonalDiscount = getSeasonalDiscount();
        if (seasonalDiscount == true) {
                switch (item.getName()) {
                    case "DRESS":
                        item.setUnitPrice(item.getUnitPrice() * 0.8);
                        break; 
                    case "JACKET":
                        item.setUnitPrice(item.getUnitPrice() * 0.9);     
                        break;
                    default:
                        item.getUnitPrice();
                    }
        }
        return item.getUnitPrice();
    }

    
}
