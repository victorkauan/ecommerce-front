import java.util.ArrayList;

public class SaleFactory {
    // Method
    public static Sale createSale(String code, Customer customer, ArrayList<Order> orders) {
        return new Sale(code, customer, orders);
    }
}
