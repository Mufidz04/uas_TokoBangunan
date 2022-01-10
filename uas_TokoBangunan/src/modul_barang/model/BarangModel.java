/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_barang.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modul_db.KoneksiDatabase;

/**
 *
 * @author aripirwansyah
 */
public class BarangModel {
    private int idBarang;
    private String namaBarang;
    private String jenisBarang;
    private String satuan;
    private String ukuran;
    private int harga;
    private int jumlah;
    
    KoneksiDatabase koneksi = new KoneksiDatabase();

    public int getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(int idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
    
    public void SimpanDataBarang(){
        String sql = ("INSERT INTO produk (namaProduk, jenisProduk, satuan, ukuranProduk, hargaProduk, jumlahProduk)" 
                + " VALUES ('"+getNamaBarang()+"', '"+getJenisBarang()+"'"
                + ", '"+getSatuan()+"','"+getUkuran()+"', '"+getHarga()+"', '"+getJumlah()+"')");
        
        try {
            //inisialisasi preparedstement
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasi Disimpan");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan \n"+ex);
        }
    }
    
    public void updateDataBarang(){
        
        String sql = "UPDATE produk SET namaProduk = '"+getNamaBarang()+"'"
                +" ,jenisProduk ='"+getJenisBarang()+"'"
                +" ,satuan ='"+getSatuan()+"'"
                +" ,ukuranProduk ='"+getUkuran()+"'"
                +" ,hargaProduk ='"+getHarga()+"'"
                +" ,jumlahProduk='"+getJumlah()+"' WHERE idProduk = '"+getIdBarang()+"'";
        
        
        try {
            //inisialisasi preparedstement
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasi Diupdate");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Diupdate \n"+ex);
        }
    }
    
    public void deleteDataBarang(){
        String sql = "DELETE FROM produk WHERE idProduk = "
                + " '"+getIdBarang()+"'";
        
        try {
            //inisialisasi preparedstement
            PreparedStatement eksekusi = koneksi.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasi Dihapus");
        } catch (SQLException ex) {
            //Logger.getLogger(modelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus \n"+ex);
        }
    }
}
