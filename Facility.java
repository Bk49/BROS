public class Facility {
    private String id;
    private String description;
    private int capacity;
    private int price;
    
    public Facility(String id, String description, int capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.price = 2;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
