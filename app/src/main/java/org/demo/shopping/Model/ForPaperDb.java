package org.demo.shopping.Model;

public class ForPaperDb {

    public String name;
    public double price;
    public int stock;
    public String category;
    int productid;

    public ForPaperDb()
    {

    }

    public ForPaperDb(String name, double price, int stock, String category,int productid) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.productid = productid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}

