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
import java.util.Scanner;

/**
 *
 * @author djap
 */
public class SaveUsers {
        private static final String CSV_FILE_PATH = "data.csv"; 

    private static final String Users_File = "users.txt";
 private static ArrayList<Users> users = new ArrayList<>();
   private LoadUsers readCSVUsers;
  public  void register(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
         ArrayList<String[]> records = readCSVUsers.readCsvFile();
        
        for (String[] record : records) {
            if (record[0].equals(email)) {
                System.out.println("User with email '" + email + "' already exists. Please login or use a different email.");
                return;
            }
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        String age = scanner.nextLine();

        try (FileWriter writer = new FileWriter(CSV_FILE_PATH, true)) {
            writer.append(email).append(",").append(password).append(",").append(firstName).append(",").append(lastName).append(",").append(age).append("\n");
            System.out.println("Registration successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
