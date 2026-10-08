package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.Discount;
import se.iths.vincent.webshop.model.HalfPriceDiscount;
import se.iths.vincent.webshop.model.Product;
import se.iths.vincent.webshop.model.TenPercentDiscount;

import javax.swing.*;
import java.util.List;

public class WebShopManager {

    private ProductStorage productStorage;

    private OutInputHandler outInputHandler;


    public WebShopManager(ProductStorage productStorage, OutInputHandler outInputHandler) {
        this.productStorage = productStorage;
        this.outInputHandler = outInputHandler;
    }

    void saveProductToStorage(Product product) {
        productStorage.saveProduct(product);
    }

    List<Product> getProductsFromStorage() {
        return productStorage.getProducts();
    }

    Product getProductFromStorage(String articleNumber) {
        return productStorage.getProduct(articleNumber);
    }

    public void startWebShop() {
        Discount discount = null;
        String input = outInputHandler.prompt("Enter discount code: ");

        if (input.equalsIgnoreCase("halfprice")) {
            discount = new HalfPriceDiscount("Half off all products.");
        }
        else {
            discount = new TenPercentDiscount("Ten percent off all products.");
        }


        boolean quit = false;

        while (!quit) {
            String choice = outInputHandler.menu();
            if (choice == null) continue;
            switch (choice) {
                case "1":
                    String articleNumber = outInputHandler.prompt("Enter article number: ");
                    String title = outInputHandler.prompt("Enter title: ");
                    // Converts input to a double
                    double price = Double.parseDouble(outInputHandler.prompt("Enter price: "));
                    String description = outInputHandler.prompt("Enter description: ");

                    Product product = new Product(articleNumber, title, price, description);
                    saveProductToStorage(product);
                    outInputHandler.info("Added product to shop.");
                    break;
                case "2":
                    List<Product> products = getProductsFromStorage();
                    outInputHandler.info("""
                            Here is a list of products:
                            (If nothing shows up there are no products saved)
                            """);
                    for (Product p : products) {
                        outInputHandler.info(getProductInfo(p, discount));
                    }
                    break;
                case "3":
                    // Information about a product
                    String query = outInputHandler.prompt("Enter article number: ");
                    Product foundProduct = getProductFromStorage(query);
                    if (foundProduct != null) {
                        outInputHandler.info(getProductInfo(foundProduct, discount));
                    }
                    else {
                        outInputHandler.info("Could not find product with article number " + query);
                    }
                    break;
                case "4":
                    quit = true;
                    outInputHandler.info("Quitting program...");
                    // Exit program
                    break;
                default:
                    // Invalid choice
                    break;
            }

        }





    }

    private String getProductInfo(Product product, Discount discount) {
        String info = """
                [%1$s]
                Description: %2$s
                Price: %3$s
                Discounted price: %4$s
                Article number: %5$s
                """;
        return info.formatted(product.getTitle(), product.getDescription(),
                product.getPrice(), discount.calculatePrice(product.getPrice()), product.getArticleNumber());
    }
}
