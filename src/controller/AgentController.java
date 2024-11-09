package controller;

import model.User;
import model.Property;
import model.Offer;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class AgentController {
    private User user;
    private View view;
    private List<Property> properties;  // List of properties the agent is managing
    private List<Offer> offers;         // List of offers from clients

    public AgentController(User user, View view) {
        this.user = user;
        this.view = view;
        this.properties = new ArrayList<>();
        this.offers = new ArrayList<>();
    }

    public void start() {
        view.displayMessage("Welcome Agent: " + user.getUsername());
        boolean running = true;
        while (running) {
            view.displayMessage("1. List New Property");
            view.displayMessage("2. View Properties");
            view.displayMessage("3. Manage Property Viewings");
            view.displayMessage("4. Respond to Offers");
            view.displayMessage("5. Exit");
            String choice = view.getInput("Choose an action:");
            switch (choice) {
                case "1":
                    listNewProperty();
                    break;
                case "2":
                    viewProperties();
                    break;
                case "3":
                    manageViewings();
                    break;
                case "4":
                    respondToOffers();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    // Action 1: List New Property
    private void listNewProperty() {
        String id = view.getInput("Enter Property ID:");
        String title = view.getInput("Enter Property Title:");
        String location = view.getInput("Enter Property Location:");
        double price = Double.parseDouble(view.getInput("Enter Property Price:"));
        Property property = new Property(id, title, location, price);
        properties.add(property);
        view.displayMessage("New property listed: " + property.getTitle());
    }

    // Action 2: View Listed Properties
    private void viewProperties() {
        if (properties.isEmpty()) {
            view.displayMessage("No properties listed yet.");
        } else {
            view.displayMessage("Listed Properties:");
            for (Property property : properties) {
                view.displayMessage(property.toString());
            }
        }
    }

    // Action 3: Manage Property Viewings (Here, we'll mock the viewings)
    private void manageViewings() {
        String propertyId = view.getInput("Enter the ID of the property to manage viewings:");
        Property property = findPropertyById(propertyId);
        if (property != null) {
            String action = view.getInput("Enter 'approve' to approve viewing or 'decline' to decline:");
            if (action.equalsIgnoreCase("approve")) {
                view.displayMessage("Viewing approved for property: " + property.getTitle());
            } else if (action.equalsIgnoreCase("decline")) {
                view.displayMessage("Viewing declined for property: " + property.getTitle());
            } else {
                view.displayMessage("Invalid action.");
            }
        } else {
            view.displayMessage("Property not found.");
        }
    }

    // Action 4: Respond to Client Offers
    private void respondToOffers() {
        if (offers.isEmpty()) {
            view.displayMessage("No offers to respond to.");
        } else {
            for (Offer offer : offers) {
                view.displayMessage("Offer from " + offer.getClient().getUsername() +
                        " on property " + offer.getProperty().getTitle() +
                        " for amount: $" + offer.getAmount());
                String response = view.getInput("Enter 'accept', 'counter', or 'reject':");
                switch (response.toLowerCase()) {
                    case "accept":
                        view.displayMessage("Offer accepted.");
                        offers.remove(offer);
                        return;
                    case "counter":
                        String counterOffer = view.getInput("Enter counter offer amount:");
                        offer.setAmount(Double.parseDouble(counterOffer));
                        view.displayMessage("Counter offer sent.");
                        return;
                    case "reject":
                        view.displayMessage("Offer rejected.");
                        offers.remove(offer);
                        return;
                    default:
                        view.displayMessage("Invalid response.");
                }
            }
        }
    }

    // Helper method to find a property by its ID
    private Property findPropertyById(String propertyId) {
        for (Property property : properties) {
            if (property.getId().equals(propertyId)) {
                return property;
            }
        }
        return null;
    }

    // Mock method to simulate adding offers (this would typically come from clients)
    public void addOffer(Offer offer) {
        offers.add(offer);
        view.displayMessage("New offer received for property: " + offer.getProperty().getTitle());
    }
    
}
