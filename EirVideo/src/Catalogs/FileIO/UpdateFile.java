/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Catalogs.DataIO.DataOutput;
import Catalogs.DataIO.DataUpdate;
import Products.Product;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxim
 */
public class UpdateFile extends FileIO implements DataUpdate {

    int productLine;
     private ArrayList<Product> catalogUp = new ArrayList<>();
    int timesviewed;
    Catalog catalog = new Catalog();
    CSVWriteData write = new CSVUpdateData(); 
   
    @Override
     public Product updateData(Catalog currentCatalog, Product asset) {
      asset= write.writeData(catalog, asset);
         asset.setTimesViewed(asset.getTimesviewed() + 1);
         try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".csv"));
                    catalog.setCatalog(currentCatalog.getCatalog());
                    bw.write("Name," + "Price," + "TimesViewed");
                    bw.newLine();
                    for (Product product : catalog.getCatalog()) {
                        bw.write(product.getName() + "," + product.getPrice() + "," + product.getTimesviewed());
                        bw.newLine(); 
                    }

                    bw.close();

                } catch (IOException e) {
                    System.out.println(e);
                }    
       
        
 return asset;
       
    }
}