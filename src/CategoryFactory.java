public class CategoryFactory {
    // Method
    public static Category createCategory(String code, String name, String description) {
        return new Category(code, name, description);
    }
}
