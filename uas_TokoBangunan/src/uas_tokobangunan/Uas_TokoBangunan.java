/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uas_tokobangunan;

import com.formdev.flatlaf.FlatLightLaf;
import modul_login.view.ViewLogin;


/**
 *
 * @author mufid
 */
public class Uas_TokoBangunan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FlatLightLaf.setup();
        // TODO code application logic here
//        App_Utama utama = new App_Utama();
//        utama.setVisible(true);
        
        ViewLogin login = new ViewLogin();
        login.setVisible(true);
    }
    
}
