/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul_login.controller;

import javax.swing.JOptionPane;
import modul_login.model.ModelLogin;
import modul_login.view.ViewLogin;
import uas_tokobangunan.App_Utama;

/**
 *
 * @author mufid
 */
public class ControllerLogin {

    private ModelLogin mL;
    private final ViewLogin vL;
    private static ControllerLogin single_instance = null;

    public ControllerLogin(ViewLogin vL) {
        this.mL = new ModelLogin();
        this.vL = vL;

    }

    public void Login() {
        ModelLogin nML = mL.login(vL.getUsernameTF().getText(), vL.getPasswordTF().getText());
        if (nML == null) {
            JOptionPane.showMessageDialog(null, "Data login tidak ditemukan");
        } else {
            vL.setVisible(false);
            this.mL = nML;
            App_Utama utama = new App_Utama();
            JOptionPane.showMessageDialog(null, mL.getHakAkses());
            utama.setVisible(true);

        }
    }

    public static ControllerLogin getInstance(ViewLogin vL) {
        if (single_instance == null) {
            single_instance = new ControllerLogin(vL);
        }
        return single_instance;
    }

    public void clear() {
        vL.getUsernameTF().setText("");
        vL.getPasswordTF().setText("");
    }

    public ModelLogin getmL() {
        return mL;
    }

    public ViewLogin getvL() {
        return vL;
    }
}
