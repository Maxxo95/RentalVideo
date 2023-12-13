/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.util.ArrayList;

/**
 *
 * @author djap
 */

public class UserLogIn {
    
    private ArrayList<Users> users;

    public UserLogIn(ArrayList<Users> users) {
        this.users = users;
    }

    public UserLogIn() {
        
    }

    

    public boolean UserLogIn(String Username, String Password) {
        for (Users user : users) {
            if (user.getUsername().equals(Username)
                    && user.getEncryptedPassword().equals(user.encryptPassword(Password))) {
                System.out.println("LOG IN SUCCESSFUL, WELCOME TO EIRVIDEO!");
                return true;
            }
        }
        System.out.println("USERNAME OR PASSWORD INCORRECT");
        return false;
    }

    public ArrayList<Users> getUsers() { 
        return users;
    }
    
}
