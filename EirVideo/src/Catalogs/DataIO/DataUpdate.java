/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.DataIO;

import Catalogs.Catalog;
import Products.Product;

/**
 *
 * @author maxim
 */
public interface DataUpdate {
         public Product updateData(Catalog currentCatalog, Product product);

}
