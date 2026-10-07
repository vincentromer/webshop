package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.ProductFileStorage;

public class Main {
    public static void main(String[] args) {
        ProductStorage storage = new ProductFileStorage();
        WebShopManager webShopManager = new WebShopManager(storage);
        webShopManager.startWebShop();
    }
}
