/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import Catalogs.Catalog;

public class ProductParser {
  
     public Catalog addProducts(Catalog data) {
    Catalog rentCatalog = new Catalog();
    for (Product product : data.getCatalog()) {//for each product of the catalog data that call getCatalog products
        rentCatalog.addProduct(product); 
    }
    return rentCatalog;//this will pass the values to the catalog calling the function
}

 

  
}
