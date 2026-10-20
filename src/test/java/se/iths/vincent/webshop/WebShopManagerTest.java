package se.iths.vincent.webshop;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.iths.vincent.webshop.model.Product;
import static org.junit.jupiter.api.Assertions.*;

public class WebShopManagerTest {

    ProductStorage storage;
    WebShopManager webShopManager;
    Product productOne, productTwo;

    @BeforeEach
    public void arrange() {
        // We do not have to create a ProductStorage and WebShopManager in every test method by using BeforeEach
        // Less duplicated code
        storage = new ProductListStorage();
        webShopManager = new WebShopManager(storage, null);

        productOne = new Product("1111", "TestProductOne", 100, "A test product");
        productTwo = new Product("2222", "TestProductTwo", 200, "Another test product");
    }

    @Test
    public void testSaveProductToStorage() {
        //Act
        webShopManager.saveProductToStorage(productOne);
        webShopManager.saveProductToStorage(productTwo);
        List<Product> productList = webShopManager.getProductsFromStorage();

        //Assert
        assertEquals(2, productList.size());
    }

    @Test
    public void testGetProductFromStorage() {
        //Act
        webShopManager.saveProductToStorage(productOne);
        Product retrievedProduct = webShopManager.getProductFromStorage("1111");

        //Assert
        assertEquals("1111", retrievedProduct.getArticleNumber());
    }

    @Test
    public void testNullGetProductFromStorage() {
        //Act
        Product product = webShopManager.getProductFromStorage("7777");

        //Assert
        assertNull(product);
    }

}
