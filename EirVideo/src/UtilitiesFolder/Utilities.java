/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitiesFolder;

import Catalogs.FileIO.FileIO;
import Products.Product;
import Rents.BookingHistory;
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
    
 public void readBookHistory(){
       try (BufferedReader reader = new BufferedReader(new FileReader("History.csv"))) {
    String line;
    while ((line = reader.readLine()) != null) {
        String[] parts = line.split(", ");

        if (parts.length == 3) {
            int id = Integer.parseInt(parts[0].trim());
            String movieTitle = parts[1].trim();
            String customerName = parts[2].trim();

            // Process or store the read data as needed
            System.out.println("ID: " + id + ", Movie Title: " + movieTitle + ", Customer Name: " + customerName);
        } else {
            System.out.println("Invalid CSV format in line: " + line);
        }
    }
} catch (IOException e) {
    System.err.println("Error reading the file: " + e.getMessage());
}

        
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
