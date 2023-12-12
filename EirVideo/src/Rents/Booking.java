/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents;

import Products.Movie;
import Products.Product;
import Users.Users;

/**
 *
 * @author maxim
 */
class Booking {
   private Product product = new Movie("",0.0);
   private Users user = new Users ("", "");
    private Boolean isPayed = false;
    
    public Booking(Product product, Users customer) {
       this.setProduct(product);
       this.setUser(customer);
       this.setPayment(isPayed);
    }

    public void setProduct(Product product) {
       this.product = product;
    }

    public void setUser(Users customer) {
       this.user = customer;
    }
    public void setPayment (Boolean isPayed){
        this.isPayed = isPayed;
    }
   public Boolean getIsPayed (){
       return isPayed;
   } 
    
    
    
}
