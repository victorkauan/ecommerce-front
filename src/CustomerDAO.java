import java.time.LocalDate;
import java.util.HashMap;

public class CustomerDAO {
    // Attribute
    private final HashMap<String, Customer> customers;

    // Constructor
    public CustomerDAO() {
        customers = new HashMap<>();
    }

    // CREATE
    public void add(String code, String firstName, String lastName, String email, String phone, LocalDate birthDate) throws Exception {
        if (customers.get(code) != null) {
            throw new Exception("A customer with code \"" + code + "\" already exists.");
        }

        Customer customer = CustomerFactory.createCustomer(code, firstName, lastName, email, phone, birthDate);
        customers.put(code, customer);

        System.out.println("A customer with code \"" + code + "\" has been created.");
    }

    // READ
    public Customer get(String code) {
        return customers.get(code);
    }

    // UPDATE
    public void update(String code, String firstName, String lastName, String email, String phone, LocalDate birthDate) throws Exception {
        if (customers.get(code) == null) {
            throw new Exception("A customer with code \"" + code + "\" does not exists.");
        }

        Customer customer = CustomerFactory.createCustomer(code, firstName, lastName, email, phone, birthDate);
        customers.put(code, customer);

        System.out.println("A customer with code \"" + code + "\" has been updated.");
    }

    // DELETE
    public void remove(String code) throws Exception {
        if (customers.get(code) == null) {
            throw new Exception("A customer with code \"" + code + "\" does not exists.");
        }

        customers.remove(code);

        System.out.println("A customer with code \"" + code + "\" has been removed.");
    }

    // Get list
    public HashMap<String, Customer> getCustomers() {
        return customers;
    }
}
