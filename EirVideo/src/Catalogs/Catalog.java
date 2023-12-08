/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs;
import  Products.Product;
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
 public void setCatalog (ArrayList<Product> library){
    this.library = library;
}
 public void addProduct(Product product){
     library.add(product);
 }
  public void removeProduct(Product product) {
        library.remove(product);
    }

   

   public boolean isEmpty() {
    return this.library.isEmpty();
}
   
           @Override
         public void DatatoFileCatalog (Catalog movieCat){      
         DataInput input = new FileInput(); 
         movieCat = input.getData();
         DataOutput output = new FileOutput();
         output.saveData(movieCat);
} 

}


  
 
