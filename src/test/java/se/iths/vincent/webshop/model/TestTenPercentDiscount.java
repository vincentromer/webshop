package se.iths.vincent.webshop.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestTenPercentDiscount {

    @Test
    public void testCalculatePrice() {
        //Arrange
        TenPercentDiscount tenPercentDiscount = new TenPercentDiscount("");
        double price = 100;

        //Act
        double result = tenPercentDiscount.calculatePrice(price);

        //Assert
        assertEquals(90, result);
    }



}
