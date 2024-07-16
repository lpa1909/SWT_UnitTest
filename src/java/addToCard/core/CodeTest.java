/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package addToCard.core;

import dal.DBContext;
import java.sql.SQLException;
import javax.naming.ldap.ManageReferralControl;
import model.Product;

/**
 *
 * @author NGUYEN LAN
 */
public class CodeTest {
    public static boolean ManageAddProduct(Product p) throws SQLException {
        
        DBContext db = new DBContext();
        db.addProduct(p);
        
        return true;
    }
    
    public static void main(String[] args) throws SQLException {
        Product p1 = new Product("DE90", "dress", "Rat dep", 12, "url", "url", "url", "url", "DE");
        if(ManageAddProduct(p1)){
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }
        
    }
}
