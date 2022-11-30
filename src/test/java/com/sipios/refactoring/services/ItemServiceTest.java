package com.sipios.refactoring.services;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sipios.refactoring.enums.ItemEnum;
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
    @Disabled
    void getSeasonalDiscountTest() {
        
    }

    @Test
    @Disabled
    void applySeasonalDiscountTest() {

    }
}
