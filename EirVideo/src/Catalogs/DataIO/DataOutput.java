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
public interface DataOutput {
     public void saveData(Catalog currentCatalog);
     public int updateData(Catalog currentCatalog, Product product);
}
