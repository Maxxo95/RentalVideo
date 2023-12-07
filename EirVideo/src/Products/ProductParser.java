/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import Catalogs.Catalog;
import java.util.ArrayList;

public class ProductParser {
  
      public Catalog addProduct(ArrayList<Product> data) {
        Catalog rentCatalog = new Catalog();
        for (Product product : data) {
            rentCatalog.addProduct(product);
        }
        return rentCatalog; 
   }

  
}
