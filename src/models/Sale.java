package models;

import java.util.ArrayList;

public class Sale {
    // Attributes
    private int id;
    private int customerId;
    private ArrayList<Order> orders;
    private String saleDate;

    // Constructor
    public Sale(int customerId, ArrayList<Order> orders) {
        this.customerId = customerId;
        this.orders = orders;
        this.saleDate = "";
    }

    public Sale(int id, int customerId, ArrayList<Order> orders) {
        this.id = id;
        this.customerId = customerId;
        this.orders = orders;
        this.saleDate = "";
    }

    // Getters and setters
    // - ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // - models.Customer
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // - Orders
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // - models.Sale date
    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }
}
