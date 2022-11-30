package com.sipios.refactoring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sipios.refactoring.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
