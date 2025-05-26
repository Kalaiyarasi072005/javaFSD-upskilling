// QuantumHttpClient.java
import java.net.URI;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandlers;

public class QuantumHttpClient {
    public static void main(String[] args) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        
        // Fetch quantum computing Wikipedia page
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://en.wikipedia.org/wiki/Quantum_computing"))
                .header("Accept", "text/html")
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Headers: " + response.headers().map());
        
        // Print first 500 characters of the response
        String body = response.body();
        System.out.println("\nResponse preview:\n" + 
            body.substring(0, Math.min(500, body.length())) + "...");
        
        // Count occurrences of "quantum"
        long quantumCount = body.toLowerCase().chars()
                .filter(ch -> ch == 'q')
                .count();
        System.out.println("\n'q' characters found: " + quantumCount);
    }
}