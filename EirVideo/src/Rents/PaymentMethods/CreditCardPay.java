/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents.PaymentMethods;

import Products.Movie;
import Products.Product;
import Rents.Booking;
import UtilitiesFolder.Utilities;

/**
 *
 * @author maxim
 */
public class CreditCardPay implements PaymentMethod {
   private String cardNumber ="";
    private String expirationDate="" ;
    private String cvv="";
 private Product product ; 
 private int idCount;
    //CreditCardPay creditCardPayment = new CreditCardPay();
    public String getCardNumber(){
        return cardNumber;
    }
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
     public String getExpirationDate(){
        return expirationDate;
    }
    public void setExpirationDate(String expirationDate){
        this.expirationDate = expirationDate;
    }
     public String getCVV(){
        return cvv;
    }
    public void setCVV(String cvv){
        this.cvv = cvv;
    }
    
    
    @Override
    public int processPay(Booking book) {
       
    if (
     cardNumber.length() == 16 && cvv.length() == 3 && expirationDate.length() == 4) {
    System.out.println("Processing credit card payment...");
    System.out.println("Card Number: " + cardNumber);
    System.out.println("Expiration Date: " + expirationDate);
    System.out.println("CVV: " + cvv);
    System.out.println("Payment processed successfully!");
    book.setPayment(Boolean.TRUE);
    idCount =book.IDcounter();
    
   System.out.println( "Total of Bookings " + idCount);
   product =book.getProduct();
   
   System.out.println(product.getName()+" "+ product.getPrice() + " This product has been rented "+ (product.getTimesviewed()+1)+ " times");
   return idCount;
    } else {
    System.out.println("Payment processed Unsuccessfully!");
  //   System.out.print("Total of Bookings " +  book.IDcounter());
}
   return -1; }

    public void completeCreditCard(Booking currentBooking, CreditCardPay creditCardPayment) {

        //isPayed = true;
        System.out.println("Please type the 16 digits of your Credit/Debit card \n Then press Enter");
        String number = Utilities.getUserStringInput();
        creditCardPayment.setCardNumber(number);
        System.out.println(creditCardPayment.getCardNumber() + " " + number.length());

        System.out.println("Please type the exp date MMYY card for example 1023 , Means october of the 23  \n Then press Enter");
        String expirationDate = Utilities.getUserStringInput();
        creditCardPayment.setExpirationDate(expirationDate);
        System.out.println(creditCardPayment.getExpirationDate() + " " + expirationDate.length());

        System.out.println("Please insert the 3 digits of the security code \n Then press Enter");
        String cvv = Utilities.getUserStringInput();
        creditCardPayment.setCVV(cvv);
        System.out.println(creditCardPayment.getCVV() + " " + cvv.length());
       
        
     //  System.out.println("Booking is payed? " +currentBooking.IsPayed());
    }  
}
