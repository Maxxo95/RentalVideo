/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvideo;



import Rents.Rent;
import Users.UserLogIn;
import Users.AddUser;
import Users.Users;
import java.util.Scanner;


public class EirVideo {

  
    public static void main(String[] args) {
    AddUser addUser  = new AddUser();
    UserLogIn userlogin = new UserLogIn(addUser.getUsers());
    
   
       Rent rent = new Rent();
       
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("TYPE YOU USERNAME : ");
        String newUsername = scanner.nextLine();
        System.out.print("TYPE YOUR PASSWORD : ");
        String newPassword = scanner.nextLine();

        addUser.RegisterUser(newUsername, newPassword);
        
        
        System.out.print("TYPE YOU USERNAME : ");
        String Username = scanner.nextLine();
        System.out.print("TYPE YOUR PASSWORD : ");
        String Password = scanner.nextLine();

        userlogin.UserLogIn("","");
        
            System.out.println("\n Main Menu"
                    + "\n Select an option");
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
    

            
    
