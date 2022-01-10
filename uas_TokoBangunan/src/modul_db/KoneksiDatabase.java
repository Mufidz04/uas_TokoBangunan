/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_db;

import java.sql.Connection;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mufid
 */
public class KoneksiDatabase {
   private static Connection conn;
        private static Properties propert = new Properties();
        
        private static String driver = "com.mysql.jdbc.Driver"; 
        private static String url = "jdbc:mysql://localhost:3306/db_material"; 
        private static String username = "root"; 
        private static String password = ""; 
        
        public static Connection getKoneksi() throws SQLException {
        if(conn == null){
            try {
                conn = DriverManager.getConnection(url,username,password);
                } 
            catch (SQLException ex) {
                Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        return conn;
    }
    public static void main (String[] args) throws SQLException{
    if(getKoneksi().equals(conn)){
        System.out.println("Sukses Terkoneksi");
    }
    }
}
