/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package Assignment_1;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginNGTest {

    @Test
    public void testCheckUsername() {
        Login login = new Login();
        assertTrue(login.checkUsername("a_bc"));        // Valid
        assertFalse(login.checkUsername("abc"));        // No underscore
        assertFalse(login.checkUsername("abcdef"));     // Too long
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("password"));   // Weak: no special char or uppercase
        assertTrue(login.checkPasswordComplexity("Pass@123"));    // Strong
    }

    @Test
    public void testCheckLocalPhoneNumber() {
        Login login = new Login();
        assertFalse(login.checkLocalPhoneNumber("+27733181212"));  // Not local format
        assertTrue(login.checkLocalPhoneNumber("0733181212"));     // Local
    }

    @Test
    public void testRegisterUser() {
       
    }

    @Test
    public void testLoginUser() {
        
    }

    @Test
    public void testReturnLoginStatus() {
        
    }
}
