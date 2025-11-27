package osrm;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author Antho
 */
@Path("osrm")
public class OsrmService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of OsrmService
     */
    public OsrmService() {
    }

    /**
     * Retrieves representation of an instance of osrm.OsrmService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("coords") String coords) {

        // input validation
        if (coords == null) {
            return "{\"error\":\"coords are empty\"}";
        }
        try {
            // build OSRM URL for Table API
            String baseUrl = "http://router.project-osrm.org/table/v1/driving/";
            String options = "?annotations=distance,duration";
            String url = baseUrl + coords + options;

            // create HTTP connection to the OSRM API
            URL osrmUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) osrmUrl.openConnection();
            conn.setRequestMethod("GET");

            int status = conn.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            // if OSRM returned HTTP 200 parse the response
            if (status == 200) {
                ObjectMapper mapper = new ObjectMapper();
                Response osrmResponse = mapper.readValue(content.toString(), Response.class);

                // return the parsed object as JSON
                return mapper.writeValueAsString(osrmResponse);
            } else {
                // OSRM API returned an error status code
                return String.format("{\"error\":\"OSRM API returned status %d\"}", status);
            }
        } catch (Exception e) {
            // Handle network, parsing, or other exceptions as a JSON error
            return String.format("{\"error\":\"Exception: %s\"}", e.toString());
        }
    }

    /**
     * PUT method for updating or creating an instance of OsrmService
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
