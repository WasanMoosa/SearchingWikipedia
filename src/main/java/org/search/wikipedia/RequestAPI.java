package org.search.wikipedia;

import com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import com.google.gson.Gson;
import okhttp3.Response;

import java.io.IOException;

public class RequestAPI {
    String responseBody;
    public String search(String topic) {
        // Build the URL for the Wikipedia API
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://en.wikipedia.org/w/api.php").newBuilder();
        urlBuilder.addQueryParameter("action", "query");
        urlBuilder.addQueryParameter("format", "json");
        urlBuilder.addQueryParameter("list", "search");
        urlBuilder.addQueryParameter("srsearch", topic);

        // Create an HTTP client
        OkHttpClient client = new OkHttpClient();

        // Create a request
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .get()
                .build();

        Response response = null;
        try {
            // Get response of API
            response = client.newCall(request).execute();
            responseBody = response.body().string();
        } catch (IOException e) {
            System.out.println("No connection!");
        }


    return responseBody;}

}
