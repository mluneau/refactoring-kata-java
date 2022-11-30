package com.sipios.refactoring.repositories;

import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sipios.refactoring.enums.ItemEnum;
import com.sipios.refactoring.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
