public class OrderFactory {
    public static Order createOrder(Product product, int quantity) {
        return new Order(product, quantity);
    }
}
