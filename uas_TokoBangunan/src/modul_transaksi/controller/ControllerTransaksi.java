/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul_transaksi.controller;

import modul_transaksi.model.ModelTransaksi;
import modul_transaksi.view.ViewTransaksi;
import modul_transaksi.view.ViewTransaksiLanjutan;

/**
 *
 * @author mufid
 */
public class ControllerTransaksi {

    private ModelTransaksi mT;
    private ViewTransaksi vT;
    private ViewTransaksiLanjutan vTL;

    public ControllerTransaksi(ViewTransaksi vT) {
        this.mT = new ModelTransaksi();
        this.vT = vT;
    }


    public void simpanLaporanDB() {
        mT = new ModelTransaksi();
        mT.setNamaPelanggan(vT.getNamaPelangganTF().getText());
        mT.setNamaBarang(vT.getComboBoxNamaProduk().getSelectedItem().toString());
        mT.setJenisProduk(vT.getJenisProdukTF().getText());
        mT.setSatuan(vT.getSatuanComboBox().getSelectedItem().toString());
        mT.setHargaProduk(vT.getHargaProdukTF().getText());
        mT.setQty(vT.getQtySpinner().getValue().toString());
        mT.setSubtotal(vT.getTotalTagihanLbl().getText());

//        mT.simpanTransaksiDB();
    }

}
