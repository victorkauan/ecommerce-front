public class Order {
    // Attributes
    private Product product;
    private int quantity;

    // Constructor
    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Method
    // Get order price
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    // Getters and setters
    // - Product
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // - Quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
