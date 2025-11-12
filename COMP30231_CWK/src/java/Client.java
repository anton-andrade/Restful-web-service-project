
import java.io.IOException;
import java.lang.System.Logger.Level;
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
        String baseUrl = "http://router.project-osrm.org/route/v1/driving/";
        String coordinates = "13.388860,52.517037;13.397634,52.529407";
        String options = "?overview=false";
        String url = baseUrl + coordinates + options;
        
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
            System.out.println(response.body());
        } else {
            System.out.println("Error" + response.statusCode());
        }
    }
}
