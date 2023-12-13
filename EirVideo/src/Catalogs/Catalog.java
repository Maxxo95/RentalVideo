/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs;

import Products.Product;
import Catalogs.Catalog;
import Catalogs.DataIO.DataInput;
import Catalogs.DataIO.DataOutput;
import Catalogs.FileIO.FileInput;
import Catalogs.FileIO.FileOutput;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class Catalog implements DataToFileCatalog {

    private ArrayList<Product> library = new ArrayList<>();

    public Catalog() {
        this.library = new ArrayList<>();
    }

    public ArrayList<Product> getCatalog() {
        return library;
    }

    public void setCatalog(ArrayList<Product> library) {
        this.library = library;
    }

    public void addProduct(Product product) {
        library.add(product);
    }

    public void removeProduct(Product product) {
        library.remove(product);
    }

    public boolean isEmpty() {
        return this.library.isEmpty();
    }

    @Override
    public Catalog DatatoFileCatalog(Catalog movieCat) {
        //input
        DataInput input = new FileInput();
        //get
        movieCat = input.getData(); 
        
        //output
        DataOutput output = new FileOutput();
        output.saveData(movieCat);
        return movieCat;
    }

    public int size() {
        return library.size();

    }

    public Product getProductAtIndex(int index) {
        if (index >= 0 && index < library.size()) {
            return library.get(index);
        } else {
            // Handle the case where the index is out of bounds
            return null; // You can return null or throw an exception, depending on your requirements.
        }
    }
}
