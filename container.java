public class container {

    public String id;
    public String description;
    public int weight;

    public container(String id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }
    @Override
    public String toString() {
        return id + " | " + description + " | " + weight + "kg"; 
    }

}
