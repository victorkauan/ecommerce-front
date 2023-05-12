package models;

public class ProductCategory {
    // Attributes
    private int id;
    private String name;
    private String description;

    // Constructors
    public ProductCategory(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public ProductCategory(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Getters and setters
    // - ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
