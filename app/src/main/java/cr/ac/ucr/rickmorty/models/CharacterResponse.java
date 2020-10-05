package cr.ac.ucr.rickmorty.models;

import java.util.ArrayList;

public class CharacterResponse {

    ArrayList<Character> results;

    public CharacterResponse() {
    }

    public CharacterResponse(ArrayList<Character> results) {
        this.results = results;
    }

    public ArrayList<Character> getResults() {
        return results;
    }

    public void setResults(ArrayList<Character> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CharacterResponse{" +
                "results=" + results +
                '}';
    }
}
