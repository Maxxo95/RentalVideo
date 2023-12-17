package Rents;

import Catalogs.Catalog;
import Catalogs.DataIO.DataInput;
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
import java.util.Scanner;

public class Rent {

    private int movieN; //For choosing a product for the user

    private Users user = new Users("", "");
    private BookingHistory bookingHistory = new BookingHistory(); // booking history  
    private Catalog movieCat = new Catalog();// Catalog of movies trough the class
    private UsersManager usersMan = new UsersManager();
    private Booking currentBooking; 
    private CreditCardPay creditCardPayment = new CreditCardPay();

    private Movie pickedMovie;  // start Booking
    private Movie movie; //Movie to loop trough startMovies()
    private Product product; //For booking loop 

    DataInput datainput = new FileInput();
    DataUpdate output = new UpdateFile();
    Utilities utilities = new Utilities();

    public Rent() {
        this.setMovieCatalog(movieCat);
    }
//this will call the CSV File inputFIle methods to read the file and setting in the program memory
    public void setMovieCatalog(Catalog movieCat) {
        movieCat = datainput.readMoviesData();
        this.movieCat = movieCat;
    }
     //When the program loop has to check if booking is empty so it dont rewrite the array
    public void setBookHistory(BookingHistory bookingHistory) {
        if (bookingHistory.getSize() < 1) { //if booking is not initialaized start it
            bookingHistory = datainput.readBookingsData();
        } else {
        }

    } // this might not be necesary 

   
// setter
    public void setUser() {
        user = usersMan.callMenu();
    }
// print method of movies Catalog
    public void startMovies() {
        for (int i = 0; i < movieCat.getCatalog().size(); i++) {
            movie = movieCat.getProductAtIndex(i);
            System.out.println(i + 1 + ".- '" + movie.getName() + "' Price -" + movie.getPrice() + "€ Duration  " + movie.getRuntime() + " minutes");
        }
    }

  
//this is for the Bookings saved in the memory accesing the time data of the bookings setted when a booking is completed
    public void activeBookings() {   //Booking History?
        for (int i = 0; bookingHistory.getSize() > i; i++) {
            Booking test = bookingHistory.getBookingAtIndex(i);
            Product prod = test.getProduct();
            Users userLoop = test.getUser();

            if (userLoop.getUsername().equals(user.getUsername()) && test.getFinishTime() != null && test.getFinishTime().isAfter(LocalDateTime.now())) {
// Same reasoning that show book history but adding the booking times to chek if is active 
// This is the only part of the code that wont be saved in the .csv or .txt file and stored after the program is closed
                System.out.println("-" + prod.getName() + " -Available until " + test.getFinishTime());
            }
        }
    }

    //////////////////////////////MAIN function over this classes START & COMPLETE
    public void startBooking() { //(Customer customer, Product product)
        System.out.println(user.getUsername() + " Please enter the number of the Movie you want to rent");
        movieN = Utilities.getUserIntInput();
        pickedMovie = movieCat.getProductAtIndex(movieN - 1);
        System.out.println("You have picked -" + pickedMovie.getName() + " -Rate " + pickedMovie.getPrice() + "€ This movie has been rented " + pickedMovie.getTimesviewed() + " times"
                + "\n Original Lengauage -" + pickedMovie.getLenguaje());

        currentBooking = new Booking(pickedMovie, user);
        /*  Users test = currentBooking.getUser();
        System.out.println(test.getUsername());*/

        System.out.println("\nChoose A payment Method");
    }
// Complete Booking Own Menu 
    public void completeBooking() {
        Scanner scanner = new Scanner(System.in);
        
      if (bookingHistory.getSize() < 1) { //if booking is not initialaized start it
            bookingHistory = datainput.readBookingsData();
        } else {
        }
        while (true) {
            System.out.println("\n Payment Menu"
                    + "\n Pick a choice");
            System.out.println("1. CreditCard");
            System.out.println("2. Show your BookingHistory");
            System.out.println("3. Cancel Booking");
            System.out.print("Please input numbers only: \n");
            setBookHistory(bookingHistory);  //else just continue the code normal

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":

                    currentBooking.setPaymentMethod(creditCardPayment); //setting the payment method to credit card
                    creditCardPayment.completeCreditCard(currentBooking, creditCardPayment); // complete Pay procces method
                    int j = currentBooking.processPayment(currentBooking); //retrives id and then set it to the currentBooking
                    currentBooking.setID(j);
                    
                    if (currentBooking.IsPayed() == false) { //if is false not payed go back
                        break;
                    } else { // else is payed so complete bookin proceadure

                        product = currentBooking.getProduct(); //retrive info of the booking to then print as wish
                        output.updateData(movieCat, product);
                        product.setTimesViewed(product.getTimesviewed());
                        currentBooking.setStartTime(LocalDateTime.now());
                        currentBooking.setFinishTime(LocalDateTime.now().plusMinutes(1));
                        bookingHistory.addBooking(currentBooking); //add the booking to the Booking history of the program
                        output.UpdateBookHistoryCSV(bookingHistory);  //update file  writting the new history when a new book is procces
                        System.out.println("Booking info \n -Procceced " + currentBooking.getStartTime() + "\n -Ends " + currentBooking.getFinishTime());
                        output.writeCSVMovies(movieCat);  // write the new file
                        return;
                    }

                case "2": //Check the csv of BookingHistory if the name matches the user it will show the bookings
    
                    System.out.println(user.getUsername());
                     System.out.println("BookingID Name Price");
                    for (int i = 0; bookingHistory.getSize() > i; i++) {
                        Booking test = bookingHistory.getBookingAtIndex(i);
                        Product prod = test.getProduct();
                        Users userLoop = test.getUser();
                       
                        if (userLoop.getUsername().equals(user.getUsername())) { // Use equals() for string comparison
                            System.out.println("  -" +test.getID()+"   -" + prod.getName() + " -" + prod.getPrice() + "€");
                        }
                    }
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
