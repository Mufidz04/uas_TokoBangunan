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
    private String namaPelanggan;
    private String subtotal;
    private String namaProduk;
    private String jenisProduk;
    private String satuan;
    private String ukuranProduk;
    private String hargaProduk;
    private String jumlahProduk;
    private String idProduk;
    private String idTransaksi;
    private String namaBarang;
    private String qty;

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getUkuranProduk() {
        return ukuranProduk;
    }

    public void setUkuranProduk(String ukuranProduk) {
        this.ukuranProduk = ukuranProduk;
    }

    public String getHargaProduk() {
        return hargaProduk;
    }

    public void setHargaProduk(String hargaProduk) {
        this.hargaProduk = hargaProduk;
    }

    public String getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(String jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

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
            JOptionPane.showConfirmDialog(null, "Data Gagal Disimpan Ke Dalam Database \n" + ex);
        }

    }
}
