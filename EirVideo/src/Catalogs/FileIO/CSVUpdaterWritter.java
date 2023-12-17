/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;
import Rents.BookingHistory;

/**
 *
 * @author maxim
 */
public interface CSVUpdaterWritter {
public void writeCSVMovies(Catalog catalogs);
 public void UpdateBookHistoryCSV(BookingHistory history);
}
