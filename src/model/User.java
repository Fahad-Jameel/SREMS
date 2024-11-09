package model;

public class User {
    private String username;
    private String password;
    private String role;

    // Constructor with default password
    public User(String username, String role) {
        this.username = username;
        this.password = "defaultPassword";  // Set a default password
        this.role = role;
    }

    // Constructor with username, password, and role
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter methods
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Role-based access control
    public boolean isAdmin() {
        return role.equalsIgnoreCase("Admin");
    }

    public boolean isAgent() {
        return role.equalsIgnoreCase("Agent");
    }

    public boolean isClient() {
        return role.equalsIgnoreCase("Client");
    }

    // toString method for user details display
    @Override
    public String toString() {
        return "Username: " + username + ", Role: " + role;
    }
}
