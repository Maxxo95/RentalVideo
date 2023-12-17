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

    public void setMovieCatalog(Catalog movieCat) {
        movieCat = datainput.readMoviesData();
        this.movieCat = movieCat;
    }
     
    public void setBookHistory(BookingHistory bookingHistory) {
        if (bookingHistory.getSize() < 1) { //if booking is not initialaized start it
            bookingHistory = datainput.readBookingsData();
        } else {
        }

    }

   

    public void setUser() {
        user = usersMan.callMenu();
        //   System.out.println("test" + user.getUsername());
    }

    public void startMovies() {
        for (int i = 0; i < movieCat.getCatalog().size(); i++) {
            movie = movieCat.getProductAtIndex(i);
            System.out.println(i + 1 + ".- '" + movie.getName() + "' Price -" + movie.getPrice() + "€ Duration  " + movie.getRuntime() + " minutes");
        }
    }

  

    
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
        System.out.println("You have picked -" + pickedMovie.getName() + " -Rate " + pickedMovie.getPrice() + " This movie has been rented " + pickedMovie.getTimesviewed() + " times"
                + "\n Original Lengauage -" + pickedMovie.getLenguaje());

        currentBooking = new Booking(pickedMovie, user);
        /*  Users test = currentBooking.getUser();
        System.out.println(test.getUsername());*/

        System.out.println("\nChoose A payment Method");
    }

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

                    currentBooking.setPaymentMethod(creditCardPayment);
                    creditCardPayment.completeCreditCard(currentBooking, creditCardPayment);
                    int j = currentBooking.processPayment(currentBooking);
                    currentBooking.setID(j);
                    System.out.println(currentBooking.getID());
                    if (currentBooking.IsPayed() == false) { //if is false not payed go back
                        break;
                    } else { // else is payed so complete bookin proceadure

                        product = currentBooking.getProduct();
                        output.updateData(movieCat, product);
                        product.setTimesViewed(product.getTimesviewed());
                        currentBooking.setStartTime(LocalDateTime.now());
                        currentBooking.setFinishTime(LocalDateTime.now().plusMinutes(1));
                        bookingHistory.addBooking(currentBooking);
                        output.UpdateBookHistoryCSV(bookingHistory);
                        System.out.println("Booking info \n" + currentBooking.getStartTime() + "\n" + currentBooking.getFinishTime());
                        output.writeCSVMovies(movieCat);
                        return;
                    }

                case "2":
                    System.out.println(user.getUsername());

                    for (int i = 0; bookingHistory.getSize() > i; i++) {
                        Booking test = bookingHistory.getBookingAtIndex(i);
                        Product prod = test.getProduct();
                        Users userLoop = test.getUser();
                        if (userLoop.getUsername().equals(user.getUsername())) { // Use equals() for string comparison
                            System.out.println("-" + prod.getName() + " -" + userLoop.getUsername());
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
