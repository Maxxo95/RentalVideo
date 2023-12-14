/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Movie;

import java.util.Scanner;

public class CSVMovieReader extends FileIO implements CSVReaderCheker {
    Catalog data = new Catalog();

    @Override
    public Catalog readData() {
        try {
            Scanner sc = new Scanner(new java.io.FileReader(filename + ".csv"));

            // Skip the header row
            if (sc.hasNext()) {
                sc.nextLine();
            }

            while (sc.hasNext()) {
                String[] parts = sc.nextLine().split(",");

                if (parts.length == 5) {
                    
                    String name = parts[0].trim();
                    double price = Double.parseDouble(parts[1].trim());
                    int timesViewed = Integer.parseInt(parts[2].trim());
                    String lenguaje = parts[3].trim(); ;
                    String runtime = parts[4].trim(); ;
                    
                    Movie movie = new Movie(name, price);
                    movie.setName(name);
                    movie.setPrice(price);
                    movie.setTimesViewed(timesViewed);
                    movie.setlenguaje(lenguaje);
                    movie.setRuntime(runtime);
                    data.addProduct(movie);
                } else {
                    System.out.println("Invalid CSV format in line: " + String.join(", ", parts));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return data;
    }
}


