import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // CUSTOMER
            System.out.println("CUSTOMER:");
            System.out.println();

            // Create customer list
            CustomerDAO customerList = new CustomerDAO();

            // Add customers to list
            customerList.add("2218022", "Adrielle Rodrigues", "de Almeida", "student0@edu.unifor.br", "85998730113", LocalDate.of(1999, 1, 20));
            customerList.add("2216600", "Francisco Wenyo", "Costa Moises", "student1@edu.unifor.br", "11988736510", LocalDate.of(1995, 12, 30));
            customerList.add("2213002", "Victor Kauan", "Lima da Silva", "student03@edu.unifor.br", "12987651388", LocalDate.of(2001, 1, 1));
            customerList.add("2213006", "José Renan", "Ferreira Damasceno", "student2@edu.unifor.br", "85989661372", LocalDate.of(2000, 11, 16));

            // Update a customer
            customerList.update("2213002", "Victor Kauan", "Lima de Oliveira", "student3@edu.unifor.br", "85987651364", LocalDate.of(2004, 1, 1));

            // Remove a customer
            customerList.remove("2213006");

            System.out.println();

            // Print a customer's information
            customerList.get("2213002").printInfo();

            System.out.println("\n====================================================================================================\n");

            // PRODUCT CATEGORY
            System.out.println("PRODUCT CATEGORY:");
            System.out.println();

            // Create category list
            CategoryDAO categoryList = new CategoryDAO();

            // Add product categories to list
            categoryList.add("00", "Musc", "Products rela to world of music.");
            categoryList.add("01", "Literature", "Products related to literature of all genres.");
            categoryList.add("02", "Games", "Products related to games and their derivatives.");
            categoryList.add("03", "Error", "A category that should not exist.");

            // Update a category
            categoryList.update("00", "Music", "Products related to the world of music.");

            // Remove a category
            categoryList.remove("03");

            System.out.println();

            // Print a category's information
            categoryList.get("02").printInfo();

            System.out.println("\n====================================================================================================\n");

            // PRODUCT
            System.out.println("PRODUCT:");
            System.out.println();

            // Create product list
            ProductDAO productList = new ProductDAO(categoryList.getCategories());

            // Add products to list
            productList.add("000", "Apple 2022 MacBook Pro", "Apple 2022 MacBook Pro Laptop with M2 chip: 13-inch Retina Display, 8GB RAM, 256GB SSD Storage", 1119.78, new String[]{});
            productList.add("001", "Outlive: The Science and Art of Longevity", "\"One of the most important books you’ll ever read.\" - Steven D. Levitt, New York Times bestselling author of Freakonomics", 28.8, new String[]{ "01" });
            productList.add("002", "Endless Games Encore Board Game", "", 24.99, new String[]{ "02" });
            productList.add("003", "Delete this product", "This product should be removed!", 0, new String[]{});

            // Update a product
            productList.update("002", "Endless Games Encore Board Game - Sing Songs to Win", "SING AND PLAY: Can you sing a song with \"love\" in the lyrics? How about \"heart\"?", 16.49, new String[]{ "00", "02" });

            // Remove a product
            productList.remove("003");

            System.out.println();

            // Print a product's information
            productList.get("002").printInfo();

            System.out.println("\n====================================================================================================\n");

            // SALE
            System.out.println("SALE:");
            System.out.println();

            // Create sale list
            SaleDAO saleList = new SaleDAO(customerList.getCustomers(), productList.getProducts());

            // Add sales to list
            ArrayList<Order> orders0 = new ArrayList<>();
            orders0.add(OrderFactory.createOrder(productList.get("000"), 2));
            orders0.add(OrderFactory.createOrder(productList.get("001"), 1));

            ArrayList<Order> orders1 = new ArrayList<>();
            orders1.add(OrderFactory.createOrder(productList.get("002"), 3));

            saleList.add("9812870342", "2213002", orders0);
            saleList.add("8918230230", "2218022", orders1);

            // Update a sale
            saleList.update("8918230230", "2216600", orders1);

            // Remove a sale
            saleList.remove("9812870342");

            System.out.println();

            // Print a sale's information
            saleList.get("8918230230").printInfo();
        } catch (Exception exception) {
            System.out.println("[ERROR] " + exception.getMessage());
            System.exit(1);
        }
    }
}
