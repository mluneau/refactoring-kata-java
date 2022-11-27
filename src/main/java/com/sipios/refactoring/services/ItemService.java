package com.sipios.refactoring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sipios.refactoring.models.Item;
import com.sipios.refactoring.repositories.ItemRepository;

@Service
public class ItemService {
    
    @Autowired
    private ItemRepository itemRepository;

    public Optional<Item> getByID(Long id) {
        return itemRepository.findById(id);
    }

    public List<Item> getAll() {
        return itemRepository.findAll();
    }
    
}
