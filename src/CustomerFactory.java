import java.time.LocalDate;

public class CustomerFactory {
    // Method
    public static Customer createCustomer(String code, String firstName, String lastName, String email, String phone, LocalDate birthDate) {
        return new Customer(code, firstName, lastName, email, phone, birthDate);
    }
}
