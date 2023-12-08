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
    
    
         DataInput input = new FileInput(); 
         Catalog catalog = input.getData();
         DataOutput output = new FileOutput();
         output.saveData(catalog);
         
    }
            }
    
