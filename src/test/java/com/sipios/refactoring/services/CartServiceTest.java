package com.sipios.refactoring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.models.Cart;
import com.sipios.refactoring.models.Customer;
import com.sipios.refactoring.models.Item;
import com.sipios.refactoring.repositories.CartRepository;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    
    @Mock
    private CartRepository cartRepository;
    private CartService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CartService(cartRepository);
    }

    @Test
    void testGetCartPrice() {
        // given 
        Item itemTest1 = new Item(14L, "TROUSERS", 35.00, 1);
        Item itemTest2 = new Item(15L, "DRESS", 45.00, 2);
        Item itemTest3 = new Item(7L, "SWEATSHIRT", 80.00, 3);
        Item itemTest4 = new Item(19L, "JACKET", 100.00, 4);
        Item[] itemsTest = new Item[4];
        itemsTest[0] = itemTest1;
        itemsTest[1] = itemTest2;
        itemsTest[2] = itemTest3;
        itemsTest[3] = itemTest4;
        Customer customerTest = new Customer(6L, "platinium_user", CustomerDiscountEnum.PLATINIUM);
        Cart cartTest = new Cart(1L, customerTest, itemsTest); 
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);

        // when 
        double expected = underTest.getCartPrice(cartTest, customerTest, cal);

        // then 
        assertEquals(expected, 382.5);
    }
}
