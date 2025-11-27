package osrm;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Antho
 */
public class Response {

    private List<Waypoint> sources;
    private List<Waypoint> destinations;
    private double[][] distances;
    private double[][] durations;
    private String code;

    public Response() {
    }

    public Response(List<Waypoint> sources, List<Waypoint> destinations, double[][] distances, double[][] durations, String code) {
        this.sources = sources;
        this.destinations = destinations;
        this.distances = distances;
        this.durations = durations;
        this.code = code;
    }

    public List<Waypoint> getSources() {
        return sources;
    }

    public void setSources(List<Waypoint> sources) {
        this.sources = sources;
    }

    public List<Waypoint> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Waypoint> destinations) {
        this.destinations = destinations;
    }

    public double[][] getDistances() {
        return distances;
    }

    public void setDistances(double[][] distances) {
        this.distances = distances;
    }

    public double[][] getDurations() {
        return durations;
    }

    public void setDurations(double[][] durations) {
        this.durations = durations;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
