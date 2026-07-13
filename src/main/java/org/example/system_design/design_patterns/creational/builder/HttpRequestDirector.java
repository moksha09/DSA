package org.example.system_design.design_patterns.creational.builder;

public class HttpRequestDirector {

    public HttpRequest buildSimpleGet(String url){
        return new HttpRequest.Builder(url)
                .method("GET")
                .timeout(30000)
                .build();
    }

    public HttpRequest buildAuthenticationPost(String url, String token, String body){
        return new HttpRequest.Builder(url)
                .method("POST")
                .addHeader("Authorization", "Bearer - " + token)
                .addHeader("Content-Type", "application/json")
                .body(body)
                .timeout(50000)
                .build();
    }

    public HttpRequest buildInternalServiceCall(String url) {
        return new HttpRequest.Builder(url)
                .method("GET")
                .addHeader("X-Internal-Service", "true")
                .addHeader("X-Trace-Id", java.util.UUID.randomUUID().toString())
                .timeout(5000)
                .build();
    }

    // Usage -
    public class Main {
            public static void main(String[] args){
                HttpRequestDirector director = new HttpRequestDirector();

                HttpRequest get = director.buildSimpleGet("https://api.example.com/users");
                HttpRequest post = director.buildAuthenticationPost(
                        "https://api.example.com/orders", "token123", "{\"item\":\"book\"}");
                HttpRequest internal = director.buildInternalServiceCall(
                        "https://internal.service/health");
            }
    }
}
