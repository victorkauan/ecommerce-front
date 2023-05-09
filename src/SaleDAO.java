import java.util.ArrayList;
import java.util.HashMap;

public class SaleDAO {
    // Attributes
    HashMap<String, Customer> customers;
    HashMap<String, Product> products;
    HashMap<String, Sale> sales;

    // Constructor
    public SaleDAO(HashMap<String, Customer> customers, HashMap<String, Product> products) {
        this.customers = customers;
        this.products = products;
        this.sales = new HashMap<>();
    }

    // CREATE
    public void add(String code, String customerCode, ArrayList<Order> orders) throws Exception {
        if (sales.get(code) != null) {
            throw new Exception("A sale with code \"" + code + "\" already exists.");
        }

        for (Order order : orders) {
            if (products.get(order.getProduct().getCode()) == null) {
                throw new Exception("A product with code \"" + code + "\" does not exists.");
            }
        }

        Customer customer = customers.get(customerCode);
        if (customer == null) {
            throw new Exception("A customer with code \"" + code + "\" does not exists.");
        }

        Sale sale = SaleFactory.createSale(code, customer, orders);
        sales.put(code, sale);

        System.out.println("A sale with code \"" + code + "\" has been created.");
    }

    // READ
    public Sale get(String code) {
        return sales.get(code);
    }

    // UPDATE
    public void update(String code, String customerCode, ArrayList<Order> orders) throws Exception {
        if (sales.get(code) == null) {
            throw new Exception("A sale with code \"" + code + "\" does not exists.");
        }

        for (Order order : orders) {
            if (products.get(order.getProduct().getCode()) == null) {
                throw new Exception("A product with code \"" + code + "\" does not exists.");
            }
        }

        Customer customer = customers.get(customerCode);
        if (customer == null) {
            throw new Exception("A customer with code \"" + code + "\" does not exists.");
        }

        Sale sale = SaleFactory.createSale(code, customer, orders);
        sales.put(code, sale);

        System.out.println("A sale with code \"" + code + "\" has been updated.");
    }

    // DELETE
    public void remove(String code) throws Exception {
        if (sales.get(code) == null) {
            throw new Exception("A sale with code \"" + code + "\" does not exists.");
        }

        sales.remove(code);

        System.out.println("A sale with code \"" + code + "\" has been removed.");
    }
}
