/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author djap
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersManager {

    private static final String Users_File = "users.txt";
    Boolean isLogedIn = false;
   Boolean registered = false;
    UserLogIn userlog;
    SaveUsers addUser;
    private static final String CSV_FILE_PATH = "data.csv"; 
    boolean isAuthenticated = false;
    public void callMenu() {
        Scanner scanner = new Scanner(System.in);
/*
        while (true) {
            System.out.println("------------------------");
            System.out.println("      LOGIN SYSTEM      ");
            System.out.println("------------------------");
            System.out.println("Select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        userlog.UserLogIn(scanner);
                        break;
                    case 2:

                        addUser.register(scanner);
                        break;
                    case 3:
                        System.out.println("Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
            }
        }
    }
*/
           while (true) {
            System.out.println("------------------------");
            System.out.println("      LOGIN SYSTEM      ");
            System.out.println("------------------------");
            System.out.println("Select an option:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        int i =login(scanner);
                         if(i > 0){
                            return;
                        }
                         else{
                        break;
                         }
                    case 2:
                       int j = register(scanner);
                        if(j > 0){
                               System.exit(0);
                        }else{
                        break;}
                    case 3:
                        System.out.println("Exiting program.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
            }
        }
    }

    private  int login(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        List<String[]> data = readCsvFile();
        

        for (String[] record : data) {
            if (record[0].equals(email) && record[1].equals(password)) {
                isAuthenticated = true;
                System.out.println("Login successful!");
                System.out.println("Welcome, " + record[2] + " " + record[3] + "!");
               return 1;
                
            }
        }
        

        if (!isAuthenticated) {
            System.out.println("Login failed. Please check your email and password.");
        return -1;
        }
         return -1;
    }

    private static int register(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        List<String[]> records = readCsvFile();
        for (String[] record : records) {
            if (record[0].equals(email)) {
                System.out.println("User with email '" + email + "' already exists. Please login or use a different email.");
                return -1;
            }
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        String age = scanner.nextLine();

        try (FileWriter writer = new FileWriter(CSV_FILE_PATH, true)) {
            writer.append(email).append(",").append(password).append(",").append(firstName).append(",").append(lastName).append(",").append(age).append("\n");
            System.out.println("Registration successful!");
            System.out.println("Program needs to be restarted to log In with a new User, Thank you");
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private static List<String[]> readCsvFile() {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    } 
    
}
