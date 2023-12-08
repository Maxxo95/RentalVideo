
package Rents;

import Catalogs.Catalog;
import Catalogs.DataIO.DataInput;
import Catalogs.DataIO.DataOutput;
import Catalogs.DataToFileCatalog;
import Catalogs.FileIO.FileInput;
import Catalogs.FileIO.FileOutput;
import Products.Movie;
import Products.Product;
import java.util.ArrayList;



public class Rent {
//  private Product choosenM = new Movie();
   private   Catalog movieCat = new Catalog();
    private Catalog activeMov = new Catalog();
    private ArrayList<Booking> bookings; // booking history  
    private Booking currentBooking;
    
       public Rent() {
        this.movieCat = movieCat;      
        this.activeMov = activeMov;  
        this.bookings = new ArrayList<>();  
        
    }
       
  public void startMovies(){
    movieCat.DatatoFileCatalog(movieCat);
}
         
         
         
  public void startBooking( Product product) { //(Customer customer, Product product)
        currentBooking = new Booking(product);
    }

 
 
}
