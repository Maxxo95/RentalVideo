/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eirvideo;

import  eirvideo.Products.Product;
import eirvideo.Catalogs.Catalog;
import eirvideo.Products.Movie;
import eirvideo.Users.Users;
import eirvideo.Users.UsersManager;
import java.util.ArrayList;
import java.util.Scanner;

public class EirVideo {

  
    public static void main(String[] args) {
        
        
        Users user1 = new Users ("jair","jair13");
        
        Users user2 = new Users ("max","max123");
        
        UsersManager.addUser(user1);
        
        UsersManager.addUser(user2);
        
       // Log in 
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("TYPE USERNAME:");
        String Username = scanner.nextLine();
        
        System.out.println("TYPE PASSWORD:");
        String password = scanner.nextLine();
        
        if (UsersManager.validateCredentials(Username, password)) {
            System.out.println("WELCOME TO EIRVIDEO!!, THIS ARE THE MOVIE AVAILABLES:");
            // Add an else case
        } else {
            System.out.println("USERNAME OR PASSWORD INCORRECT, TRY AGAIN!");
        }
        
         Product movie1 = new Movie("PulpFiction", 3.99);
         Product movie2 = new Movie("Napoleon", 7.99);
         
         Catalog catalog = new Catalog();
         catalog.addProduct(movie1);
         catalog.addProduct(movie2);
         
         
        ArrayList<Product> catalogList = catalog.getCatalog();
        
        for (int i = 0; i < catalogList.size(); i++) {
            Product product = catalogList.get(i);
            System.out.println("Product" + (i+1) + ": " + product.getName() + ", Price: " + product.getPrice());
        }
    }
            }
    
