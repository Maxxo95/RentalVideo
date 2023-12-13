/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rents.PaymentMethods;

import Rents.Booking;

/**
 *
 * @author maxim
 */
public interface PaymentMethod {
    
    void processPay(Booking book);
}
