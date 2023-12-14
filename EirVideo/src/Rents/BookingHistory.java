/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents;

import java.util.ArrayList;

/**
 *
 * @author maxim
 */

public class BookingHistory implements BookingHistoryImp {
  private Booking book;
  int ID;
  ArrayList<Booking> bookList = new ArrayList<>();
public BookingHistory(){
    this.bookList = new ArrayList<>();
}
 @Override
     public void addBooking(Booking booking) {
        bookList.add(booking);
    }

    @Override
    public ArrayList<Booking> getBookingHistory() {
        return  bookList;
    }
    
    public void setBookingHistory( ArrayList<Booking> bookList){
        this.bookList = bookList;
    }
 
    
   

}