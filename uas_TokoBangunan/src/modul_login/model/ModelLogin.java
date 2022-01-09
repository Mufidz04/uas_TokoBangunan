/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul_login.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modul_db.KoneksiDatabase;

/**
 *
 * @author mufid
 */
public class ModelLogin {
    private String idUser;
    private String username;
    private String password;
    private String hakAkses;

    public ModelLogin() {

    }

    public ModelLogin(String idUser, String username, String password, String hakAkses) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.hakAkses = hakAkses;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
    }

    public ModelLogin login(String username, String password) {
        String sql = ("select * from user where username='" + username + "' and password='" + password + "'");

        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {

                return new ModelLogin(res.getString("idUser"),
                        res.getString("username"), "",
                        res.getString("level"));
            }

        } catch (SQLException ex) {
            // Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal disimpan ke dalam Database \n" + ex);
        }
        return null;
    }

    public void SimpanDataUser() {
        String sql = ("INSERT INTO user (username, password, level)"
                + "VALUES ('" + getUsername() + "' , '" + getPassword() + "' , '" + getHakAkses()+ "'  ) ");

        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke dalam Database");

        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal disimpan ke dalam Database \n" + ex);
        }
    }

    public void EditDataUser() {
        String sql = "UPDATE user SET username = '" + getUsername() + "' "
                + ", password = '" + getPassword() + "' "
                + ", level = '" + getHakAkses() + "' "
                + " WHERE idUser = '" + getIdUser() + "' ";
        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data berhasil diUpdate ke dalam Database");

        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diUpdate ke dalam Database \n" + ex);
        }
    }
}
