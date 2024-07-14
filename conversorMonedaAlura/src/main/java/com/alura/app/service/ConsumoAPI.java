package com.alura.app.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.*;

public class ConsumoAPI {
    private static final String API_KEY = "8a5ada7138530cc0d71b9d1f";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + baseCurrency + "/" + targetCurrency;

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);
            return jsonResponse.get("conversion_rate").getAsDouble();

        } catch (Exception e) {
            System.err.println("error: " + e.getMessage());
            throw new RuntimeException("Error: ");
        }
    }
}
