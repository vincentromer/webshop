package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.Discount;
import se.iths.vincent.webshop.model.HalfPriceDiscount;
import se.iths.vincent.webshop.model.TenPercentDiscount;

public class WebShopManager {

    public void startWebShop() {
        Discount discount = null;
        String input = IO.readln("Enter a discount code: ");

        if (input.equalsIgnoreCase("halfprice")) {
            discount = new HalfPriceDiscount("Half off all products.");
        }
        else {
            discount = new TenPercentDiscount("Ten percent off all products.");
        }
    }
}
