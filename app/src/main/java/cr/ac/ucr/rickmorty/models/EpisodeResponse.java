package cr.ac.ucr.rickmorty.models;

import java.util.ArrayList;

public class EpisodeResponse {

    ArrayList<Episode> results;

    public EpisodeResponse() {
    }

    public EpisodeResponse(ArrayList<Episode> results) {
        this.results = results;
    }

    public ArrayList<Episode> getResults() {
        return results;
    }

    public void setResults(ArrayList<Episode> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "EpisodeResponse{" +
                "results=" + results +
                '}';
    }
}