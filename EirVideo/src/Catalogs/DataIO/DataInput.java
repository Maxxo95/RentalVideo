/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.DataIO;
import Catalogs.Catalog;
import Rents.Booking;
import Rents.BookingHistory;



/**
 *
 * @author maxim
 */
public interface DataInput {
    Catalog getData();
    void getBookData(Catalog movCat);
}

