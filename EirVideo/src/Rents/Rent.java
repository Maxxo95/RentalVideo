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

public class Rent {

    
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
        pickedMovie = movieCat.getProductAtIndex(movieN - 1);
        System.out.println("You have picked -" + pickedMovie.getName() + " -Rate " + pickedMovie.getPrice() + " This movie has been wathc "+pickedMovie.getTimesviewed() + " times");

        currentBooking = new Booking(pickedMovie, user);
       

        System.out.println("\nChoose A payment Method");
    }

    
    
    
    
    public void completeBooking() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Payment Menu"
                    + "\n Pick a choice");
            System.out.println("1. CreditCard");
            System.out.println("2. GooglePay");
            System.out.println("3. Cancel Booking");
            System.out.print("Please input numbers only: \n");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                     
                    currentBooking.setPaymentMethod(creditCardPayment);
                     creditCardPayment.completeCreditCard(currentBooking, creditCardPayment);
                     currentBooking.processPayment(currentBooking);
                     
                     if(currentBooking.IsPayed() == false){
                    break;}
                     
                    else {
                         Utilities.writteTrend(pickedMovie);
                         return;}
                     
                case "2":
                              
                  System.out.println("Under Construction" + currentBooking.IsPayed());
                    break;
                case "3":
                    System.out.println("Canceling the Payment");
                    return;
                default:
                    System.out.println("Please only enter a number available in the options showed");
            }
    }
        
          
    }
    
    

}
