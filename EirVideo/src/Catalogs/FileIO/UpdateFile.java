/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Catalogs.DataIO.DataOutput;
import Catalogs.DataIO.DataUpdate;
import Products.Movie;
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
       //  asset.setTimesViewed(asset.getTimesviewed() + 1);
      asset.setTimesViewed(asset.getTimesviewed()+1);
        catalog.setCatalog(currentCatalog.getCatalog());
        
 return asset;
       
    }
     @Override
     public void reWriteCSV(Catalog catalogs){
            try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(filename + ".csv"));
                   
                    bw.write("Name," + "Price," + "TimesViewed," +"Lenguage,"+"DurationTime" );
                    bw.newLine();
                    for (Movie product : catalogs.getCatalog()) {
                        bw.write(product.getName() + "," + product.getPrice() + "," + product.getTimesviewed() + ","+ product.getLenguaje()+ ","  + product.getRuntime());
                        bw.newLine(); 
                    }

                    bw.close();

                } catch (IOException e) {
                    System.out.println(e);
                }    
     }
}