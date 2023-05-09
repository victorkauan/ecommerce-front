import java.util.HashMap;
import java.util.Map;

public class Product {
    // Attributes
    private String code;
    private String name;
    private String description;
    private double price;
    private HashMap<String, Category> categories;

    // Constructor
    public Product(String code, String name, String description, double price, HashMap<String, Category> categories) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categories = categories;
    }

    // Methods
    // Add category
    public void addCategory(String code, String name, String description) {
        Category category = CategoryFactory.createCategory(code, name, description);
        categories.put(code, category);
    }

    // Remove category
    public void removeCategory(String categoryCode) throws Exception {
        Category category = categories.get(categoryCode);
        if (category == null) {
            throw new Exception("A category with code \"" + code + "\" does not exists.");
        }

        categories.remove(categoryCode);
    }

    // Print product's information
    public void printInfo() {
        System.out.println("Product Information:");
        System.out.println("- Code: " + this.getCode());
        System.out.println("- Name: " + this.getName());
        System.out.println("- Description: " + this.getDescription());
        System.out.println("- Price: $ " + this.getPrice());

        if (categories.size() > 0) {
            System.out.println("Categories:");
            for (Map.Entry<String, Category> pair : categories.entrySet()) {
                pair.getValue().printMainInfo();
            }
        }
    }

    // Getters and setters
    // - Code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // - Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // - Description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // - Price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // - Categories
    public HashMap<String, Category> getCategories() {
        return categories;
    }

    public void setCategories(HashMap<String, Category> categories) {
        this.categories = categories;
    }
}
