/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;
import Products.ProductParser;

import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class CSVDataParser implements FileDataParser {
    
    @Override
    public Catalog parseData(ArrayList<Product> data) {
        
        ProductParser pp = new ProductParser();
        Catalog catalog =  pp.addProduct(data);
          return catalog;
    }

  
}