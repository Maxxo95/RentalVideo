/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;
import Rents.BookingHistory;
import java.util.ArrayList;

/**
 *
 * @author Lecturer
 */
public class CSVReaderDecorator extends FileIO implements CSVReaderCheker {

    private CSVReaderCheker csvMovie = new CSVReader(); // from here movie reader called from the other can be accesed 
    // as a show maybe with the decorator 
    private CSVReaderCheker csvBooking = new CSVReader(); // from here movie reader called from the other can be accesed 

    public void errorMessage() {
        System.out.println("The file: cannot be located.");
    }

    @Override
    public Catalog readMoviesData() {
        Catalog data = csvMovie.readMoviesData();
        if (data.isEmpty()) {
            errorMessage();
        }
        return data;
    }

    @Override
    public BookingHistory readBookingsData() {

        BookingHistory data = csvBooking.readBookingsData();
        if (data.getSize() < 0) {
            errorMessage();
        }
        return data;
    }
}
