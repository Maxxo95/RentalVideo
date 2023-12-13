/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import static Users.SaveUsers.SaveUsersInFile;
import static Users.LoadUsers.LoadUsersFromFile;
import  Users.Users;
import java.util.ArrayList;

/**
 *
 * @author djap
 */
public class AddUser {
    public ArrayList<Users> users;

    public AddUser() {
        this.users = new ArrayList<>();
        LoadUsersFromFile();
    }

    public void RegisterUser(String Username, String Password) {
            Users newUser = new Users(Username, Password);
            users.add(newUser);
            SaveUsersInFile();
            System.out.println("REGISTER SUCCESFUL!");
        
    }

    public ArrayList<Users> getUsers() {
        return users;
    }

    
}
