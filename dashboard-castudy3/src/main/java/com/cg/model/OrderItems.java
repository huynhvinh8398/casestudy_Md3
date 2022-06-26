package com.cg.model;

public class OrderItems {
    private int idOrderItems;
    private int idProduct;
    private int idOrder;
    private String productName;
    private double price;
    private int quantity;
    private double total;

    public OrderItems() {
    }

    public OrderItems(int idOrderItems, int idProduct, int idOrder, String productName, double price, int quantity, double total) {
        this.idOrderItems = idOrderItems;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public int getIdOrderItems() {
        return idOrderItems;
    }

    public void setIdOrderItems(int idOrderItems) {
        this.idOrderItems = idOrderItems;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "idOrderItems=" + idOrderItems +
                ", idProduct=" + idProduct +
                ", idOrder=" + idOrder +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}

