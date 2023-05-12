package views;

import models.Customer;

public class CustomerView {
    // Print customer's information
    public void printInfo(Customer customer) {
        System.out.println("- ID: " + customer.getId());
        System.out.println("- Full name: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println("- Email: " + customer.getEmail());
        System.out.println("- Phone number: " + customer.getPhone());
        System.out.println("- Date of birth: " + customer.getBirthDate());
    }
}
