/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author djap 2021231 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



public class Users {
    
    private  String Username;
    private  String EncryptedPassword;
    
    //Constructor,getter and setters
    
    public Users(String Username, String Password) {
        this.Username = Username;
        this.EncryptedPassword = encryptPassword(Password);
        
    }

    public String getUsername() {
        return Username;
    }

    public String getEncryptedPassword() {
        return EncryptedPassword;
    }
    
    public String encryptPassword(String Password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(Password.getBytes());
            StringBuilder sb = new StringBuilder();

            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
    
    
    
    
    
    
    
    

