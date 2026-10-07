package se.iths.vincent.webshop.model;

import se.iths.vincent.webshop.ProductStorage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ProductFileStorage implements ProductStorage {

    private Path path = Path.of("products.txt");


    public void saveProduct(Product product) {
        if (Files.exists(path)) {
            try {
                Files.writeString(path, product.toFileLine(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
            catch (IOException exception) {
                IO.println("Could not write to file: " + exception.getMessage());
            }
        }
    }

    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        if (Files.exists(path)) {
            try {
                for (String line : Files.readAllLines(path)) {
                    Product product = Product.fromFileLine(line);
                    products.add(product);
                }
                return products;
            }
            catch (IOException exception) {
                IO.println("Could not read file: " + exception.getMessage());
                return products;
            }
        }
        else {
            // If file does not exist return the empty list
            return products;
        }
    }

    public Product getProduct(String articleNumber) {
        List<Product> products = getProducts();

        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
            else {
               continue;
            }
        }
        // If no product is returned, none was found so then return null
        return null;
    }
}
