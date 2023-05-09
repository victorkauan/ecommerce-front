import java.util.HashMap;

public class ProductFactory {
    // Method
    public static Product createProduct(String code, String name, String description, double price, HashMap<String, Category> categories) {
        return new Product(code, name, description, price, categories);
    }
}
