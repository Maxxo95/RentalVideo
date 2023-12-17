/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.DataIO;

import Catalogs.Catalog;
import Products.Product;
import Rents.BookingHistory;

/**
 *
 * @author maxim
 */
public interface DataUpdate {
         public Product updateData(Catalog currentCatalog, Product product);
         public void writeCSVMovies(Catalog catalogs);
          public void UpdateBookHistoryCSV(BookingHistory history);
}
