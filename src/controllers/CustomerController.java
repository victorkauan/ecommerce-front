package controllers;

import java.util.List;
import java.lang.reflect.Type;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Customer;
import views.CustomerView;

public class CustomerController {
    // Attribute
    private final CustomerView view;
    private final String baseUrl;

    // Constructor
    public CustomerController(CustomerView view, String baseUrl) {
        this.view = view;
        this.baseUrl = baseUrl;
    }

    // Method
    // Print customers
    public void printCustomers() {
        List<Customer> customers = getCustomers();

        if (customers.size() == 0) {
            System.out.println("There are no customers.");
            return;
        }

        for (int i = 0; i < customers.size(); i++) {
            view.printInfo(customers.get(i));
            if (i < customers.size() - 1) {
                System.out.println();
            }
        }
    }

    // GET
    public List<Customer> getCustomers() {
        try {
            URL getCustomersUrl = new URL(baseUrl + "/customers");

            HttpURLConnection connection = (HttpURLConnection) getCustomersUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            Gson gson = new Gson();
            Type customerListType = new TypeToken<List<Customer>>() {
            }.getType();

            return gson.fromJson(response.toString(), customerListType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // POST
    public Customer addCustomer(Customer customer) {
        try {
            URL addCustomerUrl = new URL(baseUrl + "/customers");

            HttpURLConnection connection = (HttpURLConnection) addCustomerUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(customer);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // PUT
    public Customer updateCustomer(Customer customer) {
        try {
            URL addCustomerUrl = new URL(baseUrl + "/customers/" + customer.getId());

            HttpURLConnection connection = (HttpURLConnection) addCustomerUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(customer);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), Customer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // DELETE
    public void deleteCustomer(int customerId) {
        try {
            URL deleteCustomerUrl = new URL(baseUrl + "/customers/" + customerId);

            HttpURLConnection connection = (HttpURLConnection) deleteCustomerUrl.openConnection();
            connection.setRequestMethod("DELETE");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
