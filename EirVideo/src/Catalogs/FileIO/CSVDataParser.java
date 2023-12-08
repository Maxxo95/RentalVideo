/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;
import Catalogs.Catalog;
import Products.ProductParser;


/**
 *
 * @author maxim
 */
public class CSVDataParser implements FileDataParser {
    
    @Override
    public Catalog parseData(Catalog data) {
       ProductParser pp = new ProductParser();
    
        Catalog catalog = new Catalog(); 
       
       catalog = pp.addProducts( data);

        return catalog;
    }

  
}
