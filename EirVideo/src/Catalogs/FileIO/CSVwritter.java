/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Movie;
import Products.Product;
import Rents.Booking;
import Rents.BookingHistory;
import Users.Users;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author maxim
 */
public class CSVwritter implements CSVUpdaterWritter  {

   
    @Override
public void writeCSVMovies(Catalog catalogs){  try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("Movies" + ".csv"));
                   
                    bw.write("Name," + "Price," + "TimesViewed," +"Lenguage,"+"DurationTime" );
                    bw.newLine();
                    for (Movie product : catalogs.getCatalog()) {
                        bw.write(product.getName() + "," + product.getPrice() + "," + product.getTimesviewed() + ","+ product.getLenguaje()+ ","  + product.getRuntime());
                        bw.newLine(); 
                    }

                    bw.close();

                } catch (IOException e) {
                    System.out.println(e);
                }    
     }    
   @Override
public void UpdateBookHistoryCSV(BookingHistory history){
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("History.csv"))) {
        for (Booking booking : history.getBookingHistory()) {
              Users customer = booking.getUser();
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
    
}

