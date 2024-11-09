package controller;

import model.User;
import model.Property;
import view.View;

import java.util.ArrayList;
import java.util.List;

public class AdminController extends UserController {
    private List<User> users;           // List to manage all users
    private List<Property> properties;  // List to store all properties

    public AdminController(User user, View view) {
        super(user, view);
        this.users = new ArrayList<>();
        this.properties = new ArrayList<>();
    }

    @Override
    public void start() {
        super.start();
        view.displayMessage("Admin Dashboard");
        boolean running = true;
        while (running) {
            view.displayMessage("1. Manage Users");
            view.displayMessage("2. View All Properties");
            view.displayMessage("3. Exit");
            String choice = view.getInput("Choose an action:");
            switch (choice) {
                case "1":
                    manageUsers();
                    break;
                case "2":
                    viewAllProperties();
                    break;
                case "3":
                    running = false;
                    break;
                default:
                    view.displayMessage("Invalid choice. Please try again.");
            }
        }
    }

    // Method to manage users (add, remove, and view users)
    private void manageUsers() {
        boolean managingUsers = true;
        while (managingUsers) {
            view.displayMessage("1. Add User");
            view.displayMessage("2. Remove User");
            view.displayMessage("3. View Users");
            view.displayMessage("4. Back");
            String choice = view.getInput("Choose an option:");
            switch (choice) {
                case "1":
                    addUser();
                    break;
                case "2":
                    removeUser();
                    break;
                case "3":
                    viewUsers();
                    break;
                case "4":
                    managingUsers = false;
                    break;
                default:
                    view.displayMessage("Invalid option. Please try again.");
            }
        }
    }

    // Add a new user
    private void addUser() {
        String username = view.getInput("Enter username:");
        String role = view.getInput("Enter role (Admin, Agent, Client):");

        // Validate role input
        if (!role.equalsIgnoreCase("Admin") && !role.equalsIgnoreCase("Agent") && !role.equalsIgnoreCase("Client")) {
            view.displayMessage("Invalid role. User not added.");
            return;
        }

        User newUser = new User(username, role);
        users.add(newUser);
        view.displayMessage("User added: " + newUser);
    }

    // Remove an existing user
    private void removeUser() {
        String username = view.getInput("Enter the username of the user to remove:");
        User userToRemove = findUserByUsername(username);
        if (userToRemove != null) {
            users.remove(userToRemove);
            view.displayMessage("User removed: " + userToRemove);
        } else {
            view.displayMessage("User not found.");
        }
    }

    // View all users
    private void viewUsers() {
        if (users.isEmpty()) {
            view.displayMessage("No users found.");
        } else {
            view.displayMessage("Users:");
            for (User user : users) {
                view.displayMessage(user.toString());
            }
        }
    }

    // Helper method to find a user by username
    private User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }

    // Method to view all properties in the system
    private void viewAllProperties() {
        if (properties.isEmpty()) {
            view.displayMessage("No properties found.");
        } else {
            view.displayMessage("Properties:");
            for (Property property : properties) {
                view.displayMessage(property.toString());
            }
        }
    }

    // Method to allow agents to add properties (in real system, this would be from AgentController)
    public void addProperty(Property property) {
        properties.add(property);
        view.displayMessage("Property added: " + property.getTitle());
    }
}
