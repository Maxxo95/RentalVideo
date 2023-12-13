/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitiesFolder;

import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Utilities {
    private static Scanner scanner = new Scanner(System.in);

    public static int getUserIntInput() {
        
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            
            scanner.next(); 
        }
        int userInput = scanner.nextInt();
        
        scanner.nextLine();
        return userInput;
    }

    public static String getUserStringInput() {
  while (!scanner.hasNextLine()) {
            System.out.println("Invalid input. Please enter a String.");
            
            scanner.next(); 
        }
        String userInput = scanner.nextLine();
        scanner.nextLine();
       
        return userInput;    }
}
