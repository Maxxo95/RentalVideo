/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import Catalogs.Catalog;
import java.util.ArrayList;

/**
 *
 * @author maxim
 */
public class MovieParser {
     public Catalog addProduct(ArrayList<Movie> data) {
        Catalog movieCatalog = new Catalog();
        for (Movie movie : data) {
            movieCatalog.addProduct(movie);
        }
        return movieCatalog; 
   }

   
}
