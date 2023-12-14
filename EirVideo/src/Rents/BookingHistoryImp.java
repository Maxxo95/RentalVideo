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
public interface BookingHistoryImp {
  
   void addBooking(Booking booking);
   ArrayList<Booking> getBookingHistory();
   
}
