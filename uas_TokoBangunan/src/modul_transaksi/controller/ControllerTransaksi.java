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

    public ControllerTransaksi(ViewTransaksi vT, ViewTransaksiLanjutan vTL) {
        this.vT = vT;
        this.vTL = vTL;
    }
}
