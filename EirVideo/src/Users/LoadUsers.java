/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djap
 */
public class LoadUsers {
    private static final String Users_File = "users.txt";
 private static List<Users> users = new ArrayList<>();
    
    public static void LoadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(Users_File))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new Users(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            // El archivo no existe, no hacer nada.
        }
    }
     public static void LoadUsers() {
        LoadUsersFromFile();
    }
}

