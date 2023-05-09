import java.util.HashMap;

public class CategoryDAO {
    // Attribute
    private final HashMap<String, Category> categories;

    // Constructor
    public CategoryDAO() {
        this.categories = new HashMap<>();
    }

    // CREATE
    public void add(String code, String name, String description) throws Exception {
        if (categories.get(code) != null) {
            throw new Exception("A category with code \"" + code + "\" already exists.");
        }

        Category category = CategoryFactory.createCategory(code, name, description);
        categories.put(code, category);

        System.out.println("A category with code \"" + code + "\" has been created.");
    }

    // READ
    public Category get(String code) {
        return categories.get(code);
    }

    // UPDATE
    public void update(String code, String name, String description) throws Exception {
        if (categories.get(code) == null) {
            throw new Exception("A category with code \"" + code + "\" does not exists.");
        }

        Category category = CategoryFactory.createCategory(code, name, description);
        categories.replace(code, category);

        System.out.println("A category with code \"" + code + "\" has been updated.");
    }

    // DELETE
    public void remove(String code) throws Exception {
        if (categories.get(code) == null) {
            throw new Exception("A category with code \"" + code + "\" does not exists.");
        }

        categories.remove(code);

        System.out.println("A category with code \"" + code + "\" has been removed.");
    }

    // Get list
    public HashMap<String, Category> getCategories() {
        return categories;
    }
}
