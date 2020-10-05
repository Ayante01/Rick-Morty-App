package cr.ac.ucr.rickmorty.models;

public class Origin {

    private String name;
    private String url;

    public Origin() {
    }

    public Origin(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Origin{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
