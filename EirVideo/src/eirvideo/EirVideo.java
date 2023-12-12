/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvideo;



import Rents.Rent;
import java.util.Scanner;


public class EirVideo {

  
    public static void main(String[] args) {
    
    
   
       Rent rent = new Rent();
       
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Main Menuu"
                    + "\n Pick a choice");
            System.out.println("1. Movies");
            System.out.println("2. Book a Product");
            System.out.println("3. Salir");
            System.out.print("Please input numbers only: \n");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    rent.startMovies();
                    break;
                case "2":
                     
                       
                   rent.startBooking();                  
                   rent.completeCreditCard();
                    break;
                case "3":
                    System.out.println("Exiting the program, thanks for chosing EirVideo");
                    System.exit(0);
                default:
                    System.out.println("Please only enter a number available in the options showed");
            }
    }
    
    }
}
    

            
    
