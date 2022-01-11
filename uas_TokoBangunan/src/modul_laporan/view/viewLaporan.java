/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_laporan.view;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modul_db.KoneksiDatabase;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asep Supriyanto
 */
public class viewLaporan extends javax.swing.JFrame {

    private DefaultTableModel model;

    /**
     * Creates new form viewLaporan
     */
    public viewLaporan() {
        initComponents();
         model = new DefaultTableModel();
        tabelLaporan.setModel(model);
        model.addColumn("ID Produk");
        model.addColumn("Nama Produk");
        model.addColumn("Jenis Produk");
        model.addColumn("Satuan Produk");
        model.addColumn("Ukuran Produk");
        model.addColumn("Harga Produk");
        model.addColumn("Jumlah Produk");
        model.addColumn("Tanggal Transaksi");
        
        tampilDataLaporan();
    }
    
    public JButton getTombolEksport() {
        return tombolEksport;
    }

    public void setTombolEksport(JButton tombolEksport) {
        this.tombolEksport = tombolEksport;
    }
    
private void tampilDataLaporan(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        String sql = "SELECT * FROM laporan";
        
        try {        
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);
            
            while(res.next()){
                //mengambil hasil query variabel sql
                Object[] hasil;
                hasil = new Object[8];//karena ada 8 filed ditabel pelanggan
                hasil[0] = res.getString("idProduk");
                hasil[1] = res.getString("namaProduk");
                hasil[2] = res.getString("jenisProduk");
                hasil[3] = res.getString("satuan");
                hasil[4] = res.getString("ukuranProduk");
                hasil[5] = res.getString("hargaProduk");
                hasil[6] = res.getString("jumlahProduk");
                hasil[7] = res.getString("tglTransaksi");
               model.addRow(hasil);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(viewLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


private void eksportData(){
    FileOutputStream excelFOU = null;
            BufferedOutputStream excelBOU = null;
            XSSFWorkbook excelJTableExporter = null;
            
            //lokasi file
        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\Asep Supriyanto\\Documents");
        
        //merubah dialog 
        excelFileChooser.setDialogTitle("Save as");
//memberikan ekstension file
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
       
        excelFileChooser.setFileFilter((fnef));
        int excelChooser = excelFileChooser.showSaveDialog(null);
        
        //mengecek tombol simpan
        if(excelChooser == JFileChooser.APPROVE_OPTION){
            
            
            
            try {
                //librari poi
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable sheet");
                for (int i = 0; i < model.getRowCount(); i++){
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < model.getColumnCount(); j++){
                        XSSFCell excelCell = excelRow.createCell(j);
                        
                        excelCell.setCellValue(model.getValueAt(i, j).toString());
                    }
                }   //menambahkan xlsx pada file terpilih untuk unik
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                 excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Eksport berhasil!");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if(excelBOU != null){
                        excelBOU.close();
                    }
                     if(excelFOU != null){
                        excelFOU.close();
                    }
                      if(excelJTableExporter != null){
                        excelJTableExporter.close();
                    }
                    excelFOU.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelLaporan = new javax.swing.JTable();
        tombolEksport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laporan");
        setBackground(new java.awt.Color(224, 231, 207));

        jPanel1.setBackground(new java.awt.Color(224, 231, 207));

        tabelLaporan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelLaporan.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jScrollPane1.setViewportView(tabelLaporan);

        tombolEksport.setBackground(new java.awt.Color(39, 94, 97));
        tombolEksport.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tombolEksport.setForeground(new java.awt.Color(255, 255, 255));
        tombolEksport.setText("EXPORT");
        tombolEksport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEksportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(358, Short.MAX_VALUE)
                .addComponent(tombolEksport, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tombolEksport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tombolEksportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolEksportActionPerformed
        // TODO add your handling code here:
        eksportData();
    }//GEN-LAST:event_tombolEksportActionPerformed

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
            java.util.logging.Logger.getLogger(viewLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewLaporan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelLaporan;
    private javax.swing.JButton tombolEksport;
    // End of variables declaration//GEN-END:variables
}
