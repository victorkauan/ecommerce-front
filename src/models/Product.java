package models;

import java.util.ArrayList;
import java.util.List;

public class Product {
    // Attributes
    private int id;
    private String name;
    private String description;
    private double price;
    private List<Integer> productCategoryIds;

    // Constructors
    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategoryIds = new ArrayList<>();
    }

    public Product(String name, String description, double price, List<Integer> productCategoryIds) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategoryIds = productCategoryIds;
    }

    public Product(int id, String name, String description, double price, List<Integer> productCategoryIds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategoryIds = productCategoryIds;
    }

    public Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.productCategoryIds = new ArrayList<>();
    }

    // Methods
    // Add category
    public void addCategory(Integer productCategoryId) {
        productCategoryIds.add(productCategoryId);
    }

    // Remove category
    public void removeCategory(Integer productCategoryId) {
        productCategoryIds.remove(productCategoryId);
    }

    // Getters and setters
    // - ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // - Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // - Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // - Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // - Product Category IDs
    public List<Integer> getProductCategoryIds() {
        return productCategoryIds;
    }

    public void setProductCategoryIds(List<Integer> productCategoryIds) {
        this.productCategoryIds = productCategoryIds;
    }
}
