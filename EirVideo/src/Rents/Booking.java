/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents;

import Products.Movie;
import Products.Product;
import Rents.PaymentMethods.CreditCardPay;
import Rents.PaymentMethods.PaymentMethod;
import Users.Users;
import UtilitiesFolder.Utilities;
import java.time.LocalDateTime;

/**
 *
 * @author maxim
 */
public class Booking {

    private PaymentMethod paymentMethod;
    private Product product = new Movie("", 0.0);
    private Users user = new Users("", "");
    private Boolean isPayed = false;
    private CreditCardPay creditCardPayment = new CreditCardPay(); //other payment can be started to process payment
private   int id;
  private LocalDateTime startTime;
    private LocalDateTime finishTime;
    public Booking(Product product, Users customer) {
        this.setProduct(product);
        this.setUser(customer);
        this.setPayment(isPayed);
        this.setPaymentMethod(paymentMethod);
        this.setID(id);
        this.setStartTime(startTime);
        this.setFinishTime(finishTime);
    }

    public void setID(int id){
      this.id = id;
      
    }
    public int getID(){
        return this.id;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Product getProduct(){
        return this.product;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setUser(Users customer) {
        this.user = customer;
    }
    public Users getUser(){
        return user;
    }

    public void setPayment(Boolean isPayed) {
        this.isPayed = isPayed;
    }

    public Boolean IsPayed() {
        return isPayed;
    }

    public int processPayment(Booking book) {
        if (paymentMethod != null) {
          id=  paymentMethod.processPay(book);
         return id;   
        } else {
            System.out.println("No payment method set.");
        }
        return -1;
    }
    public int IDcounter(){
            Utilities ut = new Utilities();
          return  ut.readAndUpdateBookID();
            
        }
          
      public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }
        
        
    

  
}
