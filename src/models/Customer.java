package models;

public class Customer {
    // Attributes
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String birthDate;

    // Constructors
    public Customer(String firstName, String lastName, String email, String phone, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public Customer(int id, String firstName, String lastName, String email, String phone, String birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    // Getters and setters
    // - ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // - First name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // - Last name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // - Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // - Phone number
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // - Birth date
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
