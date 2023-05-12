package controllers;

import java.lang.reflect.Type;
import java.util.List;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.ProductCategory;
import views.ProductCategoryView;

public class ProductCategoryController {
    // Attribute
    private final ProductCategoryView view;
    private final String baseUrl;

    // Constructor
    public ProductCategoryController(ProductCategoryView view, String baseUrl) {
        this.view = view;
        this.baseUrl = baseUrl;
    }

    // Method
    // Print customer list info
    public void printProductCategories() {
        List<ProductCategory> categories = getProductCategories();

        if (categories.size() == 0) {
            System.out.println("There are no categories.");
            return;
        }

        for (int i = 0; i < categories.size(); i++) {
            view.printInfo(categories.get(i));
            if (i < categories.size() - 1) {
                System.out.println();
            }
        }
    }

    // GET
    public List<ProductCategory> getProductCategories() {
        try {
            URL getProductCategoriesUrl = new URL(baseUrl + "/product-categories");

            HttpURLConnection connection = (HttpURLConnection) getProductCategoriesUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            Gson gson = new Gson();
            Type productCategoryListType = new TypeToken<List<ProductCategory>>() {
            }.getType();
            return gson.fromJson(response.toString(), productCategoryListType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // POST
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        try {
            URL addProductCategoryUrl = new URL(baseUrl + "/product-categories");

            HttpURLConnection connection = (HttpURLConnection) addProductCategoryUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(productCategory);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), ProductCategory.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // PUT
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        try {
            URL addProductCategoryUrl = new URL(baseUrl + "/product-categories/" + productCategory.getId());

            HttpURLConnection connection = (HttpURLConnection) addProductCategoryUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(productCategory);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), ProductCategory.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // DELETE
    public void deleteProductCategory(int productCategoryId) {
        try {
            URL deleteProductCategoryUrl = new URL(baseUrl + "/product-categories/" + productCategoryId);

            HttpURLConnection connection = (HttpURLConnection) deleteProductCategoryUrl.openConnection();
            connection.setRequestMethod("DELETE");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
