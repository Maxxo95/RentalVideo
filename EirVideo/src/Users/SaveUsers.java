/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author djap
 */
public class SaveUsers {
    private static final String Users_File = "users.txt";
 private static List<Users> users = new ArrayList<>();
 
 public static void SaveUsersInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Users_File))) {
            for (Users user : users ) {
                writer.write(user.getUsername() + "," + user.getEncryptedPassword());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
