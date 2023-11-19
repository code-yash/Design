package com.mycompany.vendingmachine.dao;

import com.mycompany.vendingmachine.exceptions.VendingMachineFullException;
import com.mycompany.vendingmachine.exceptions.ProductNotFoundException;
import com.mycompany.vendingmachine.model.Product;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Inventory {

    private Map<Integer, Product> colProductMap;
    private Map<String, Integer> productIdCountMap;
    Queue<Integer> colAvailable;
    private static volatile Inventory inventoryInstance;

    public Inventory() {
        colProductMap = new HashMap<>();
        productIdCountMap = new HashMap<>();

        colAvailable = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            colAvailable.add(i);
        }
    }

    public static Inventory getInstance() {
        if (inventoryInstance == null) {
            synchronized (Inventory.class) {
                if (inventoryInstance == null) {
                    inventoryInstance = new Inventory();
                }
            }
        }
        return inventoryInstance;
    }

    public int checkQuantity(Product product) throws ProductNotFoundException {
        if (!productIdCountMap.containsKey(product.getProductId())) {
            throw new ProductNotFoundException("Product not available");
        }
        return productIdCountMap.get(product.getProductId());
    }

    public void addProduct(Product product, int quantity) throws VendingMachineFullException {
        if (productIdCountMap.containsKey(product.getProductId())) {
            productIdCountMap.put(product.getProductId(), productIdCountMap.get(product.getProductId()) + quantity);
        }

        //add product
        if (colAvailable.isEmpty()) {
            throw new VendingMachineFullException("Vending Machine is Full. Cannot add more products! ");
        }
        colProductMap.put(colAvailable.poll(), product);
        productIdCountMap.put(product.getProductId(), quantity);
    }

    public void reduceProductQuantity(int itemCol) throws ProductNotFoundException {
        if (!colProductMap.containsKey(itemCol)) {
            throw new ProductNotFoundException("Product Not Found!");
        }

        Product product = colProductMap.get(itemCol);
        int newQuantity = productIdCountMap.get(product.getProductId()) - 1;
        if (newQuantity == 0) {
            productIdCountMap.remove(product.getProductId());
            colProductMap.remove(itemCol);
            colAvailable.add(itemCol);
        } else {
            productIdCountMap.put(product.getProductId(), newQuantity);
        }

    }

    public Product getProduct(int itemCol) throws ProductNotFoundException {

        if (!colProductMap.containsKey(itemCol)) {
            throw new ProductNotFoundException("Product Not Found!");
        }
        return colProductMap.get(itemCol);
    }

}
