package com.sipios.refactoring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sipios.refactoring.models.Item;
import com.sipios.refactoring.repositories.ItemRepository;


@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;
    private ItemService underTest;


    @BeforeEach
    void setUp() {
        underTest = new ItemService(itemRepository);
    }

    @Test
    void isTrueGetSeasonalDiscountTest() {
        // given
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, +39);
        
        // when 
        boolean expected = underTest.getSeasonalDiscount(cal);

        // then
        assertTrue(expected);
        
    }

    @Test
    void isFalseGetSeasonalDiscountTest() {
        // given
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        // when 
        boolean expected = underTest.getSeasonalDiscount(cal);

        // then
        assertFalse(expected);
    }



    @Test
    void shouldApplySeasonalDiscountTest() {
        // given
        Item itemTest1 = new Item(14L, "TROUSERS", 35.00, 1);
        Item itemTest2 = new Item(15L, "DRESS", 45.00, 1);
        boolean seasonalDiscountTrue = true;

        // when 
        double expectedItemTest1Price = underTest.applySeasonalDiscount(itemTest1, seasonalDiscountTrue);
        double expectedItemTest2Price = underTest.applySeasonalDiscount(itemTest2, seasonalDiscountTrue);

        // then
        assertEquals(expectedItemTest1Price, 35.00);
        assertEquals(expectedItemTest2Price, 36.00);
    }

    @Test
    void shouldNotApplySeasonalDiscountTest() {
        // given
        Item itemTest1 = new Item(14L, "TROUSERS", 35.00, 1);
        Item itemTest2 = new Item(15L, "DRESS", 45.00, 1);
        boolean seasonalDiscountTrue = false;

        // when 
        double expectedItemTest1Price = underTest.applySeasonalDiscount(itemTest1, seasonalDiscountTrue);
        double expectedItemTest2Price = underTest.applySeasonalDiscount(itemTest2, seasonalDiscountTrue);

        // then
        assertEquals(expectedItemTest1Price, 35.00);
        assertEquals(expectedItemTest2Price, 45.00);

    }
}
