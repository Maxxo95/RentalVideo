/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs;
import  Products.Product;
import Catalogs.Catalog;
import java.util.ArrayList;

       
/**
 *
 * @author maxim
 */
public class Catalog {
 private ArrayList<Product> library = new ArrayList<>();
 
 public Catalog() {
        this.library = new ArrayList<>();
    }
 
 public ArrayList<Product> getCatalog() {
    return library;
}
 public void setCatalog (ArrayList<Product> library){
    this.library = library;
}
 public void addProduct(Product product){
     library.add(product);
 }
  public void removeProduct(Product product) {
        library.remove(product);
    }

    public ArrayList<Product> getProducts() {
           return library;
    }
  
 
}
