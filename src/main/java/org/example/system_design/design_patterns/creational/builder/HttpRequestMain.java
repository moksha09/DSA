package org.example.system_design.design_patterns.creational.builder;

public class HttpRequestMain {

    public static void main(String[] args){
        // Simple get request with just url -
        HttpRequest request = new HttpRequest.Builder("https://api.example.com/users")
                .build();

        // POST with body and custom timeout -
        HttpRequest postRequest = new HttpRequest.Builder("https://api.example.com/users")
                .method("POST")
                .addHeader("Content-Type", "application/json")
                .body("{\"name\":\"Alice\",\"email\":\"alice@example.com\"}")
                .timeout(5000)
                .build();

        // Authenticated PUT with query parameters
        HttpRequest put = new HttpRequest.Builder("https://api.example.com/config")
                .method("PUT")
                .addHeader("Authorization", "Bearer token123")
                .addHeader("Content-Type", "application/json")
                .addQueryParam("env", "production")
                .addQueryParam("version", "2")
                .body("{\"feature_flag\":true}")
                .timeout(10000)
                .build();
    }
}
