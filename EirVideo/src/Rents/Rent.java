
package Rents;

import Catalogs.Catalog;
import Products.Movie;
import Products.Product;
import java.util.ArrayList;



public class Rent {
//  private Product choosenM = new Movie();
   private   Catalog movieCat = new Catalog();
    private Catalog activeMov = new Catalog();
    private ArrayList<Booking> bookings; // booking history  
    private Booking currentBooking;
    
    private Product movie1 = new Movie("",0.0); //Movie test
    
       public Rent() {
        this.movieCat = movieCat;      
        this.activeMov = activeMov;  
        this.bookings = new ArrayList<>();  
        
    }
       
  public void startMovies(){
   movieCat = movieCat.DatatoFileCatalog(movieCat);
   
   
   
    movie1 = movieCat.getProductAtIndex(0);
    System.out.println(movie1.getName() +  (" ") +movie1.getPrice()  +  (" ") + movie1.getAvailability() + movie1.getClass());
}
         
         
         
  public void startBooking( Product product) { //(Customer customer, Product product)
        currentBooking = new Booking(product);
    }

 
 
}
