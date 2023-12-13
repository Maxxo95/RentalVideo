/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Catalogs.DataIO.DataOutput;
import Products.Product;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author maxim
 */
public class UpdateTimesViewed extends FileIO implements DataOutput {

    int productLine;
    Product product;
    int timesviewed;
    Catalog catalog = new Catalog();

    @Override
    public void saveData(Catalog currentCatalog) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public int updateData(Catalog currentCatalog, Product moviePicked) {
        for (int i = 0; i < currentCatalog.getCatalog().size(); i++) {
            product = currentCatalog.getProductAtIndex(i);
           // System.out.println(i + 1 + ".- " + product.getName() + " " + product.getPrice() + " Times Rented: " + product.getTimesviewed());
            if (moviePicked.getName() == product.getName()) {
                moviePicked.setTimesViewed(moviePicked.getTimesviewed() + 1);
                productLine = i + 1;
            }  
                
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
            }
            return moviePicked.getTimesviewed();
        

       
    }
}
