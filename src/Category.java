public class Category {
    // Attributes
    private String code;
    private String name;
    private String description;

    // Constructor
    public Category(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    // Method
    // Print category's information
    public void printInfo() {
        System.out.println("Category Information:");
        System.out.println("- Code: " + this.getCode());
        System.out.println("- Name: " + this.getName());
        System.out.println("- Description: " + this.getDescription());
    }

    // Print category's main information
    public void printMainInfo() {
        System.out.println("- [" + this.getCode() + "] " + this.getName());
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
}
