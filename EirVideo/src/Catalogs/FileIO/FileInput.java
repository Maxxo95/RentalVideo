/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Catalogs.FileIO;

import Catalogs.Catalog;
import Products.Product;
import Catalogs.DataIO.DataInput;
import java.util.ArrayList;
import Catalogs.FileIO.CSVReaderCheker;
/**
 *
 * @author maxim
 */
public class FileInput extends FileIO implements DataInput {
    CSVReaderCheker fr = new CSVReaderDecorator();
    
    @Override
    public Catalog getData() {
        ArrayList<Product> data = fr.readData();
        FileDataParser parser = new CSVDataParser();
        Catalog currentCatalog = parser.parseData(data);
        return currentCatalog;
    }
}