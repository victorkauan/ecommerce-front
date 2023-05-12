package controllers;

import java.util.List;
import java.lang.reflect.Type;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Product;
import views.ProductView;

public class ProductController {
    // Attribute
    private final ProductView view;
    private final String baseUrl;

    // Constructor
    public ProductController(ProductView view, String baseUrl) {
        this.view = view;
        this.baseUrl = baseUrl;
    }

    // Method
    // Print customer list info
    public void printProducts() {
        List<Product> products = getProducts();

        if (products.size() == 0) {
            System.out.println("There are no products.");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            view.printInfo(products.get(i));
            if (i != products.size() - 1) {
                System.out.println();
            }
        }
    }

    // GET
    public List<Product> getProducts() {
        try {
            URL getProductsUrl = new URL(baseUrl + "/products");

            HttpURLConnection connection = (HttpURLConnection) getProductsUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            Gson gson = new Gson();
            Type productListType = new TypeToken<List<Product>>() {
            }.getType();
            return gson.fromJson(response.toString(), productListType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // POST
    public Product addProduct(Product product) {
        try {
            URL addProductUrl = new URL(baseUrl + "/products");

            HttpURLConnection connection = (HttpURLConnection) addProductUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(product);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), Product.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // PUT
    public Product updateProduct(Product product) {
        try {
            URL addProductUrl = new URL(baseUrl + "/products/" + product.getId());

            HttpURLConnection connection = (HttpURLConnection) addProductUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(product);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), Product.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // DELETE
    public void deleteProduct(int productId) {
        try {
            URL deleteProductUrl = new URL(baseUrl + "/products/" + productId);

            HttpURLConnection connection = (HttpURLConnection) deleteProductUrl.openConnection();
            connection.setRequestMethod("DELETE");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
