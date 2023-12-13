/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;



import Catalogs.Catalog;
import Products.Product;
import java.util.ArrayList;

/**
 *
 * @author Lecturer
 */
public class CSVReaderDecorator extends FileIO implements CSVReaderCheker {
    private CSVReaderCheker component = new CSVMovieReader(); // from here movie reader called from the other can be accesed 
    // as a show maybe with the decorator 
    
    public void errorMessage() {
        System.out.println("The file: " + filename + " cannot be located.");
    }
    
    @Override
    public Catalog readData() {
        Catalog data = component.readData();
        if (data.isEmpty()) errorMessage();
        return data;
    }
}
