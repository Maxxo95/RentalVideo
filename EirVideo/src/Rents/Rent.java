package Rents;

import Catalogs.Catalog;
import Catalogs.DataIO.DataInput;
import Catalogs.DataIO.DataOutput;
import Catalogs.DataIO.DataUpdate;
import Catalogs.FileIO.FileInput;
import Catalogs.FileIO.UpdateFile;
import Products.Movie;
import Products.Product;
import Rents.PaymentMethods.CreditCardPay;

import Users.Users;
import Users.UsersManager;
import UtilitiesFolder.Utilities;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Rent {

    
    private int movieN ; //For choosing a product for the user
    
    private Users user = new Users("User", "Pass1234");
    private BookingHistory bookingHistory = new BookingHistory() ; // booking history  
    
    private Catalog movieCat = new Catalog();
    //private Catalog activeMov = new Catalog(); 
 private UsersManager usersMan = new UsersManager();
     private Booking currentBooking;
    
    CreditCardPay creditCardPayment = new CreditCardPay();
    
    private Movie pickedMovie ;  // start Booking
    private Movie movie ; //Movie startMovies
    private Product product ; //For booking
     DataInput datainput =new FileInput();
    DataUpdate output = new UpdateFile();
    Utilities utilities = new Utilities();
    public Rent() {
    this.setMovieCatalog(movieCat);
          
//   movieCat = movieCat.DatatoFileCatalog(movieCat);
    }
    
    public void setMovieCatalog(Catalog movieCat) {      
        movieCat = datainput.getData();
        this.movieCat = movieCat;        
    }
    
   
    public Catalog getMovieCatalog() {
        return movieCat;
    }
    public void setUser(){
      user =  usersMan.callMenu();
   //   System.out.println("test" + user.getUsername());
    }
    public void startMovies() {
        for (int i = 0; i < movieCat.getCatalog().size(); i++) {
            movie = movieCat.getProductAtIndex(i);
            System.out.println(i + 1 + ".- '" + movie.getName() + "' Price -" + movie.getPrice() + "€ Duration  " + movie.getRuntime()+ " minutes");
        }
    }
    
   public void rewrite(){
        output.reWriteCSV(movieCat);
       // utilities.
   }
    public void sartBookHistory(){
       
      bookingHistory =   datainput.getBookingsData(movieCat);
      
   }
    public void startBooking() { //(Customer customer, Product product)
        System.out.println(user.getUsername() +" Please enter the number of the Movie you want to rent");
        movieN = Utilities.getUserIntInput();
        pickedMovie = movieCat.getProductAtIndex(movieN - 1);
        System.out.println("You have picked -" + pickedMovie.getName() + " -Rate " + pickedMovie.getPrice() + " This movie has been rented "+pickedMovie.getTimesviewed() + " times" 
        + "\n Original Lengauage -" + pickedMovie.getLenguaje());

        currentBooking = new Booking(pickedMovie, user);
       

        System.out.println("\nChoose A payment Method");
    } 
    
    public void completeBooking() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Payment Menu"
                    + "\n Pick a choice");
            System.out.println("1. CreditCard");
            System.out.println("2. Show All Bookings History(Provitional just to show all bookings while coding)");
            System.out.println("3. Cancel Booking");
            System.out.print("Please input numbers only: \n");
         if(bookingHistory.getSize() < 1 ){
            sartBookHistory();    }
         else{}
            
            
            
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                     
                    currentBooking.setPaymentMethod(creditCardPayment);
                     creditCardPayment.completeCreditCard(currentBooking, creditCardPayment);
                   int j =  currentBooking.processPayment(currentBooking);
                     currentBooking.setID(j);
                     System.out.println(currentBooking.getID());
                     if(currentBooking.IsPayed() == false){
                    break;}
                     
                    else {
                       
                       //product.setTimesViewed((product.getTimesviewed())+1);
                       
                       product = currentBooking.getProduct(); 
                       output.updateData(movieCat,product);
                       product.setTimesViewed(product.getTimesviewed());
                       currentBooking.setStartTime(LocalDateTime.now());
                     currentBooking.setFinishTime(LocalDateTime.now().plusMinutes(1));
                       bookingHistory.addBooking(currentBooking);
                     utilities.UpdateBookHistoryCSV(bookingHistory);
                       System.out.println("Booking info \n" + currentBooking.getStartTime() + "\n"+currentBooking.getFinishTime());
                         return ;}
                     
              case "2":
                 for(int i =0 ;bookingHistory.getSize() > i; i++)  {       
                    Booking test = bookingHistory.getBookingAtIndex(i);
                    Product prod = test.getProduct() ;
                  System.out.println( prod.getName()  );
                 }
                  break;
                case "3":
                    System.out.println("Canceling the Payment");
                    return ;
                default:
                    System.out.println("Please only enter a number available in the options showed");
            }
    }
        
          
    }

  

    

}
