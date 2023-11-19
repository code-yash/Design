package com.mycompany.vendingmachine.model;

import java.util.UUID;

public class Product {

    private final String productId;
    private String productName;
    private int productPrice;

    public Product(String productName, int productPrice) {
        this.productId = UUID.randomUUID().toString();
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

}
