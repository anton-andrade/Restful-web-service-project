
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Antho
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Waypoint {
    private List<Double> location;
    private String name;
    
    public Waypoint() {
    }
    
    public List<Double> getLocation() {
     return location;   
    }
    
    public void setLocation(List<Double> location) {
        this.location = location;
    }
    
    public String getName() {
     return name;   
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
}
