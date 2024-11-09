package security;

import java.util.ArrayList;
import java.util.Scanner;

import model.User;

public class RoleBasedAccessControl {
    private ArrayList<User> users = new ArrayList<>();
    
    public RoleBasedAccessControl() {
        // Sample users
        users.add(new User("admin", "admin123", "Admin"));
        users.add(new User("agent", "agent123", "Agent"));
        users.add(new User("client", "client123", "Client"));
    }
    

    public User login() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter Username: ");
        String username = scanner.nextLine();
        
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        
        System.out.println("Invalid credentials. Try again.");
        return null;
    }
}

