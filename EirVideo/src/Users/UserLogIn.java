/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author djap
 */

public class UserLogIn {
    
        ArrayList<String[]> data = new ArrayList<>();
    private LoadUsers readCSVUsers;
 

   
    public boolean UserLogIn(Scanner scanner) {
         System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        data = readCSVUsers.readCsvFile();
        boolean isAuthenticated = false;

        for (String[] record : data) {
            if (record[0].equals(email) && record[1].equals(password)) {
                isAuthenticated = true;
                System.out.println("Login successful!");
                System.out.println("Welcome, " + record[2] + " " + record[3] + "!");
                break;
    }
     }
  return isAuthenticated;
    }
    

    
}
