/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvideo;

import  Products.Product;
import Catalogs.Catalog;
import Catalogs.DataIO.DataInput;
import Catalogs.DataIO.DataOutput;
import Catalogs.FileIO.FileInput;
import Catalogs.FileIO.FileOutput;
import Products.Movie;
import java.util.ArrayList;

public class EirVideo {

  
    public static void main(String[] args) {
        /*
         Product movie1 = new Movie("PulpFiction", 3.99);
         Product movie2 = new Movie("Napoleon", 7.99);
         
         Catalog catalog = new Catalog();
         catalog.addProduct(movie1);
         catalog.addProduct(movie2);
         
         
        ArrayList<Product> catalogList = catalog.getCatalog();
        
        for (int i = 0; i < catalogList.size(); i++) {
            Product product = catalogList.get(i);
            System.out.println("Product" + (i+1) + ": " + product.getName() + ", Price: " + product.getPrice());

        
        }
    */
         DataInput input = new FileInput(); 
         Catalog catalog = input.getData();
         DataOutput output = new FileOutput();
         output.saveData(catalog);
    }
            }
    
