/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents.PaymentMethods;

/**
 *
 * @author maxim
 */
public class CreditCardPay implements PaymentMethod {
   private String cardNumber = "1234567891123456" ;
    private String expirationDate = "2145";
    private String cvv = "125";
    @Override
    public void processPay() {
        
    if (
     cardNumber.length() == 16 && cvv.length() == 3 && expirationDate.length() == 4) {
    System.out.println("Processing credit card payment...");
    System.out.println("Card Number: " + cardNumber);
    System.out.println("Expiration Date: " + expirationDate);
    System.out.println("CVV: " + cvv);
    System.out.println("Payment processed successfully!");
} else {
    System.out.println("Payment processed Unsuccessfully!");
}
    }}
