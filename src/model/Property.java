package model;

public class Property {
    private String id;
    private String title;
    private String location;
    private double price;
    private String status;  // Available, Under Contract, Sold

    public Property(String id, String title, String location, double price) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.price = price;
        this.status = "Available";  // Default status when created
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Property [ID=" + id + ", Title=" + title + ", Location=" + location + ", Price=" + price + ", Status=" + status + "]";
    }
}
