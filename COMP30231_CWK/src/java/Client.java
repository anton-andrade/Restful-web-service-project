
import osrm.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Antho
 */
public class Client {

    public static void main(String[] args) throws IOException, InterruptedException, URISyntaxException {

        // build URI 
        // changed to call local REST API 
        String baseUrl = "http://localhost:9090/COMP30231_CWK/webresources/osrm?coords=";
        String coordinates = "13.388860,52.517037;13.397634,52.529407";
        String url = baseUrl + coordinates;

        // create HTTP Client
        HttpClient client = HttpClient.newHttpClient();

        URI uri = new URI(url);

        // build request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        // send request and get response
        HttpResponse<String> response;
        response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {

            // confirming JSON response contains distances array
            System.out.println(response.body());

            // JSON parsing with jackson
            ObjectMapper mapper = new ObjectMapper();
            Response osrmResponse = mapper.readValue(response.body(), Response.class);
            System.out.println("Distance from first source to first destination: " + osrmResponse.getDistances()[0][1]);
        } else {
            System.out.println("Error" + response.statusCode());
        }
    }
}
