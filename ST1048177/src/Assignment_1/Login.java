package Assignment_1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_Lub
 */
public class Login {
    public Login() {
    }
    
    public boolean checkUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return true;
        }
        return false;
    }
    
    public boolean checkPasswordComplexity(String password) {
    if (password == null || password.length() < 8) {
        return false;
    }

    boolean hasCapital = false;
    boolean hasNumber = false;
    boolean hasSpecial = false;

    for (char c : password.toCharArray()) {
        if (Character.isUpperCase(c)) {
            hasCapital = true;
        } else if (Character.isDigit(c)) {
            hasNumber = true;
        } else if (!Character.isLetterOrDigit(c)) {
            hasSpecial = true;
        }
    }

    return hasCapital && hasNumber && hasSpecial;
}
    
    public boolean checkLocalPhoneNumber(String phone) {
        String saCode = "+27";
        String firstThreeChar = phone.substring(0, 3); //Get character from index 0 to 3 (inclusive)
        int fourthDigit = Character.getNumericValue(phone.charAt(3)); //Get and converts the fourth digit
        
        if (phone.length() <= 12 && firstThreeChar.equals(saCode) && fourthDigit >= 6 && fourthDigit <= 8) {
            return true;
        }
        return false;
    }
    
    public String registerUser(String username, String password, String phone) {
        boolean validatePhone = checkPhoneNumber (phone);
        boolean validateUsername = checkUserName (username);
        boolean validatePassword = checkPasswordComplexity(password);
        
        if (validatePhone == true && validateUsername == true && validatePassword == true) {
            return "User is successfully registered";
        }
        return "user registration failed!!!!";
    }
    
    public boolean loginUser(String username, String password) {
        boolean validateUsername = checkUsername(username);
        boolean validatePassword = checkPasswordComplexity(password);
        
        if (validateUsername == true && validatePassword == true) {
            return true;
        }
        return false;
    }
    
    public String returnLoginStatus(String username, String password) {
        boolean validUsername = checkUsername(username);
        boolean validPassword = checkPasswordComplexity(password);
        
        if (validUsername == true && validPassword == true) {
            return "A successful login";
        }
        return "A failed login";
    }

    private boolean checkPhoneNumber(String phone) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean checkUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}

