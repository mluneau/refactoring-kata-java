package com.sipios.refactoring.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    @Disabled
    void applySeasonalDiscountTest() {

    }
}
