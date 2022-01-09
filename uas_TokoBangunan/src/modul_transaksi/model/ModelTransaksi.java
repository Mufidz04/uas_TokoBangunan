/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul_transaksi.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modul_db.KoneksiDatabase;

/**
 *
 * @author mufid
 */
public class ModelTransaksi {

    private String totalBayar;
    private String uangBayar;

    private String idTransaksiDetail;
    private String idTransaksi;
    private String namaBarang;
    private String qty;

    public String getTotalBayar() {
        return totalBayar;
    }

    public void setTotalBayar(String totalBayar) {
        this.totalBayar = totalBayar;
    }

    public String getUangBayar() {
        return uangBayar;
    }

    public void setUangBayar(String uangBayar) {
        this.uangBayar = uangBayar;
    }

    public String getIdTransaksiDetail() {
        return idTransaksiDetail;
    }

    public void setIdTransaksiDetail(String idTransaksiDetail) {
        this.idTransaksiDetail = idTransaksiDetail;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void simpanTransaksiDB() {
        String sql = "INSERT INTO transaksi (idTransaksi,namaPelanggan,totalBayar,uangBayar) "
                + " VALUES ('" + getIdTransaksi() + "' , '" + getNamaBarang() + "' , '" + getTotalBayar() + "' , '" + getUangBayar() + "' ) ";

        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();

            JOptionPane.showMessageDialog(null, "Data Transaksi Berhasil DiSimpan");

        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Data gagal disimpan ke dalam Database \n" + ex);
        }

    }
}
