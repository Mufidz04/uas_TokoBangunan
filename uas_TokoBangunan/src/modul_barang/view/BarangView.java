/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_barang.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modul_barang.controller.BarangController;
import modul_db.KoneksiDatabase;

/**
 *
 * @author aripirwansyah
 */
public class BarangView extends javax.swing.JFrame {

    /**
     * Creates new form BarangView1
     */
    
    private BarangView BV;
    private DefaultTableModel model;
    private BarangController BC;
    private String sql = "";
    public BarangView() {
        initComponents();
        
        this.BV = BV;
        
        BC = new BarangController(this);
        model = new DefaultTableModel();
        tabelDataBarang.setModel(model);
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Satuan");
        model.addColumn("Ukuran");
        model.addColumn("Harga");
        model.addColumn("Jumlah");
        
        tampilDataBarang();
    }

    public JTextField getIdBarangTF() {
        return idBarangTF;
    }

    public JTextField getHargaTF() {
        return hargaTF;
    }

    public JComboBox<String> getJenisBarangCB() {
        return jenisBarangCB;
    }

    public JTextField getCariBarangTF() {
        return cariBarangTF;
    }

    
    public JTextField getJumlahTF() {
        return jumlahTF;
    }

    public JTextField getNamaBarangTF() {
        return namaBarangTF;
    }

    public JComboBox<String> getSatuanCB() {
        return satuanCB;
    }

    public JComboBox<String> getUkuranCB() {
        return ukuranCB;
    }

    public JButton getSimpanBT() {
        return simpanBT;
    }

    public JButton getUpdateBT() {
        return updateBT;
    }

    public JButton getBatalBT() {
        return batalBT;
    }

    public JButton getHapusBT() {
        return hapusBT;
    }
    
    
    
    
    private void tampilDataBarang(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM produk";
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                Object[]hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("idProduk");
                hasil[1] = res.getString("namaProduk");
                hasil[2] = res.getString("jenisProduk");
                hasil[3] = res.getString("satuan");
                hasil[4] = res.getString("ukuranProduk");
                hasil[5] = res.getString("hargaProduk");
                hasil[6] = res.getString("jumlahProduk");
                
                model.addRow(hasil);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void ambilDataTabel(){
        int index = tabelDataBarang.getSelectedRow();
        
        String id = String.valueOf(tabelDataBarang.getValueAt(index, 0));
        String namabrg = String.valueOf(tabelDataBarang.getValueAt(index, 1));
        String jnsbrg = String.valueOf(tabelDataBarang.getValueAt(index, 2));
        String satuan = String.valueOf(tabelDataBarang.getValueAt(index, 3));
        String ukbrg = String.valueOf(tabelDataBarang.getValueAt(index, 4));
        String hrgbrg = String.valueOf(tabelDataBarang.getValueAt(index, 5));
        String jmlbrg = String.valueOf(tabelDataBarang.getValueAt(index, 6));
        
        idBarangTF.setText(id);
        namaBarangTF.setText(namabrg);
        jenisBarangCB.setSelectedItem(jnsbrg);
        satuanCB.setSelectedItem(satuan);
        ukuranCB.setSelectedItem(ukbrg);
        hargaTF.setText(hrgbrg);
        jumlahTF.setText(jmlbrg);
    }
    
    private void cariDataBarang(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        /*kondisi pengecekan apakah yang dicarinya
        seluruh data barang, atau salah satu saja
        */
        if(getCariBarangTF().getText().equals("")){
            sql = "select * from produk";
        }else{
            sql = "select * from produk WHERE namaProduk LIKE '"+getCariBarangTF().getText()+"%'";
        }
        
        try {
            Statement stat = (Statement)KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
          while(res.next()){
              Object[] hasil;
              hasil = new Object[7];
              
              hasil[0] = res.getString("idProduk");
              hasil[1] = res.getString("namaProduk");
              hasil[2] = res.getString("jenisProduk");
              hasil[3] = res.getString("satuan");
              hasil[4] = res.getString("ukuranProduk");
              hasil[5] = res.getString("hargaProduk");
              hasil[6] = res.getString("jumlahProduk");

              
              model.addRow(hasil);
          }  
        } catch (SQLException ex) {
            Logger.getLogger(BarangView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        idBarangTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        namaBarangTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jumlahTF = new javax.swing.JTextField();
        hargaTF = new javax.swing.JTextField();
        ukuranCB = new javax.swing.JComboBox<>();
        satuanCB = new javax.swing.JComboBox<>();
        jenisBarangCB = new javax.swing.JComboBox<>();
        simpanBT = new javax.swing.JButton();
        updateBT = new javax.swing.JButton();
        hapusBT = new javax.swing.JButton();
        batalBT = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDataBarang = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cariBarangTF = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Master Barang");
        setBackground(new java.awt.Color(96, 157, 160));
        setForeground(new java.awt.Color(96, 157, 160));

        jPanel1.setBackground(new java.awt.Color(224, 231, 207));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Barang"));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(95, 155, 159));
        jLabel1.setText("ID Barang");

        idBarangTF.setEnabled(false);
        idBarangTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idBarangTFActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 155, 159));
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(95, 155, 159));
        jLabel3.setText("Jenis Barang");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(95, 155, 159));
        jLabel4.setText("Satuan");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(95, 155, 159));
        jLabel5.setText("Ukuran");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(95, 155, 159));
        jLabel7.setText("Harga");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(95, 155, 159));
        jLabel6.setText("Jumlah");

        ukuranCB.setEditable(true);
        ukuranCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Ukuran--", "besar", "sedang", "kecil", "lainnya (ketik disini)" }));

        satuanCB.setEditable(true);
        satuanCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Satuan--", "kg", "pcs", "dus", "kol", "lainnya (ketik disini)" }));

        jenisBarangCB.setEditable(true);
        jenisBarangCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jenis Barang--", "Semen", "Pasir", "Bata", "Besi", "Paku", "Lem", "Keramik", "Cat", "Lainnya (ketik disini)" }));

        simpanBT.setBackground(new java.awt.Color(39, 94, 97));
        simpanBT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        simpanBT.setForeground(new java.awt.Color(255, 255, 255));
        simpanBT.setText("SIMPAN");
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });

        updateBT.setBackground(new java.awt.Color(39, 94, 97));
        updateBT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        updateBT.setForeground(new java.awt.Color(255, 255, 255));
        updateBT.setText("UBAH");
        updateBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBTActionPerformed(evt);
            }
        });

        hapusBT.setBackground(new java.awt.Color(39, 94, 97));
        hapusBT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        hapusBT.setForeground(new java.awt.Color(255, 255, 255));
        hapusBT.setText("HAPUS");
        hapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTActionPerformed(evt);
            }
        });

        batalBT.setBackground(new java.awt.Color(39, 94, 97));
        batalBT.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        batalBT.setForeground(new java.awt.Color(255, 255, 255));
        batalBT.setText("BATAL");
        batalBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(96, 157, 160));
        jLabel9.setText("DATA BARANG UD. Tiga Saudara");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(batalBT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hapusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateBT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(simpanBT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hargaTF)
                            .addComponent(satuanCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ukuranCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(namaBarangTF)
                            .addComponent(jenisBarangCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jumlahTF)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(idBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(142, 142, 142))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(namaBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jenisBarangCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(satuanCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ukuranCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jumlahTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanBT)
                    .addComponent(updateBT)
                    .addComponent(hapusBT)
                    .addComponent(batalBT))
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(224, 231, 207));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Barang"));

        tabelDataBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelDataBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelDataBarang);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setText("Cari");

        cariBarangTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariBarangTFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cariBarangTFKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cariBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariBarangTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void idBarangTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idBarangTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idBarangTFActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
        BC.simpan();
        tampilDataBarang();
    }//GEN-LAST:event_simpanBTActionPerformed

    private void updateBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBTActionPerformed
        // TODO add your handling code here:
        BC.update();
        tampilDataBarang();
    }//GEN-LAST:event_updateBTActionPerformed

    private void tabelDataBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelDataBarangMouseClicked
        // TODO add your handling code here:
        ambilDataTabel();
        BC.kontrolbuttonDua();
    }//GEN-LAST:event_tabelDataBarangMouseClicked

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        // TODO add your handling code here:
        BC.delete();
        
        tampilDataBarang();
    }//GEN-LAST:event_hapusBTActionPerformed

    private void batalBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBTActionPerformed
        // TODO add your handling code here:
        BC.kontrolbutton();
        BC.clear();
    }//GEN-LAST:event_batalBTActionPerformed

    private void cariBarangTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBarangTFKeyPressed
        // TODO add your handling code here:
        //tampilDataBarang(namaBarangTF.getText());
    }//GEN-LAST:event_cariBarangTFKeyPressed

    private void cariBarangTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariBarangTFKeyTyped
        // TODO add your handling code here:
        cariDataBarang();
    }//GEN-LAST:event_cariBarangTFKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarangView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarangView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalBT;
    private javax.swing.JTextField cariBarangTF;
    private javax.swing.JButton hapusBT;
    private javax.swing.JTextField hargaTF;
    private javax.swing.JTextField idBarangTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisBarangCB;
    private javax.swing.JTextField jumlahTF;
    private javax.swing.JTextField namaBarangTF;
    private javax.swing.JComboBox<String> satuanCB;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTable tabelDataBarang;
    private javax.swing.JComboBox<String> ukuranCB;
    private javax.swing.JButton updateBT;
    // End of variables declaration//GEN-END:variables
}
