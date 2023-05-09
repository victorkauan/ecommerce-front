import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {
    // Attributes
    private String code;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate birthDate;

    // Constructor
    public Customer(String code, String firstName, String lastName, String email, String phone, LocalDate birthDate) {
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    // Methods
    // Print customer's information
    public void printInfo() {
        System.out.println("Customer Information:");
        System.out.println("- Code: " + this.getCode());
        System.out.println("- Full name: " + this.getFirstName() + " " + this.getLastName());
        System.out.println("- Email: " + this.getEmail());
        System.out.println("- Phone number: " + this.getPhone());
        System.out.println("- Date of birth: " + this.getFormattedDate(this.getBirthDate(), "yyyy/MM/dd"));
    }

    // Get formatted date
    public String getFormattedDate(LocalDate date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return date.format(formatter);
    }

    // Getters and setters
    // - Code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
