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
/**
 *
 * @author Asep Supriyanto
 */
public class KoneksiDatabase {
     //inisialisasi variabel dg connection file clas JDBC
    private static Connection conn;
    
    private static Properties propert = new Properties();
    public static Connection getKoneksi() throws SQLException{
        if(conn == null){
                try {
                    propert.load(new FileInputStream("C:\\Users\\aripirwansyah\\Documents\\NetBeansProjects\\uas_TokoBangunan\\uas_TokoBangunan\\src\\modul_db\\konfigurasiDatabase.properties"));
                } catch (IOException ex) {
                   System.err.println("error mengambil file"+ex);
                   
                   System.err.println("error mengambil file"+ex);
                }
                //inisialisasi koneksi database
                conn = DriverManager.getConnection(propert.getProperty("jdbc.url"),propert.getProperty("jdbc.username"),propert.getProperty("jdbc.password"));
            } 
          return conn;
        }
  
        public static void main(String[] args) throws SQLException {
        if (getKoneksi().equals(conn)){
            System.out.print("sukses terkoneksi ");
        }
    }
}
