/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_barang.controller;

import java.sql.SQLException;
import modul_barang.model.BarangModel;
import modul_barang.view.BarangView;

/**
 *
 * @author aripirwansyah
 */
public class BarangController {
    private BarangModel BM;
    private BarangView BV;
    
    public BarangController(BarangView BV) {
        this.BV = BV;
    }
    
    public void kontrolbutton(){
        BV.getSimpanBT().setEnabled(true);
        BV.getUpdateBT().setEnabled(false);
        BV.getHapusBT().setEnabled(false);
        BV.getBatalBT().setEnabled(true);
    }
    
    public void kontrolbuttonDua(){
        BV.getSimpanBT().setEnabled(false);
        BV.getUpdateBT().setEnabled(true);
        BV.getHapusBT().setEnabled(true);
        BV.getBatalBT().setEnabled(true);
    }
    
    public void clear(){
        BV.getNamaBarangTF().setText("");
        BV.getJenisBarangCB().removeAllItems();
        BV.getSatuanCB().removeAllItems();
        BV.getUkuranCB().removeAllItems();
        BV.getHargaTF().setText("");
        BV.getJumlahTF().setText("");
        
    }
    
    public void simpan(){
        BM = new BarangModel();
        BM.setNamaBarang(BV.getNamaBarangTF().getText());
        BM.setJenisBarang(BV.getJenisBarangCB().getSelectedItem().toString());
        BM.setSatuan(BV.getSatuanCB().getSelectedItem().toString());
        BM.setUkuran(BV.getUkuranCB().getSelectedItem().toString());
        BM.setHarga(Integer.parseInt(BV.getHargaTF().getText()));
        BM.setJumlah(Integer.parseInt(BV.getJumlahTF().getText()));
        clear();
        
        BM.SimpanDataBarang();
    }
    
    public void update(){
        BM = new BarangModel();
        BM.setIdBarang(Integer.parseInt(BV.getIdBarangTF().getText()));
        BM.setNamaBarang(BV.getNamaBarangTF().getText());
        BM.setJenisBarang(BV.getJenisBarangCB().getSelectedItem().toString());
        BM.setSatuan(BV.getSatuanCB().getSelectedItem().toString());
        BM.setUkuran(BV.getUkuranCB().getSelectedItem().toString());
        BM.setHarga(Integer.parseInt(BV.getHargaTF().getText()));
        BM.setJumlah(Integer.parseInt(BV.getJumlahTF().getText()));
       
        
        BM.updateDataBarang();
        clear();
        kontrolbutton();
    }
    
    public void delete(){
        BM = new BarangModel();
        BM.setIdBarang(Integer.parseInt(BV.getIdBarangTF().getText()));
        
        BM.deleteDataBarang();
        clear();
        kontrolbuttonDua();
    }
}