import java.net.*;
import java.net.http.*;
import java.util.*;

public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        // Create a new HttpClient instance
        HttpClient client = HttpClient.newBuilder()
                .proxy(ProxySelector.of(new InetSocketAddress("proxy.example.com", 8080)))
                .build();

        // Create a new HttpRequest instance
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://www.example.com"))
                .build();

        // Send the request and get the response
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Print out the response code
        System.out.println("Response code: " + response.statusCode());
    }
}