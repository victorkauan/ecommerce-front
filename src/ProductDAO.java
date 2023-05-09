import java.util.HashMap;

public class ProductDAO {
    // Attributes
    private final HashMap<String, Product> products;
    private final HashMap<String, Category> categories;

    // Constructor
    public ProductDAO(HashMap<String, Category> categories) {
        this.products = new HashMap<>();
        this.categories = categories;
    }

    // CREATE
    public void add(String code, String name, String description, double price, String[] categoryCodes) throws Exception {
        if (products.get(code) != null) {
            throw new Exception("A product with code \"" + code + "\" already exists.");
        }

        HashMap<String, Category> newCategories = new HashMap<>();
        for (String categoryCode : categoryCodes) {
            Category category = categories.get(categoryCode);
            if (category == null) {
                throw new Exception("A category with code \"" + code + "\" does not exists.");
            }

            newCategories.put(categoryCode, category);
        }

        Product product = ProductFactory.createProduct(code, name, description, price, newCategories);
        products.put(code, product);

        System.out.println("A product with code \"" + code + "\" has been created.");
    }

    // READ
    public Product get(String code) {
        return products.get(code);
    }

    // UPDATE
    public void update(String code, String name, String description, double price, String[] categoryCodes) throws Exception {
        if (products.get(code) == null) {
            throw new Exception("A product with code \"" + code + "\" does not exists.");
        }

        HashMap<String, Category> newCategories = new HashMap<>();
        for (String categoryCode : categoryCodes) {
            Category category = categories.get(categoryCode);
            if (category == null) {
                throw new Exception("A category with code \"" + code + "\" does not exists.");
            }

            newCategories.put(categoryCode, category);
        }

        Product product = ProductFactory.createProduct(code, name, description, price, newCategories);
        products.put(code, product);

        System.out.println("A product with code \"" + code + "\" has been updated.");
    }

    // DELETE
    public void remove(String code) throws Exception {
        if (products.get(code) == null) {
            throw new Exception("A product with code \"" + code + "\" does not exists.");
        }

        products.remove(code);

        System.out.println("A product with code \"" + code + "\" has been removed.");
    }

    // Get list
    public HashMap<String, Product> getProducts() {
        return products;
    }
}
