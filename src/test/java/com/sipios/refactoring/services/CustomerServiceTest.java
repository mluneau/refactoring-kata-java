package com.sipios.refactoring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sipios.refactoring.enums.CustomerDiscountEnum;
import com.sipios.refactoring.exceptions.BadRequestException;
import com.sipios.refactoring.models.Customer;
import com.sipios.refactoring.repositories.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    
    @Mock
    private CustomerRepository customerRepository;
    private CustomerService underTest;


    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @Test
    void belowPlatiniumCustomerPriceLimitTest() {
        // given
        Customer customerPlatiniumTest = new Customer(6L, "platinium_user", CustomerDiscountEnum.PLATINIUM);
        int price = 1900;

        // when 
        String expected = underTest.customerPriceLimit(customerPlatiniumTest, price);

        // then
        assertEquals(expected, "1900.0");
    }

    @Test
    void abovePlatiniumCustomerPriceLimitTest() {
        // given
        Customer customerPlatiniumTest = new Customer(6L, "platinium_user", CustomerDiscountEnum.PLATINIUM);
        int price = 2100;

        // when + then
        try {
            underTest.customerPriceLimit(customerPlatiniumTest, price);
 
        } catch (Exception err) {
            assertEquals(("Price (2100.0) is too high for PLATINIUM_CUSTOMER customer"), err.getMessage());
        }
    }

    @Test
    void atLimitPlatiniumCustomerPriceLimitTest() {
        // given
        Customer customerPlatiniumTest = new Customer(6L, "platinium_user", CustomerDiscountEnum.PLATINIUM);
        int price = 2000;

       // when 
       String expected = underTest.customerPriceLimit(customerPlatiniumTest, price);

       // then
       assertEquals(expected, "2000.0");
    }

    @Test
    void belowPremiumCustomerPriceLimitTest() {
        // given
        Customer customerPremiumTest = new Customer(6L, "Premium_user", CustomerDiscountEnum.PREMIUM);
        int price = 750;

        // when 
        String expected = underTest.customerPriceLimit(customerPremiumTest, price);

        // then
        assertEquals(expected, "750.0");
    }

    @Test
    void abovePremiumCustomerPriceLimitTest() {
        // given
        Customer customerPremiumTest = new Customer(6L, "Premium_user", CustomerDiscountEnum.PREMIUM);
        int price = 925;

        // when + then
        try {
            underTest.customerPriceLimit(customerPremiumTest, price);
 
        } catch (Exception err) {
            assertEquals(("Price (925.0) is too high for PREMIUM_CUSTOMER customer"), err.getMessage());
        }
    }

    @Test
    void atLimitPremiumCustomerPriceLimitTest() {
        // given
        Customer customerPremiumTest = new Customer(6L, "Premium_user", CustomerDiscountEnum.PREMIUM);
        int price = 800;

       // when 
       String expected = underTest.customerPriceLimit(customerPremiumTest, price);

       // then
       assertEquals(expected, "800.0");
    }

    @Test
    void belowStandardCustomerPriceLimitTest() {
        // given
        Customer customerStandardTest = new Customer(6L, "Standard_user", CustomerDiscountEnum.STANDARD);
        int price = 115;

        // when 
        String expected = underTest.customerPriceLimit(customerStandardTest, price);

        // then
        assertEquals(expected, "115.0");
    }

    @Test
    void aboveStandardCustomerPriceLimitTest() {
        // given
        Customer customerStandardTest = new Customer(6L, "Standard_user", CustomerDiscountEnum.STANDARD);
        int price = 201;

        // when + then
        try {
            underTest.customerPriceLimit(customerStandardTest, price);
 
        } catch (Exception err) {
            assertEquals(("Price (201.0) is too high for STANDARD_CUSTOMER customer"), err.getMessage());
        }
    }

    @Test
    void atLimitStandardCustomerPriceLimitTest() {
        // given
        Customer customerStandardTest = new Customer(6L, "Standard_user", CustomerDiscountEnum.STANDARD);
        int price = 200;

       // when 
       String expected = underTest.customerPriceLimit(customerStandardTest, price);

       // then
       assertEquals(expected, "200.0");
    }

    @Test
    void belowYouthCustomerPriceLimitTest() {
        // given
        Customer customerYouthTest = new Customer(6L, "Youth_user", CustomerDiscountEnum.YOUTH);
        int price = 69;

        // when 
        String expected = underTest.customerPriceLimit(customerYouthTest, price);

        // then
        assertEquals(expected, "69.0");
    }

    @Test
    void aboveYouthCustomerPriceLimitTest() {
        // given
        Customer customerYouthTest = new Customer(6L, "Youth_user", CustomerDiscountEnum.YOUTH);
        int price = 103;

        // when + then
        try {
            underTest.customerPriceLimit(customerYouthTest, price);
 
        } catch (Exception err) {
            assertEquals(("Price (103.0) is too high for YOUNG_CUSTOMER customer"), err.getMessage());
        }
    }

    @Test
    void atLimitYouthCustomerPriceLimitTest() {
        // given
        Customer customerYouthTest = new Customer(6L, "Youth_user", CustomerDiscountEnum.YOUTH);
        int price = 100;

       // when 
       String expected = underTest.customerPriceLimit(customerYouthTest, price);

       // then
       assertEquals(expected, "100.0");
    }


}
