/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilitiesFolder;

import Catalogs.Catalog;
import Catalogs.FileIO.FileIO;
import Products.Movie;
import Products.Product;
import Rents.Booking;
import Rents.BookingHistory;
import Users.Users;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Utilities extends BookID {
     private Users customer = new Users("User", "Pass1234");
    private static Scanner scanner = new Scanner(System.in);
 private BookingHistory bookings = new BookingHistory();
  Booking book   ;
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
    //BookingHistory
 public BookingHistory readBookHistory(Catalog movCat){
        try {
            Scanner sc = new Scanner(new java.io.FileReader("History" + ".csv"));

            // Skip the header row
           if (sc.hasNext()) {
                sc.nextLine();
            }
         
            while (sc.hasNext()) {
                String[] parts = sc.nextLine().split(",");

        if (parts.length == 4) {
            int id = Integer.parseInt(parts[0].trim());
            String movieTitle = parts[1].trim();
           Double price = parseDouble(parts[2].trim());
            String customerName = parts[3].trim();
            Movie porduct = new Movie("",0.0); 
   
            porduct.setName(movieTitle);
           porduct.setPrice(price);
           customer.setUsername(customerName);
         book = new Booking(porduct, customer);
          book.setID(id);
          ///////// This works but need to make it simpler as  it cubic and the
          /////// run time its just to much 
         /*
          for (int i = 0; i < movCat.size(); i++) {
             porduct =movCat.getProductAtIndex(i);
             if(porduct.getName()==movieTitle){
                 book.setProduct(porduct);
                    book.setID(id);
             book.setUser(customer);
             }}*/
            bookings.addBooking(book);
           //  System.out.println(bookings.getBookingHistory()+ "\nID: " + id + ", Movie Title: " + movieTitle + ", Customer Name: " + customerName);
        
        } else {
            System.out.println("Invalid CSV format in line: " );
            return null;
        }
    }
} catch (IOException e) {
    System.err.println("Error reading the file: " + e.getMessage());
    return null;
}
 return bookings;
        
    }
 
 public void readUpdateBookHistory(BookingHistory history){
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.csv"))) {
        for (Booking booking : history.getBookingHistory()) {
            Product product = booking.getProduct();
            Users user = customer; // Assuming 'customer' is properly initialized

            // Format the information as CSV
            String line = String.format("%d, %s, %.2f, %s",
                    booking.getID(), product.getName(), product.getPrice(),
                    user.getUsername());

            // Write the formatted line to the file
            writer.write(line);
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error writing to the file: " + e.getMessage());
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
