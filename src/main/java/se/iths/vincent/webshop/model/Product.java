package se.iths.vincent.webshop.model;

public class Product {

    private String articleNumber;
    private String title;
    private double price;
    private String description;

    public Product(String articleNumber, String title, double price, String description) {
        this.articleNumber = articleNumber;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    public String getArticleNumber() {
        return articleNumber;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setArticleNumber(String articleNumber) {
        this.articleNumber = articleNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toFileLine() {
        return articleNumber + ";" + title + ";" + price + ";" + description;
    }

}
