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

/**
 *
 * @author maxim
 */
class Booking {
    private PaymentMethod paymentMethod;
   private Product product = new Movie("",0.0);
   private Users user = new Users ("", "");
    private Boolean isPayed = false;
       CreditCardPay creditCardPayment = new CreditCardPay();
    public Booking(Product product, Users customer) {
       this.setProduct(product);
       this.setUser(customer);
       this.setPayment(isPayed);
       this.setPaymentMethod(paymentMethod);
    }

    public void setProduct(Product product) {
       this.product = product;
    }
      public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void setUser(Users customer) {
       this.user = customer;
    }
    public void setPayment (Boolean isPayed){
        this.isPayed = isPayed;
    }
   public Boolean IsPayed (){
       return isPayed;
   } 
    
   public void processPayment() {
        if (paymentMethod != null) {
           paymentMethod.processPay();
        //   creditCardPayment.processPay();
        } else {
            System.out.println("No payment method set.");
        } 
    
}
    public void creditCard(){
      creditCardPayment.processPay();
    }
}