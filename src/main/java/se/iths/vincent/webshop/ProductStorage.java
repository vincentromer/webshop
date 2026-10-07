package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.Product;

import java.util.List;

public interface ProductStorage {

    void saveProduct(Product product);

    List<Product> getProducts();

    Product getProduct(String articleNumber);
}
