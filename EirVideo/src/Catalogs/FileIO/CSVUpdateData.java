/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;

/**
 *
 * @author maxim
 *//*
public class CSVUpdateData  implements CSVWriteData {
  Product product;
    @Override
    public Product writeData(Catalog currentCatalog, Product moviePicked) {
    for (int i = 0; i < currentCatalog.getCatalog().size(); i++) {
            product = currentCatalog.getProductAtIndex(i);
           // System.out.println(i + 1 + ".- " + product.getName() + " " + product.getPrice() + " Times Rented: " + product.getTimesviewed());
            if (moviePicked.getName() == product.getName()) {
                moviePicked.setTimesViewed(moviePicked.getTimesviewed() + 1);
             //   productLine = i + 1;
            }  
              
             
            }
return moviePicked;    }
    
}
