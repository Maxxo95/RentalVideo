/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;
import java.util.ArrayList;
import java.util.Scanner;

/*
public class CSVReader extends FileIO implements CSVReaderCheker {
    ArrayList<Product> data = new ArrayList<>();
    
    @Override
    public ArrayList<Product> readData() {
        try {
            Scanner sc = new Scanner(new java.io.FileReader(filename+".csv"));
            while (sc.hasNext()) {
                  String[] parts = sc.nextLine().split(",");
           
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    
                    Product product = new Product(name, price) {};
                    data.add(product);
                } else {
                    System.out.println("Invalid CSV format in line: " + parts);
                }            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }
}
*/