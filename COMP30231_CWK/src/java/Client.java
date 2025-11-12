
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;

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
        
        System.out.println(url);
    }
}
