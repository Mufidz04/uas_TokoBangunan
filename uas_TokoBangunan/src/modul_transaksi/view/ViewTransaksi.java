/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul_transaksi.view;

import com.formdev.flatlaf.FlatLightLaf;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modul_db.KoneksiDatabase;
import modul_transaksi.controller.ControllerTransaksi;
import uas_tokobangunan.App_Utama;

/**
 *
 * @author mufid
 */
public class ViewTransaksi extends javax.swing.JFrame {

    DefaultTableModel tabelModel;
    String idProduk;
    String jumlahProduk;
    private ControllerTransaksi cT;

    public ViewTransaksi() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("Halaman Transaksi");

        cetakButton.setVisible(false);
        cT = new ControllerTransaksi(this);

        //Tabel
        tabelModel = new DefaultTableModel();
        tabelTransaksi.setModel(tabelModel);

        tabelModel.addColumn("ID");
        tabelModel.addColumn("Pelanggan");
        tabelModel.addColumn("Barang ");
        tabelModel.addColumn("Jenis");
        tabelModel.addColumn("Satuan");
        tabelModel.addColumn("Harga");
        tabelModel.addColumn("Jumlah");
        tabelModel.addColumn("Sub Total");

        getDataBarang();
    }

    public String getIdProduk() {
        return idProduk;
    }

    public String getJumlahProduk() {
        return jumlahProduk;
    }

    public JTextField getNamaPelangganTF() {
        return namaPelangganTF;
    }

    public JTextField getHargaProdukTF() {
        return hargaProdukTF;
    }

    public JTextField getJenisProdukTF() {
        return jenisProdukTF;
    }

    public JComboBox<String> getSatuanComboBox() {
        return comboBoxSatuan;
    }

    public JTable getTabelTransaksi() {
        return tabelTransaksi;
    }

    public JLabel getTotalTagihanLbl() {
        return totalTagihanLbl;
    }

    public JComboBox<String> getComboBoxNamaProduk() {
        return comboBoxNamaProduk;
    }

    public JSpinner getQtySpinner() {
        return qtySpinner;
    }

    public void getData() {
        int jumlahrow = tabelTransaksi.getRowCount();
        Object[][] hasil;
        hasil = new Object[8][8];

        for (int x = 0; x < jumlahrow; x++) {

            hasil[x][0] = tabelTransaksi.getValueAt(x, 0).toString();
            hasil[x][1] = tabelTransaksi.getValueAt(x, 1).toString();
            hasil[x][2] = tabelTransaksi.getValueAt(x, 2).toString();
            hasil[x][3] = tabelTransaksi.getValueAt(x, 3).toString();
            hasil[x][4] = tabelTransaksi.getValueAt(x, 4).toString();
            hasil[x][5] = tabelTransaksi.getValueAt(x, 5).toString();
            hasil[x][6] = tabelTransaksi.getValueAt(x, 6).toString();
            hasil[x][7] = tabelTransaksi.getValueAt(x, 7).toString();

            String sql = "INSERT INTO `laporan` (`idLaporan`, `namaPelanggan`, `namaProduk`, `jenisProduk`, `satuan`,  `hargaProduk`, `jumlahProduk`, `subtotal`) "
                    + " VALUES (null, '" + hasil[x][1] + "' , '" + hasil[x][2] + "' , '" + hasil[x][3] + "', '" + hasil[x][4] + "', '" + hasil[x][5] + "', '" + hasil[x][6] + "', '" + hasil[x][7] + "') ";
            try {
                PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
                eksekusi.execute();
                JOptionPane.showMessageDialog(null, "Data Laporan Disimpan Ke Dalam Database");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan Ke Dalam Database");
            }
        }
        cT.simpanLaporanDB();
    }

    public void getSatuanCombo() {
        String sql = "SELECT DISTINCT satuan from produk";
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {

                comboBoxSatuan.addItem(res.getString("satuan"));
            }

        } catch (Exception e) {

        }
    }

    public void getDataBarang() {
        String sql = "SELECT * from produk";
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] Hasil;
                Hasil = new Object[1];

                Hasil[0] = res.getString("namaProduk");

                comboBoxNamaProduk.addItem(Hasil[0].toString());

            }

        } catch (SQLException ex) {
            // Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diambil dari dalam Database \n" + ex.getMessage());
        }
        getSatuanCombo();
    }

    public void getAutomatedCMB() {
        if (comboBoxNamaProduk.getSelectedItem().equals("Pilih Produk")) {
            jenisProdukTF.setText("");
            hargaProdukTF.setText("");
        } else {
            try {
                String sql = "SELECT * FROM produk WHERE namaProduk = '" + comboBoxNamaProduk.getSelectedItem() + "'";
                Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
                ResultSet res = stat.executeQuery(sql);

                while (res.next()) {
                    Object[] Hasil;
                    Hasil = new Object[7];

                    Hasil[0] = res.getString("idProduk");
                    Hasil[1] = res.getString("namaProduk");
                    Hasil[2] = res.getString("jenisProduk");
                    Hasil[3] = res.getString("satuan");
                    Hasil[4] = res.getString("ukuranProduk");
                    Hasil[5] = res.getString("hargaProduk");
                    Hasil[6] = res.getString("jumlahProduk");

                    idProduk = Hasil[0].toString();
                    jumlahProduk = Hasil[6].toString();
                    comboBoxSatuan.setSelectedItem(Hasil[3].toString());
                    jenisProdukTF.setText(Hasil[2].toString());
                    hargaProdukTF.setText(Hasil[5].toString());
                }
            } catch (Exception e) {
            }
        }
    }

    public void getDataTabelModel() {

        String namaProduk = comboBoxNamaProduk.getSelectedItem().toString();
        String namaPelanggan = namaPelangganTF.getText();
        String satuan = comboBoxSatuan.getSelectedItem().toString();
        String jenisProduk = jenisProdukTF.getText();
        String hargaProduk = hargaProdukTF.getText();
        String qty = qtySpinner.getValue().toString();

        Object[] getValueTable;
        getValueTable = new Object[8];

        getValueTable[0] = idProduk;
        getValueTable[1] = namaPelanggan;
        getValueTable[2] = namaProduk;
        getValueTable[3] = jenisProduk;
        getValueTable[4] = satuan;
        getValueTable[5] = hargaProduk;
        getValueTable[6] = qty;
        getValueTable[7] = Integer.parseInt(hargaProdukTF.getText()) * Integer.parseInt(qtySpinner.getValue().toString());

        tabelModel.insertRow(tabelModel.getRowCount(), getValueTable);

    }

    public void getDataTagihan() {
        getDataTabelModel();

        int sum = 0;
        for (int i = 0; i < tabelModel.getRowCount(); i++) {
            sum = sum + Integer.parseInt((tabelModel.getValueAt(i, 7)).toString());
        }
        totalTagihanLbl.setText("Rp. " + sum);

    }

    public void getDataPrintBarang() {
        MessageFormat header = new MessageFormat("Surat Jalan UD. Tiga Saudara");
        MessageFormat footer = new MessageFormat("Tanda Tangan");
        try {
            getTabelTransaksi().print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Bisa Print! " + e.getMessage());
        }
    }

    public void clearEntryData() {
        comboBoxNamaProduk.setSelectedItem("Pilih Nama Produk");
        qtySpinner.setValue(0);
        comboBoxSatuan.setSelectedItem("Pilih Satuan");
        jenisProdukTF.setText("");
        hargaProdukTF.setText("");
    }

    public void clearDataTable() {
        ((DefaultTableModel) tabelTransaksi.getModel()).setNumRows(0);
        namaPelangganTF.setText("");
        comboBoxNamaProduk.setSelectedItem("Pilih Nama Produk");
        qtySpinner.setValue(0);
        comboBoxSatuan.setSelectedItem("Pilih Satuan");
        jenisProdukTF.setText("");
        hargaProdukTF.setText("");
        totalTagihanLbl.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tambahBarangButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        jenisProdukTF = new javax.swing.JTextField();
        hargaProdukTF = new javax.swing.JTextField();
        comboBoxSatuan = new javax.swing.JComboBox<>();
        qtySpinner = new javax.swing.JSpinner();
        comboBoxNamaProduk = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        namaPelangganTF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        prosesTransaksiButton = new javax.swing.JButton();
        totalTagihanLbl = new javax.swing.JLabel();
        clearButton = new javax.swing.JButton();
        cetakButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(96, 157, 160));

        jPanel2.setBackground(new java.awt.Color(228, 235, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informasi Penjualan"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(96, 157, 160));
        jLabel1.setText("Nama Produk");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(96, 157, 160));
        jLabel2.setText("Satuan");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(96, 157, 160));
        jLabel3.setText("Jenis Produk");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(96, 157, 160));
        jLabel5.setText("Harga Produk");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(96, 157, 160));
        jLabel6.setText("Qty");

        jLabel7.setBackground(new java.awt.Color(96, 157, 160));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(96, 157, 160));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PENJUALAN UD. Tiga Saudara");

        tambahBarangButton.setText("TAMBAH BARANG");
        tambahBarangButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBarangButtonActionPerformed(evt);
            }
        });

        batalButton.setText("BATAL");
        batalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                batalButtonMouseClicked(evt);
            }
        });

        jenisProdukTF.setEditable(false);

        hargaProdukTF.setEditable(false);

        comboBoxSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Satuan" }));

        qtySpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtySpinner.setEditor(new javax.swing.JSpinner.NumberEditor(qtySpinner, ""));

        comboBoxNamaProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Nama Produk" }));
        comboBoxNamaProduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxNamaProdukItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(96, 157, 160));
        jLabel4.setText("Nama Pelanggan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaPelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(batalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambahBarangButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxSatuan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(qtySpinner, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comboBoxNamaProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hargaProdukTF)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jenisProdukTF)))
                .addGap(41, 41, 41))
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel7)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(namaPelangganTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBoxSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jenisProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(hargaProdukTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batalButton)
                            .addComponent(tambahBarangButton)))
                    .addComponent(qtySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );

        jPanel3.setBackground(new java.awt.Color(228, 235, 213));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Barang Pembelian"));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelTransaksi);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(228, 235, 213));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Tagihan"));

        prosesTransaksiButton.setText("PROSES TRANSAKSI");
        prosesTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prosesTransaksiButtonActionPerformed(evt);
            }
        });

        totalTagihanLbl.setBackground(new java.awt.Color(96, 157, 160));
        totalTagihanLbl.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        totalTagihanLbl.setForeground(new java.awt.Color(96, 157, 160));
        totalTagihanLbl.setEnabled(false);

        clearButton.setText("CLEAR");
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        cetakButton.setText("CETAK");
        cetakButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cetakButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cetakButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prosesTransaksiButton)
                .addContainerGap())
            .addComponent(totalTagihanLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(totalTagihanLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prosesTransaksiButton)
                    .addComponent(clearButton)
                    .addComponent(cetakButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void prosesTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prosesTransaksiButtonActionPerformed
        // TODO add your handling code here:
        cetakButton.setVisible(true);
        String tagihan = totalTagihanLbl.getText();
        TableModel tabelToAnotherFrame = tabelTransaksi.getModel();
        int opsi = JOptionPane.showConfirmDialog(null,
                "Apakah Kamu Yakin Ingin Memproses Transaksi Ini?", "Select an Option...", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
            // Controller Simpan Laporan DB
            new ViewTransaksiLanjutan(hargaProdukTF, totalTagihanLbl);
            getData();
            // Constructor Frame Sebelah
            new ViewTransaksiLanjutan(tagihan).setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_prosesTransaksiButtonActionPerformed

    private void batalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_batalButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
        new App_Utama().setVisible(true);
    }//GEN-LAST:event_batalButtonMouseClicked

    private void comboBoxNamaProdukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxNamaProdukItemStateChanged
        // TODO add your handling code here:
        getAutomatedCMB();
    }//GEN-LAST:event_comboBoxNamaProdukItemStateChanged

    private void tambahBarangButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBarangButtonActionPerformed
        // TODO add your handling code here:
        if (namaPelangganTF.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tolong Isikan Data Yang Benar!");
        } else {
            getDataTagihan();
            clearEntryData();
        }
    }//GEN-LAST:event_tambahBarangButtonActionPerformed

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        // TODO add your handling code here:
        clearDataTable();
    }//GEN-LAST:event_clearButtonMouseClicked

    private void cetakButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cetakButtonMouseClicked
        // TODO add your handling code here:
        getDataPrintBarang();
    }//GEN-LAST:event_cetakButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalButton;
    private javax.swing.JButton cetakButton;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> comboBoxNamaProduk;
    private javax.swing.JComboBox<String> comboBoxSatuan;
    private javax.swing.JTextField hargaProdukTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jenisProdukTF;
    private javax.swing.JTextField namaPelangganTF;
    private javax.swing.JButton prosesTransaksiButton;
    private javax.swing.JSpinner qtySpinner;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JButton tambahBarangButton;
    private javax.swing.JLabel totalTagihanLbl;
    // End of variables declaration//GEN-END:variables
}
