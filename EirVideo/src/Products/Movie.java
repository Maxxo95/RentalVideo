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
String lenguaje;
String runtime;
    public Movie(String name, Double price) {
        super(name, price);
        
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


