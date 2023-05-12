package views;

import models.Product;

public class ProductView {
    // Print product's information
    public void printInfo(Product product) {
        System.out.println("- ID: " + product.getId());
        System.out.println("- Name: " + product.getName());
        System.out.println("- Description: " + product.getDescription());
        System.out.println("- Price: $ " + product.getPrice());
    }
}
