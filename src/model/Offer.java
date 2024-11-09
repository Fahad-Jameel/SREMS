package model;

public class Offer {
    private User client;       // Client making the offer
    private Property property; // Property the offer is for
    private double amount;     // Offer amount

    public Offer(User client, Property property, double amount) {
        this.client = client;
        this.property = property;
        this.amount = amount;
    }

    // Getters and Setters
    public User getClient() {
        return client;
    }

    public Property getProperty() {
        return property;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Offer [Client=" + client.getUsername() + ", Property=" + property.getTitle() + ", Amount=" + amount + "]";
    }
}
