package view;

import java.util.Scanner;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    // Display a message to the user
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // Get input from the user
    public String getInput(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
}
