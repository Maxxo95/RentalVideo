/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;
import Catalogs.DataIO.DataInput;
import java.util.ArrayList;
import Catalogs.FileIO.CSVReaderCheker;
import Rents.Booking;
import Rents.BookingHistory;
import UtilitiesFolder.Utilities;
/**
 *
 * @author maxim
 */
public class FileInput extends FileIO implements DataInput {
    CSVReaderCheker reader = new CSVReaderDecorator();  //
   
    //BookingHistory book ;
    @Override
    public Catalog readMoviesData() {
        Catalog data = reader.readMoviesData(); //from csv movieReader 
      //  FileDataParser catalogParser = new CSVDataParser(); // interface and then parse data Catalog
       return data; // is a catalog passing its data
    }
    
    @Override 
    public BookingHistory readBookingsData(){
     
         BookingHistory data = reader.readBookingsData();
        
      return data;                  
    }
}