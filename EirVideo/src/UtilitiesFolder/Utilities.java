/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitiesFolder;

import Catalogs.FileIO.FileIO;
import Products.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Utilities extends BookID {
    private static Scanner scanner = new Scanner(System.in);

  
    BookID file = new BookID();
    
  public int readAndUpdateBookID() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file.getFilename() + ".txt"))) {
            String line = reader.readLine();
            if (line != null) {
                int currentID = Integer.parseInt(line);
                int updatedID = currentID + 1;

                // Write the updated value back to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getFilename() + ".txt"))) {
                    writer.write(String.valueOf(updatedID));
                } catch (IOException e) {
                    System.err.println("Error writing to the file: " + e.getMessage());
                }

                return updatedID;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading the file or parsing the number: " + e.getMessage());
        }

        return -1; // return -1 to indicate an error
    }
    
    
    
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
