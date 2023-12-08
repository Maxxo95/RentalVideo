/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author djap
 */


import java.util.ArrayList;
import java.util.List;
public class UsersManager {
    
 
    private static List<Users> users = new ArrayList<>();

    // Method to add users
    public static void addUsers(Users user) {
        users.add(user);
    }

    // Method to validate the credential for log in 
    public static boolean validateCredentials(String Username, String Password) {
        for (Users user : users) {
            if (user.getUsername().equals(Username) && user.getPassword().equals(Password)) {
                return true; // Credentials correct
            }
        }
        return false; // Credentials incorrect 
    }
    
    
    
    
    
    
    
}
