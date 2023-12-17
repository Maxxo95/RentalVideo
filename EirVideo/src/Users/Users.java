/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Users;

/**
 *
 * @author djap 2021231
 */
import Catalogs.Catalog;
import Rents.BookingHistory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Users {

    private String Username;
    private String EncryptedPassword;
    private Catalog catalog;
    private BookingHistory histbook;
    //Constructor,getter and setters

    public Users(String Username, String Password) {
       this.setUsername(Username);
        this.setPass(EncryptedPassword);
        this.setactiveMovies(catalog);
        this.setBookingHistory(histbook);

    }
 public void setPass(String EncryptedPassword){
     this.EncryptedPassword = EncryptedPassword;
 }
    public void setactiveMovies(Catalog catalog) {
        this.catalog = catalog;

    }

    public Catalog getActiveMovies() {
        return catalog;
    }

    public void setBookingHistory(BookingHistory histbook) {
        this.histbook = histbook;
    }

    public BookingHistory getBookingHistory() {
        return histbook;
    }

    public String getUsername() {
        return Username;
    }

    public String getEncryptedPassword() {
        return EncryptedPassword;
    }

    //SETERS to modify the stuff
    public void setUsername(String Username) {
        this.Username = Username;
    }
    // y los demas para poder setear un valor fuera de aqui

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
    // Getter and setter for catalog

}
