/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;



import Products.Product;
import java.util.ArrayList;

/**
 *
 * @author Lecturer
 */
public class CSVReaderDecorator extends FileIO implements CSVReaderCheker {
    private CSVReaderCheker component = new CSVReader();
    
    public void errorMessage() {
        System.out.println("The file: " + filename + " cannot be located.");
    }
    
    @Override
    public ArrayList<Product> readData() {
        ArrayList<Product> data = component.readData();
        if (data.isEmpty()) errorMessage();
        return data;
    }
}
