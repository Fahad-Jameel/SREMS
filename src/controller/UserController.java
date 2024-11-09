package controller;

import model.User;
import view.View;

public class UserController {
    protected User user;
    protected View view;
    
    public UserController(User user, View view) {
        this.user = user;
        this.view = view;
    }
    
    public void start() {
        view.displayMessage("Welcome, " + user.getUsername() + "!");
    }
}
