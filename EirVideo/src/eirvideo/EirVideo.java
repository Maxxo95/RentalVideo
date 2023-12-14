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
    
    Rent rent = new Rent();          
    Scanner scanner = new Scanner(System.in); 
    
    
    /*  
    String Username="Invited";
        String Password ="null";
        Users user = new Users(Username, Password); // USerNaem y password son las variables con las que trabajan pero instanciadas en objeto en User
     /*   
    
    AddUser addUser  = new AddUser();  //  
    UserLogIn userlogin = new UserLogIn();// USER LOG IN solo agarra (String, String) como parametro o (mail , contrase@a) como construccion de user , o user.pass, user.mail 
    // add user  no va relacionado con log in para nada , si juntos de la file txt pero corren por separado

    Scanner scanner = new Scanner(System.in); 

        
    // ESTOS  no van en while looop juntos mas bien seria hacer otro Menu que diga Log in o add user 
    
   
    
             /// Esto igual lo pasamos a user y lo llamamos como user  call data o algo asi para que se vea mas limpio 
        System.out.print("TYPE YOU USERNAME : ");
        String newUsername = scanner.nextLine();
        System.out.print("TYPE YOUR PASSWORD : ");
        String newPassword = scanner.nextLine();
         // Asi se debe ver arriba igual solo una linea
        addUser.RegisterUser(newUsername, newPassword);
    
        */
       /* 
   
        /// Esto igual lo pasamos a user y lo llamamos como user  call data o algo asi para que se vea mas limpio 
        System.out.print("TYPE YOU USERNAME : ");
         Username = scanner.nextLine();
        System.out.print("TYPE YOUR PASSWORD : ");
         Password = scanner.nextLine();
             // Asi se debe ver arriba igual solo una linea // Cheken credit card  y rent complete payment maso asi
        userlogin.UserLogIn("","");
        
        user.setUsername(Username); // AQUI BROS LO importante es que todos los methodos que hagan van a trabaajar con user y acceder a info de users creados, es asi como pueden 
        //Mover data de entre classes o acceder o settear , igual  necesitan escribir setPassword, luego en log in chekar la file con user.getName .. y 
        //Add USer es algo diferente asi que piensen mas como en el menu de abajo y cada uno es una opcion del user
        ////////////////////////////////////////////////////////////////Menu Que ya tenemos 
        ///////////////////////////////////////////////////////////////////////////////
       
*/
             while (true) {
            System.out.println("\n Main Menuu"
                    + "\n Select an Option");
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
                   rent.completeBooking();
                   rent.rewrite();
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
    

            
    
