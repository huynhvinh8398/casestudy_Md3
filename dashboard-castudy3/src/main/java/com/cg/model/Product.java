package com.cg.model;

public class Product {
    private int idProduct;
    private String name;
    private double price;
    private int quantity;
    private String Category;
    private String image;

    public Product() {
    }

    public Product(int idProduct, String name, double price, int quantity, String Category, String image) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Category = Category;
        this.image = image;
    }

    public Product(int idProduct,String name,double price, int quantity,String Category) {
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Category = Category;
    }
    public Product(String name, double price, int quantity, String Category, String image) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Category = Category;
        this.image = image;
    }

    public Product(String name, double price, int quantity, String Category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Category = Category;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + idProduct +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", description='" + Category + '\'' +
                ", img='" + image + '\'' +
                '}';
    }
}

