package se.iths.vincent.webshop;

import se.iths.vincent.webshop.model.ProductFileStorage;

public class Main {
    public static void main(String[] args) {
        ProductStorage storage = new ProductFileStorage();
        OutInputHandler outInputHandler = new ConsoleOutInputHandler();
        WebShopManager webShopManager = new WebShopManager(storage, outInputHandler);
        webShopManager.startWebShop();
    }
}
