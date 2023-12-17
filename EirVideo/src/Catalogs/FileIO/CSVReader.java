/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Movie;
import Rents.Booking;
import Rents.BookingHistory;
import Users.Users;
import java.io.IOException;
import static java.lang.Double.parseDouble;

import java.util.Scanner;

public class CSVReader extends FileIO implements CSVReaderCheker {
    Catalog data = new Catalog();
  private BookingHistory bookHist = new BookingHistory();
    Booking book   ;
    @Override
    public Catalog readMoviesData() {
        try {
            Scanner sc = new Scanner(new java.io.FileReader(filename + ".csv"));

            // Skip the header row
            if (sc.hasNext()) {
                sc.nextLine();
            }

            while (sc.hasNext()) {
                String[] parts = sc.nextLine().split(",");

                if (parts.length == 5) {
                    
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int timesViewed = Integer.parseInt(parts[2].trim());
                    String lenguaje = parts[3].trim(); ;
                    String runtime = parts[4].trim(); ;
                    
                    Movie movie = new Movie(name, price);
                    movie.setName(name);
                    movie.setPrice(price);
                    movie.setTimesViewed(timesViewed);
                    movie.setlenguaje(lenguaje);
                    movie.setRuntime(runtime);
                    data.addProduct(movie);
                } else {
                    System.out.println("Invalid CSV format in line: " + String.join(", ", parts));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return data;
    }

    @Override
    public BookingHistory readBookingsData() {
try {
            Scanner sc = new Scanner(new java.io.FileReader("History" + ".csv"));

        
         
            while (sc.hasNext()) {
                String[] parts = sc.nextLine().split(",");

        if (parts.length == 4) {
            int id = Integer.parseInt(parts[0].trim());
            String movieTitle = parts[1].trim();
           Double price = parseDouble(parts[2].trim());
            String customerName = parts[3].trim();
            Movie porduct = new Movie("",0.0); 
          Users customer = new Users(customerName, "");
            porduct.setName(movieTitle);
           porduct.setPrice(price);
           
         book = new Booking(porduct, customer);
          book.setID(id);
       
            bookHist.addBooking(book);    }   else {
            System.out.println("Invalid CSV format in line: " );
            return null;
        }
    }
} catch (IOException e) {
    System.err.println("Error reading the file: " + e.getMessage());
    return null;
}
 return bookHist;
        
    }
}


