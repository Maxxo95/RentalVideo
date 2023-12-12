package Rents;

import Catalogs.Catalog;
import Products.Movie;
import Products.Product;
import Rents.PaymentMethods.CreditCardPay;
import Rents.PaymentMethods.PaymentMethod;
import Users.Users;
import UtilitiesFolder.Utilities;
import java.util.ArrayList;
import java.util.Scanner;

public class Rent  {
    private Boolean isPayed;
    private int movieN = 0;
    private Users user = new Users("User", "Pass1234");

    private Catalog movieCat = new Catalog();
    private Catalog activeMov = new Catalog();

    private ArrayList<Booking> bookings; // booking history  
    private Booking currentBooking;
    CreditCardPay creditCardPayment = new CreditCardPay();
    private Product pickedMovie = new Movie("", 0.0);
    private Product movie = new Movie("", 0.0); //Movie test

    public Rent() {
        this.setMovieCatalog(movieCat);
        movieCat = movieCat.DatatoFileCatalog(movieCat);
    }

    public void setMovieCatalog(Catalog movieCat) {
        this.movieCat = movieCat;
    }

    public Catalog getMovieCatalog() {
        return movieCat;
    }

    public void startMovies() {
        for (int i = 0; i < movieCat.getCatalog().size(); i++) {
            movie = movieCat.getProductAtIndex(i);
            System.out.println(i + 1 + ".- " + movie.getName() + " " + movie.getPrice() + " Is available: " + movie.getAvailability());
        }
    }

    public void startBooking() { //(Customer customer, Product product)
        System.out.println("Please enter the number of the Movie you want to rent");
        movieN = Utilities.getUserIntInput();
        pickedMovie =   movieCat.getProductAtIndex(movieN-1);
        System.out.println("You have picked " + pickedMovie.getName() + " rate " + pickedMovie.getPrice());
        
        currentBooking = new Booking(pickedMovie, user);
         isPayed = currentBooking.IsPayed();
         
         System.out.println("Booking is payed? " + isPayed);
    }
    
    
    public void completeCreditCard(){
      
        //isPayed = true;
        currentBooking.setPaymentMethod(creditCardPayment);
        currentBooking.processPayment();
    }
    
    
}
