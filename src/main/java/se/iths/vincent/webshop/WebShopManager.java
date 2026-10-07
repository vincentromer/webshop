package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.Discount;
import se.iths.vincent.webshop.model.HalfPriceDiscount;
import se.iths.vincent.webshop.model.Product;
import se.iths.vincent.webshop.model.TenPercentDiscount;

import java.util.List;

public class WebShopManager {

    private ProductStorage productStorage;

    public WebShopManager(ProductStorage productStorage) {
        this.productStorage = productStorage;
    }

    public void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    public List<Product> getProductsFromStorage() {
        return productStorage.getProducts();
    }

    public Product getProductFromStorage(String articleNumber) {
        return productStorage.getProduct(articleNumber);
    }

    public void startWebShop() {
        Discount discount = null;
        String input = IO.readln("Enter a discount code: ");

        if (input.equalsIgnoreCase("halfprice")) {
            discount = new HalfPriceDiscount("Half off all products.");
        }
        else {
            discount = new TenPercentDiscount("Ten percent off all products.");
        }

        boolean quit = false;

        while (!quit) {
            printMenu("1. Add a product", "2. List all products",
                    "3. Show information about a product", "4. Exit program");

        }





    }

    private void printMenu(String... menuItems) {
        for (String item : menuItems) {
            IO.println(item);
        }
    }
}
