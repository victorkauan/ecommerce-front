package controllers;


import java.util.List;
import java.lang.reflect.Type;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import models.Sale;
import views.CustomerView;
import views.ProductView;
import views.SaleView;

public class SaleController {
    // Attribute
    private final SaleView view;
    private final String baseUrl;

    // Constructor
    public SaleController(SaleView view, String baseUrl) {
        this.view = view;
        this.baseUrl = baseUrl;
    }

    // Method
    // Print customer list info
    public void printSales() {
        List<Sale> sales = getSales();

        if (sales.size() == 0) {
            System.out.println("There are no sales.");
            return;
        }

        for (int i = 0; i < sales.size(); i++) {
            view.printInfo(sales.get(i));
            if (i < sales.size() - 1) {
                System.out.println();
            }
        }
    }

    // GET
    public List<Sale> getSales() {
        try {
            URL getSalesUrl = new URL(baseUrl + "/sales");

            HttpURLConnection connection = (HttpURLConnection) getSalesUrl.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            Gson gson = new Gson();
            Type SaleListType = new TypeToken<List<Sale>>() {
            }.getType();
            return gson.fromJson(response.toString(), SaleListType);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // POST
    public Sale addSale(Sale sale) {
        try {
            URL addSaleUrl = new URL(baseUrl + "/sales");

            HttpURLConnection connection = (HttpURLConnection) addSaleUrl.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(sale);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), Sale.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // PUT
    public Sale updateSale(Sale sale) {
        try {
            URL addSaleUrl = new URL(baseUrl + "/sales/" + sale.getId());

            HttpURLConnection connection = (HttpURLConnection) addSaleUrl.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            Gson gson = new Gson();
            String json = gson.toJson(sale);

            connection.getOutputStream().write(json.getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            reader.lines().forEach(response::append);
            reader.close();

            return gson.fromJson(response.toString(), Sale.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // DELETE
    public void deleteSale(int saleId) {
        try {
            URL deleteSaleUrl = new URL(baseUrl + "/sales/" + saleId);

            HttpURLConnection connection = (HttpURLConnection) deleteSaleUrl.openConnection();
            connection.setRequestMethod("DELETE");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
