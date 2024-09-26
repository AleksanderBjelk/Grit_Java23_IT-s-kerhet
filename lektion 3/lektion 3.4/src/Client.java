import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(()-> attackServer());
            executorService.shutdown();
        }
    }

    private static final int NUMBER_REQUEST = 10;
    private static final String URL = "http://localhost:8080/attack";

    private static void attackServer() {
        HttpClient httpClient = HttpClient.newHttpClient();
            for (int i = 0; i < NUMBER_REQUEST; i++) {
                try {
                    HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(URL)).GET().build();
                    HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

                    System.out.println("Response: " + httpResponse.statusCode() + httpResponse.body() + " " + i);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
