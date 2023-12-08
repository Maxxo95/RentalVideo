/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Movie;
import Products.Product;
import java.util.ArrayList;
import java.util.Scanner;


public class CSVMovieReader extends FileIO implements CSVReaderCheker {
    Catalog data = new Catalog();
    @Override
    public Catalog readData() {
        try {
            Scanner sc = new Scanner(new java.io.FileReader(filename+".csv"));
            while (sc.hasNext()) {
                  String[] parts = sc.nextLine().split(",");
           
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                  //  Product product = new Product(name, price){};
                   Movie product = new Movie(name, price) ; // THis will say wich kind of product in case of implementing shows or books games etc
                    data.addProduct(product);
                } else {
                    System.out.println("Invalid CSV format in line: " + parts);
                }            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
}
