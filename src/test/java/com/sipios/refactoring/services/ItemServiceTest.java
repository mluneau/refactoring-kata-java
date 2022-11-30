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
    void getAllItemsTest() {
        //when
        underTest.getAllItems();
        
        //then
        verify(itemRepository).findAll();
    }

    @Test
    @Disabled
    void addItemTest() {
        //given
        Item itemTest = new Item(12, ItemEnum.TSHIRT);
        
        //when
        underTest.addItem(itemTest);
        
        //then
        ArgumentCaptor<Item> iArgumentCaptor = ArgumentCaptor.forClass(Item.class);
        verify(itemRepository).save(iArgumentCaptor.capture());
    }

    @Test
    void deleteItemTest() {

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
