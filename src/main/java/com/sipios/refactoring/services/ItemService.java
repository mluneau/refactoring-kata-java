package com.sipios.refactoring.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.sipios.refactoring.exceptions.BadRequestException;
import com.sipios.refactoring.models.Item;
import com.sipios.refactoring.repositories.ItemRepository;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService() {}

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public boolean repositoryContainsItem(Item item) {

        List<Item> allItems = itemRepository.findAll();
        for (Item i : allItems) {
            if (i.getNb() == item.getNb() && i.getType() == item.getType()) {
                return true;
            }
        }
        return false;
    }


    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    
    public void addItem(Item item) {
        boolean itemExists = repositoryContainsItem(item);
            if (itemExists) {
                throw new BadRequestException("The item " + item.getType().getName() + " already exists");
            }
        itemRepository.save(item);    
    }

    public void deleteItem(Long id) {
        if (itemRepository.findById(id) == null) {
            throw new BadRequestException("The item you selected does not exists");
        }
        itemRepository.deleteById(id);
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
