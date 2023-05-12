package views;

import models.ProductCategory;

public class ProductCategoryView {
    // Print category's information
    public void printInfo(ProductCategory category) {
        System.out.println("- ID: " + category.getId());
        System.out.println("- Name: " + category.getName());
        System.out.println("- Description: " + category.getDescription());
    }
}
