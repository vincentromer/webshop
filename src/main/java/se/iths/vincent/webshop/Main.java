package se.iths.vincent.webshop;

public class Main {
    public static void main(String[] args) {
        ProductStorage webShopStorage = new ProductFileStorage();
        OutInputHandler outInputHandler = new GUIOutInputHandler();
        WebShopManager webShopManager = new WebShopManager(webShopStorage, outInputHandler);
        webShopManager.startWebShop();
    }
}
