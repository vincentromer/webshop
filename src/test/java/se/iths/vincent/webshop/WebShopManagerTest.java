package se.iths.vincent.webshop;


import java.util.List;
import org.junit.jupiter.api.Test;
import se.iths.vincent.webshop.model.Product;
import static org.junit.jupiter.api.Assertions.*;

public class WebShopManagerTest {

    @Test
    public void testSaveProductToStorage() {
        //Arrange
        ProductStorage storage = new ProductListStorage();
        WebShopManager webShopManager = new WebShopManager(storage, null);
        Product productOne = new Product("1111", "TestProductOne", 100, "A test product");
        Product productTwo = new Product("2222", "TestProductTwo", 200, "Another test product");

        //Act
        webShopManager.saveProductToStorage(productOne);
        webShopManager.saveProductToStorage(productTwo);
        List<Product> productList = webShopManager.getProductsFromStorage();

        //Assert
        assertEquals(2, productList.size());
    }

    @Test
    public void testGetProductFromStorage() {
        //Arrange
        ProductStorage storage = new ProductListStorage();
        WebShopManager webShopManager = new WebShopManager(storage, null);
        Product product = new Product("1111", "TestProduct", 100, "Test product");

        //Act
        webShopManager.saveProductToStorage(product);
        Product retrievedProduct = webShopManager.getProductFromStorage("1111");

        //Assert
        assertEquals("1111", retrievedProduct.getArticleNumber());
    }

    @Test
    public void testNullGetProductFromStorage() {
        //Arrange
        ProductStorage storage = new ProductListStorage();
        WebShopManager webShopManager = new WebShopManager(storage, null);

        //Act
        Product product = webShopManager.getProductFromStorage("7777");

        //Assert
        assertNull(product);
    }

}
