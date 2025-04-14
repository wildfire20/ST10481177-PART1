package Assignment_1;

import javax.swing.JOptionPane;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // User registration
        String firstName = JOptionPane.showInputDialog(null, "Enter First Name");
        String lastname = JOptionPane.showInputDialog(null, "Enter Last Name");
        String username = JOptionPane.showInputDialog(null, "Enter Username");
        String password = JOptionPane.showInputDialog(null, "Enter Password");
        String phone = JOptionPane.showInputDialog(null, "Enter Phone Number (starting with South African country code)");

        Login login = new Login(); // Create and instantiate login object

        boolean validatePhone = login.checkLocalPhoneNumber(phone);
        boolean validateUsername = login.checkUsername(username);
        boolean validatePassword = login.checkPasswordComplexity(password);

        // Check and validate username
        if (validateUsername ==true) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, 
                "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Check and validate password
        if (validatePassword ==true) {
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, 
                "Password is not correctly formatted, please ensure it contains at least eight characters, a capital and small letter, a number and a special character", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Check and validate phone number
        if (validatePhone ==true) {
            JOptionPane.showMessageDialog(null, "Cellphone number successfully added");
        } else {
            JOptionPane.showMessageDialog(null, 
                "Cellphone number incorrectly formatted or does not contain country code", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Final registration check
        if (validateUsername ==true && validatePassword ==true && validatePhone ==true) {
            JOptionPane.showMessageDialog(null, "You have successfully registered");
              
            
            String loginUsername;
            String loginPassword;
            
            
            // Login process
            
            loginUsername = JOptionPane.showInputDialog(null, "Enter username:");
            loginPassword = JOptionPane.showInputDialog(null, "Enter password:");
            
            if (loginUsername.equals(username) && loginPassword.equals(password)) {
                JOptionPane.showMessageDialog(null, 
                    "Welcome " + firstName + " " + lastname + "! It is great to see you again.");
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Login failed, wrong username or password", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Failed to register");
        }
    }
    }

