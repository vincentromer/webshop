package se.iths.vincent.webshop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestHalfPriceDiscount {

    @Test
    public void testCalculatePrice() {
        //Arrange
        HalfPriceDiscount halfPriceDiscount = new HalfPriceDiscount("");
        double price = 100;

        //Act
        double result = halfPriceDiscount.calculatePrice(price);

        //Assert
        assertEquals(50, result);
    }

}
