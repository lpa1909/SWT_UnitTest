/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test;

//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import addToCard.core.CodeTest;
import java.sql.SQLException;
import java.util.IllegalFormatException;
import model.Product;
import org.junit.Test;
import org.junit.Assert;
/**
 *
 * @author NGUYEN LAN
 */
public class ManageAddProduct {
    
    @Test(expected = NumberFormatException.class)
    public void AddProductPass() throws SQLException {  //G
        String id = "DE93";
            String name = "Dress";
            String detail = "Rat dep";
            String price_word = "abc";
            float price = Float.parseFloat(price_word);
            String image1 = "url";
            String image2 = "url";
            String image3 = "url";
            String image4 = "url";
            String cateID = "DE";
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            
            CodeTest.ManageAddProduct(p);
            
    }
    
    @Test
    public void AddProductFail1() throws SQLException {  //I
        Product p1 = new Product("1", "dress", "Rat dep", 12, "url", "url", "url", "url", "DE");
        boolean expected = false;
        boolean actual = CodeTest.ManageAddProduct(p1);
        Assert.assertEquals(expected, actual);
    }
    
    
    
    @Test
    public void AddProductFail2() throws SQLException {
        
        String id = "SE93";
            String name = "Dress";
            String detail = "Rat dep";
            String price_word = "-123";
            float price = Float.parseFloat(price_word);
            String image1 = "url";
            String image2 = "url";
            String image3 = "url";
            String image4 = "url";
            String cateID = "DE";
            Product p = new Product(id, name, detail, price,image1, image2, image3, image4, cateID);
            
            
        boolean expected = false;
        boolean actual = CodeTest.ManageAddProduct(p);
        Assert.assertEquals(expected, actual);
    }
    
    
}
