/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents;

import Products.Movie;
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
    public String getStringHistory(){
        return  bookList.toString();
    }
    public int getSize(){
        return bookList.size();
    }
    public void setBookingHistory( ArrayList<Booking> bookList){
        this.bookList = bookList;
    }
   public Booking getBookingAtIndex(int index) {
        if (index >= 0 && index < bookList.size()) {
            return bookList.get(index);
        } else {
            // Handle the case where the index is out of bounds
            return null; // You can return null or throw an exception, depending on your requirements.
        }
    }
    
   

}