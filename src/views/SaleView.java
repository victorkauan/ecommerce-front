package views;

import models.Order;
import models.Sale;

import java.util.ArrayList;

public class SaleView {
    // Print sale's information
    public void printInfo(Sale sale) {
        System.out.println("- Customer ID: " + sale.getCustomerId());
        System.out.println();

        ArrayList<Order> orders = sale.getOrders();
        if (orders.size() > 0) {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("  - Product ID: " + orders.get(i).getProductId());
                System.out.println("  - Quantity: " + orders.get(i).getQuantity());

                if (i < orders.size() - 1) {
                    System.out.println();
                }
            }
        }
    }
}
