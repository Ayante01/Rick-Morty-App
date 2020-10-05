package cr.ac.ucr.rickmorty.models;

import java.util.ArrayList;

public class LocationsResponse {

    ArrayList<Locations> results;

    public LocationsResponse() {
    }

    public LocationsResponse(ArrayList<Locations> results) {
        this.results = results;
    }

    public void setResults(ArrayList<Locations> results) {
        this.results = results;
    }

    public ArrayList<Locations> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "LocationsResponse{" +
                "results=" + results +
                '}';
    }
}
