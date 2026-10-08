package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductListStorage implements ProductStorage {

    private List<Product> products = new ArrayList<>();

    public void saveProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(String articleNumber) {
        for (Product product : products) {
            if (product.getArticleNumber().equals(articleNumber)) {
                return product;
            }
        }
        return null;
    }


}
