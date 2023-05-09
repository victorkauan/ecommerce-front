import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Sale {
    // Attributes
    private String code;
    private Customer customer;
    private ArrayList<Order> orders;
    private LocalDate saleDate;

    // Constructor
    public Sale(String code, Customer customer, ArrayList<Order> orders) {
        this.code = code;
        this.customer = customer;
        this.orders = orders;
        this.saleDate = LocalDate.now();
    }

    // Method
    // Get sale total price
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (Order order : orders) {
            totalPrice += order.getTotalPrice();
        }

        return totalPrice;
    }

    // Print sale's information
    public void printInfo() {
        System.out.println("Sale Information:");
        System.out.println("- Total price: $ " + this.getTotalPrice());
        System.out.println("- Sale date: " + this.getFormattedDate(this.getSaleDate(), "yyyy/MM/dd"));

        System.out.println();

        customer.printInfo();

        if (orders.size() > 0) {
            for (Order order : orders) {
                System.out.println();
                System.out.println("Order Information:");
                System.out.println("- Price: $ " + order.getTotalPrice());
                System.out.println("- Quantity: " + order.getQuantity());
                order.getProduct().printInfo();
            }
        }
    }

    // Get formatted date
    public String getFormattedDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    // Getters and setters
    // - Code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // - Customer
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // - Orders
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    // - Sale date
    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }
}
