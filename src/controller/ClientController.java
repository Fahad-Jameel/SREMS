package controller;

import model.User;
import view.View;
import model.Property;
import model.Offer;

import java.util.ArrayList;
import java.util.List;

public class ClientController extends UserController {
    private List<Property> properties;
    private List<Offer> offers;

    public ClientController(User user, View view) {
        super(user, view);
        this.properties = new ArrayList<>();
        this.offers = new ArrayList<>();
        // Mock properties for browsing
        populateMockProperties();
    }

    @Override
    public void start() {
        super.start();
        view.displayMessage("Client Dashboard");
        boolean running = true;
        while (running) {
            view.displayMessage("1. Browse Properties");
            view.displayMessage("2. Schedule Property Viewing");
            view.displayMessage("3. Submit Offer");
            view.displayMessage("4. View Offers");
            view.displayMessage("5. Exit");
            String choice = view.getInput("Choose an action:");
            switch (choice) {
                case "1":
                    browseProperties();
                    break;
                case "2":
                    scheduleViewing();
                    break;
                case "3":
                    submitOffer();
                    break;
                case "4":
                    viewOffers();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    // Action 1: Browse Properties
    private void browseProperties() {
        view.displayMessage("Available Properties:");
        for (Property property : properties) {
            view.displayMessage(property.toString());
        }
    }

    // Action 2: Schedule Property Viewing
    private void scheduleViewing() {
        String propertyId = view.getInput("Enter the ID of the property to schedule a viewing:");
        for (Property property : properties) {
            if (property.getId().equals(propertyId)) {
                view.displayMessage("Viewing scheduled for property: " + property.getTitle());
                return;
            }
        }
        view.displayMessage("Property not found.");
    }

    // Action 3: Submit Offer
    private void submitOffer() {
        String propertyId = view.getInput("Enter the ID of the property to submit an offer:");
        for (Property property : properties) {
            if (property.getId().equals(propertyId)) {
                String offerAmount = view.getInput("Enter your offer amount:");
                Offer offer = new Offer(user, property, Double.parseDouble(offerAmount));
                offers.add(offer);
                view.displayMessage("Offer submitted for property: " + property.getTitle());
                return;
            }
        }
        view.displayMessage("Property not found.");
    }

    // Action 4: View Offers
    private void viewOffers() {
        if (offers.isEmpty()) {
            view.displayMessage("No offers submitted yet.");
        } else {
            view.displayMessage("Your submitted offers:");
            for (Offer offer : offers) {
                view.displayMessage(offer.toString());
            }
        }
    }

    // Mock method to populate properties
    private void populateMockProperties() {
        properties.add(new Property("1", "Luxury Villa", "New York", 500000));
        properties.add(new Property("2", "Beach House", "California", 750000));
        properties.add(new Property("3", "Penthouse", "Miami", 1200000));
    }
}
