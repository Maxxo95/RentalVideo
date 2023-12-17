/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs;

import Products.Product;
import Catalogs.Catalog;
import Catalogs.DataIO.DataInput;

import Catalogs.FileIO.FileInput;

import Products.Movie;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class Catalog   {

    private ArrayList<Movie> catalog = new ArrayList<>();

    public Catalog() {
        this.getCatalog() ;
        this.setCatalog(catalog);
    }

    public ArrayList<Movie> getCatalog() {
        return catalog;
    }
    

    public void setCatalog(ArrayList<Movie> catalog) {
        this.catalog = catalog;
    }

    public void addProduct(Movie product) {
        catalog.add(product);
    }

    public void removeProduct(Movie product) {
        catalog.remove(product);
    }

    public boolean isEmpty() {
        return this.catalog.isEmpty();
    }

 

    public int size() {
        return catalog.size();

    }

    public Movie getProductAtIndex(int index) {
        if (index >= 0 && index < catalog.size()) {
            return catalog.get(index);
        } else {
            // Handle the case where the index is out of bounds
            return null; // You can return null or throw an exception, depending on your requirements.
        }
    }
}
