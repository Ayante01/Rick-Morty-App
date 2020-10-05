package cr.ac.ucr.rickmorty.models;

public class Locations {

    private int id;
    private String name;
    private String type;
    private String dimension;

    public Locations() {
    }

    public Locations(int id, String name, String type, String dimension) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    @Override
    public String toString() {
        return "Locations{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                '}';
    }
}
