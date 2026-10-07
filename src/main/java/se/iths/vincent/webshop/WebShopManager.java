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
            String choice = IO.readln("Choice: ");
            switch (choice) {
                case "1":
                    String articleNumber = IO.readln("Enter article number: ");
                    String title = IO.readln("Enter title: ");
                    // Converts input to a double
                    double price = Double.parseDouble(IO.readln("Enter price: "));
                    String description = IO.readln("Enter description: ");

                    Product product = new Product(articleNumber, title, price, description);
                    saveProductToStorage(product);
                    IO.println("Added product to shop.");
                    break;
                case "2":
                    List<Product> products = getProductsFromStorage();
                    for (Product p : products) {
                        printProductInfo(p, discount);
                        IO.println();
                    }
                    break;
                case "3":
                    // Information about a product
                    String query = IO.readln("Enter article number: ");
                    Product foundProduct = getProductFromStorage(query);
                    if (foundProduct != null) {
                        printProductInfo(foundProduct, discount);
                    }
                    else {
                        IO.println("Could not find product with article number " + query);
                    }
                    break;
                case "4":
                    quit = true;
                    IO.println("Quitting program...");
                    // Exit program
                    break;
                default:
                    // Invalid choice
                    break;
            }

        }





    }

    private void printMenu(String... menuItems) {
        for (String item : menuItems) {
            IO.println(item);
        }
    }

    private void printProductInfo(Product product, Discount discount) {
        IO.println("[" + product.getTitle() + "]");
        IO.println(("Description: " + product.getDescription()));
        IO.println(("Price: " + product.getPrice()));
        IO.println("Discounted price: " + discount.calculatePrice(product.getPrice()));
        IO.println("Article number: " + product.getArticleNumber());
    }
}
