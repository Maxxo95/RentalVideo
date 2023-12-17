/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

/**
 *
 * @author maxim
 */
public class Movie extends Product {
String lenguaje = "";
String runtime ="";
String name;
Double price;
  private  boolean IsAvailable = true;
  /*  public Movie(String name, Double price) {
        super(name, price);
      
    }*/
     public Movie(String name, Double price) {
      super(name,price);
       this.setName(name);
      this.setPrice(price);
      this.setAvailability(IsAvailable);

      this.setlenguaje(lenguaje);
      this.setRuntime(runtime);
    }
    @Override
    public String getName(){
       return name;
    }
    @Override
    public void setName(String name){
        this.name = name;
    }
    @Override
    public Double getPrice(){
        return price;
    }
    @Override
    public void setPrice(Double price){
        this.price = price;
    }

   public String getLenguaje(){
        return lenguaje;
    }
    public void setlenguaje(String lenguaje){
        this.lenguaje = lenguaje;
    }
      public String getRuntime(){
        return runtime;
    }
    public void setRuntime(String runtime){
        this.runtime = runtime;
    }
   

   


   
    
   
   
}


