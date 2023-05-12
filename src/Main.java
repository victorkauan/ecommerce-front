import controllers.CustomerController;
import controllers.ProductCategoryController;
import controllers.ProductController;
import controllers.SaleController;
import models.*;
import views.CustomerView;
import views.ProductCategoryView;
import views.ProductView;
import views.SaleView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String baseUrl = "http://localhost:3001/api";

        try {
            // CUSTOMERS
            CustomerView customerView = new CustomerView();
            CustomerController customerController = new CustomerController(customerView, baseUrl);

            // Print database customers
            System.out.println("Customers:");
            customerController.printCustomers();
            System.out.println();

            // Insert customers into database
            Customer customer0 = customerController.addCustomer(new Customer("Adrielle", "de Almeida", "customer0@edu.ur.br", "85998730111", "2004-01-03"));
            Customer customer1 = customerController.addCustomer(new Customer("Francisco Wenyo", "Costa Moises", "customer1@edu.unifor.br", "11988736510", "1995-12-30"));
            Customer customer2 = customerController.addCustomer(new Customer("José Renan", "Ferreira Damasceno", "customer2@edu.unifor.br", "85989661372", "2000-11-16"));
            Customer customer3 = customerController.addCustomer(new Customer("Victor Kauan", "Lima da Silva", "customer3@edu.unifor.br", "12987651388", "2001-01-01"));

            // Print created customers
            System.out.println("Created Customers:");
            customerView.printInfo(customer0);
            System.out.println();
            customerView.printInfo(customer1);
            System.out.println();
            customerView.printInfo(customer2);
            System.out.println();
            customerView.printInfo(customer3);
            System.out.println();

            // Update a customer
            customer0 = customerController.updateCustomer(new Customer(customer0.getId(), "Adrielle Rodrigues", "de Almeida", "customer0@edu.unifor.br", "85998730113", "2000-01-03"));

            // Print updated customer
            System.out.println("Updated Customer:");
            customerView.printInfo(customer0);
            System.out.println();

            System.out.println("====================================================================================================");
            System.out.println();

            // PRODUCT CATEGORY
            ProductCategoryView productCategoryView = new ProductCategoryView();
            ProductCategoryController productCategoryController = new ProductCategoryController(productCategoryView, baseUrl);

            // Get and print category list
            System.out.println("Product Categories:");
            productCategoryController.printProductCategories();
            System.out.println();

            // Add product categories to list
            ProductCategory productCategory0 = productCategoryController.addProductCategory(new ProductCategory("Musc", "Products rela to world of music."));
            ProductCategory productCategory1 = productCategoryController.addProductCategory(new ProductCategory("Literature", "Products related to literature of all genres."));
            ProductCategory productCategory2 = productCategoryController.addProductCategory(new ProductCategory("Games", "Products related to games and their derivatives."));
            ProductCategory productCategory3 = productCategoryController.addProductCategory(new ProductCategory("Error", "A category that should not exist."));

            // Print created categories
            System.out.println("Created Product Categories:");
            productCategoryView.printInfo(productCategory0);
            System.out.println();
            productCategoryView.printInfo(productCategory1);
            System.out.println();
            productCategoryView.printInfo(productCategory2);
            System.out.println();
            productCategoryView.printInfo(productCategory3);
            System.out.println();

            // Update a category
            productCategory0 = productCategoryController.updateProductCategory(new ProductCategory(productCategory0.getId(), "Music", "Products related to the world of music."));

            // Print updated category
            System.out.println("Updated Product Category:");
            productCategoryView.printInfo(productCategory0);
            System.out.println();

            System.out.println("====================================================================================================");
            System.out.println();

            // PRODUCT
            ProductView productView = new ProductView();
            ProductController productController = new ProductController(productView, baseUrl);

            // Get and print product list
            System.out.println("Products:");
            productController.printProducts();
            System.out.println();

            // Add products to list
            Product product0 = productController.addProduct(new Product("Apple 2022 MacBook Pro", "Apple 2022 MacBook Pro Laptop with M2 chip: 13-inch Retina Display, 8GB RAM, 256GB SSD Storage", 1119.78));
            Product product1 = productController.addProduct(new Product("Outlive: The Science and Art of Longevity", "\"One of the most important books you’ll ever read.\" - Steven D. Levitt, New York Times bestselling author of Freakonomics", 28.8));
            Product product2 = productController.addProduct(new Product("Endless Games Encore Board Game", "The basd game ver!", 12.99));
            Product product3 = productController.addProduct(new Product("Delete this product", "This product should be removed!", 0));

            // Print created products
            System.out.println("Created Products:");
            productView.printInfo(product0);
            System.out.println();
            productView.printInfo(product1);
            System.out.println();
            productView.printInfo(product2);
            System.out.println();
            productView.printInfo(product3);
            System.out.println();

            // Update a product
            product2 = productController.updateProduct(new Product(product2.getId(), "Endless Games Encore Board Game", "The best gamer ever!", 9.99));

            // Print updated product
            System.out.println("Updated Product:");
            productView.printInfo(product2);
            System.out.println();

            System.out.println("====================================================================================================");
            System.out.println();

            // SALES
            SaleView saleView = new SaleView();
            SaleController saleController = new SaleController(saleView, baseUrl);

            // Create sale list
            System.out.println("Sales:");
            saleController.printSales();
            System.out.println();

            // Add sales to list
            Sale sale0 = saleController.addSale(new Sale(customer0.getId(), new ArrayList<>(List.of(new Order(product2.getId(), 1), new Order(product0.getId(), 3)))));
            Sale sale1 = saleController.addSale(new Sale(customer2.getId(), new ArrayList<>(List.of(new Order(product3.getId(), 4)))));

            // Print created sales
            System.out.println("Created Sales:");
            saleView.printInfo(sale0);
            System.out.println();
            saleView.printInfo(sale1);
            System.out.println();

            // Update a sale
            saleController.updateSale(new Sale(sale0.getId(), customer1.getId(), new ArrayList<>(List.of(new Order(product0.getId(), 3)))));

            // Print updated sale
            System.out.println("Updated Sale:");
            saleView.printInfo(sale0);
            System.out.println();

            System.out.println("====================================================================================================");
            System.out.println();

            // Delete all sales
            System.out.println("Deleting Created Sales...");
            saleController.deleteSale(sale0.getId());
            saleController.deleteSale(sale1.getId());
            System.out.println("- [SUCCESS]");
            System.out.println();

            // Delete all categories
            System.out.println("Deleting Created Categories...");
            productCategoryController.deleteProductCategory(productCategory0.getId());
            productCategoryController.deleteProductCategory(productCategory1.getId());
            productCategoryController.deleteProductCategory(productCategory2.getId());
            productCategoryController.deleteProductCategory(productCategory3.getId());
            System.out.println("- [SUCCESS]");
            System.out.println();

            // Delete all products
            System.out.println("Deleting Created Products...");
            productController.deleteProduct(product0.getId());
            productController.deleteProduct(product1.getId());
            productController.deleteProduct(product2.getId());
            productController.deleteProduct(product3.getId());
            System.out.println("- [SUCCESS]");
            System.out.println();

            // Delete all customers
            System.out.println("Deleting Created Customers...");
            customerController.deleteCustomer(customer0.getId());
            customerController.deleteCustomer(customer1.getId());
            customerController.deleteCustomer(customer2.getId());
            customerController.deleteCustomer(customer3.getId());
            System.out.println("- [SUCCESS]");
        } catch (Exception exception) {
            System.out.println("[ERROR] " + exception.getMessage());
            System.exit(1);
        }
    }
}
