/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvideo.Products;

/**
 *
 * @author maxim
 */
  public abstract class Product {
      private  String name= "";  
    private Double price = 0.0 ;
    
    public  Product(String name, Double price){
      this.setName(name);
      this.setPrice(price);
  }
  
    public String getName(){
       return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
}

    