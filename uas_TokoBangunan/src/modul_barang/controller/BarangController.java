/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_barang.controller;

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
    
    public void clear(){
        BV.getNamaBarangTF().setText("");
        BV.getJenisBarangCB().getSelectedItem().toString();
        BV.getSatuanCB().getSelectedItem().toString();
        BV.getUkuranCB().getSelectedItem().toString();
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
}
