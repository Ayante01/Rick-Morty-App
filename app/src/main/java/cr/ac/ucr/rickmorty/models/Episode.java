package cr.ac.ucr.rickmorty.models;

public class Episode {

    private int id;
    private String name;
    private String AirDate;
    private String episode;

    public Episode() {
    }

    public Episode(int id, String name, String airDate, String episode) {
        this.id = id;
        this.name = name;
        AirDate = airDate;
        this.episode = episode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAirDate(String airDate) {
        AirDate = airDate;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAirDate() {
        return AirDate;
    }

    public String getEpisode() {
        return episode;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", AirDate='" + AirDate + '\'' +
                ", episode='" + episode + '\'' +
                '}';
    }
}
