package gui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import koneksi.konek;

public class penyewaan extends java.awt.Dialog {
private Connection conn = new konek().connect();

public String kd_gedung, nm_gedung, hrg;
    public String getkd_gedung() {
        return this.kd_gedung;
    }
 
    public String getnm_gedung() {
        return this.nm_gedung;
    }
 
    public String gethrg() {
        return this.hrg;
    }

    public void setkd_gedung(String kd_gedung){
        this.kd_gedung = kd_gedung;
        kdgedung.setText(this.kd_gedung);
    }
    
    public void setnm_gedung(String nm_gedung){
        this.nm_gedung = nm_gedung;
        nama_gedung.setText(this.nm_gedung);
    }
    
    public void sethrg(String hrg){
       this.hrg = hrg;
       harga.setText(this.hrg);
    }
    
    protected void kosong(){
        siang.setEnabled(true);
        malam.setEnabled(true);
        nm_penyewa.setText("");   
        notelp.setText("");
       
    }
    
    public void kodesewa(){
        try{
            String sql = "select kode_sewa from pemesanan order by kode_sewa desc";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    String kode = rs.getString("kode_sewa").substring(2);
                    String AN = ""+(Integer.parseInt(kode)+1);
                    String Nol = "";
                    
                    if(AN.length()==1){
                        Nol="0";
                    }else if(AN.length()==2){
                        Nol="";
                    }
                    kdsewa.setText("SW" + Nol + AN);
                }else{
                    kdsewa.setText("SW01");
                }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void penyewa(){
        try{
            String sql = "select id_penyewa from pemesanan order by id_penyewa desc";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    String kode = rs.getString("id_penyewa").substring(1);
                    String AN = ""+(Integer.parseInt(kode)+1);
                    String Nol = "";
                    
                    if(AN.length()==1){
                        Nol="0";
                    }else if(AN.length()==2){
                        Nol="";
                    }
                        kdpenyewa.setText("P" + Nol + AN);
                }else{
                        kdpenyewa.setText("P01");
                }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public penyewaan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        kodesewa();
        penyewa();
       
        kdsewa.disable();
        kdpenyewa.disable();
        
        Date date = new Date();
        tgl.setDate(date);
        System.out.println("Data dari dialog:\n");
 }
    
    public void simpan(){    
        Date HariSekarang = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String DateTime = ft.format(HariSekarang);
        
        String a = "Lunas";
        String b = "Belum Lunas";
        
        
        
        try{   
            String pilih = " ";
            if(siang.isSelected())pilih="Siang";
             else if(malam.isSelected()) pilih="Malam";
             else 
                 pilih="";
            //JOptionPane.showMessageDialog(this,"");
            
            if(pilih.length()==0){
                JOptionPane.showMessageDialog(this,"Pilih Waktu");
            } else {
                if(nm_penyewa.getText().length()==0){
                    JOptionPane.showMessageDialog(this,"Nama Belum Diisi");
                    nm_penyewa.requestFocus();
                } else {
                    if(notelp.getText().length()==0){
                        JOptionPane.showMessageDialog(this,"Nomor Telepon Belum Diisi");
                        notelp.requestFocus();
                    } else {
                        if(bayar.getText().length()==0){
                            JOptionPane.showMessageDialog(this,"Pembayaran Belum Diisi");
                            bayar.requestFocus();
                                } else{
                                    String sql="Insert into pemesanan (kode_sewa,tanggal,kode_ruang,nama_ruang,"
                                            + "harga,waktu,id_penyewa,nama_penyewa,notelp,bayar,status) values (?,?,?,?,?,?,?,?,?,?,?)";  
                                    PreparedStatement p=(PreparedStatement)conn.prepareStatement(sql);
                                    p.setString(1,kdsewa.getText());
                                    p.setString(2,DateTime);
                                    p.setString(3,kdgedung.getText());
                                    p.setString(4,nama_gedung.getText());
                                    p.setString(5,harga.getText());
                                    p.setString(6, pilih);
                                    p.setString(7,kdpenyewa.getText());
                                    p.setString(8,nm_penyewa.getText());
                                    p.setString(9,notelp.getText());
                                    p.setString(10,bayar.getText());
                                    String terpilih;
                                    //String c = harga.getText();
                                    
                                    String d = bayar.getText();
                                    String ab = harga.getText();
                                    int i = Integer.parseInt(d.trim());
                                    int j = Integer.parseInt(ab.trim());
                                    if ( i == j){
                                        terpilih = a;
                                        }
                                     else {
                                         terpilih = b;
                                        }
                                        
                                    
                                    p.setString(11,terpilih);
                                    p.executeUpdate();
                                    JOptionPane.showMessageDialog(this,"Data Telah Tersimpan");
                                    dispose();
                                }
                }    
            } 
            }
       }catch(SQLException e){ 
            System.out.println(e);  
       }
        kodesewa();   
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wkt = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nama3 = new javax.swing.JLabel();
        kdsewa = new javax.swing.JTextField();
        nama4 = new javax.swing.JLabel();
        nama1 = new javax.swing.JLabel();
        nama_gedung = new javax.swing.JTextField();
        Lokasi = new javax.swing.JLabel();
        siang = new javax.swing.JRadioButton();
        malam = new javax.swing.JRadioButton();
        Harga1 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        Harga = new javax.swing.JLabel();
        tgl = new com.toedter.calendar.JDateChooser();
        Lokasi1 = new javax.swing.JLabel();
        notelp = new javax.swing.JTextField();
        nm_penyewa = new javax.swing.JTextField();
        kdpenyewa = new javax.swing.JTextField();
        nama5 = new javax.swing.JLabel();
        nama2 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        kdgedung = new javax.swing.JTextField();
        cekgedung = new javax.swing.JButton();
        Lokasi2 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Form Data Penyewaan Ruang Diklat");

        nama3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nama3.setText("Kode Sewa");

        kdsewa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        nama4.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nama4.setText("Kode Gedung");

        nama1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nama1.setText("Nama Gedung");

        nama_gedung.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        Lokasi.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Lokasi.setText("Waktu");

        siang.setBackground(new java.awt.Color(255, 255, 255));
        wkt.add(siang);
        siang.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        siang.setText("Siang");

        malam.setBackground(new java.awt.Color(255, 255, 255));
        wkt.add(malam);
        malam.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        malam.setText("Malam");

        Harga1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Harga1.setText("Harga Sewa");

        harga.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        Harga.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Harga.setText("Tanggal Sewa");

        tgl.setDateFormatString("dd MM yyyy");
        tgl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tgl.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tglInputMethodTextChanged(evt);
            }
        });
        tgl.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tglPropertyChange(evt);
            }
        });

        Lokasi1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Lokasi1.setText("No. Telepon");

        notelp.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        nm_penyewa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        kdpenyewa.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        nama5.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nama5.setText("Kode Penyewa");

        nama2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nama2.setText("Nama Penyewa");

        simpan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/isave.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        batal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        batal.setForeground(new java.awt.Color(255, 0, 0));
        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iclose.png"))); // NOI18N
        batal.setText("Batal");
        batal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        kdgedung.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        cekgedung.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        cekgedung.setForeground(new java.awt.Color(255, 51, 51));
        cekgedung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icek.png"))); // NOI18N
        cekgedung.setText("Cek Ketersediaan");
        cekgedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekgedungActionPerformed(evt);
            }
        });

        Lokasi2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Lokasi2.setText("Bayar (Rp)");

        bayar.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nama3)
                            .addComponent(Harga))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kdsewa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cekgedung)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nama4)
                                .addComponent(nama1))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(kdgedung, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(nama_gedung, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Lokasi)
                                .addComponent(Harga1))
                            .addGap(39, 39, 39)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(siang)
                                    .addGap(10, 10, 10)
                                    .addComponent(malam))
                                .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addGap(39, 39, 39)
                        .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(nama5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(kdpenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nama2)
                                .addComponent(Lokasi1)
                                .addComponent(Lokasi2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(notelp, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nm_penyewa)
                                .addComponent(bayar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(21, 21, 21)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama5)
                            .addComponent(kdpenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nm_penyewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lokasi1)
                            .addComponent(notelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lokasi2)
                            .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(batal)
                            .addComponent(simpan)
                            .addComponent(cekgedung)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kdsewa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Harga)
                            .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kdgedung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nama_gedung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Harga1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(siang)
                                .addComponent(malam))
                            .addComponent(Lokasi))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {batal, cekgedung, simpan});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {harga, kdgedung, kdpenyewa, kdsewa, nama_gedung, nm_penyewa, notelp});

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        simpan();
        kosong();
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        kosong();
    }//GEN-LAST:event_batalActionPerformed

    private void tglPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tglPropertyChange
     
    }//GEN-LAST:event_tglPropertyChange

    private void tglInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tglInputMethodTextChanged
         if(tgl.getDate() != null) {
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            String tglcari = ft.format(tgl.getDate());

            String sql = "select * from pemesanan WHERE tanggal='"+tglcari+"' AND kode_ruang=' "+kdgedung.getText()+"' ";  

            try {
                int x=0;
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                while(hasil.next()){
                    if(hasil.getString("waktu") == "siang") {
                        siang.setSelected(true);
                        System.out.println(hasil.getString("waktu"));
                    } else if(hasil.getString("waktu") == "malam") {
                        malam.setSelected(true);
                        System.out.println(hasil.getString("waktu"));
                    } else {
                        System.out.println(hasil.getString("waktu")+" KOSONG");
                    }
                }
             }catch (Exception e) {
                   e.printStackTrace();
            }
        } else {
            
        }
    }//GEN-LAST:event_tglInputMethodTextChanged

    private void cekgedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekgedungActionPerformed

        siang.setEnabled(true);
        malam.setEnabled(true);
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            String tglcari = ft.format(tgl.getDate());
            String sql = "select * from pemesanan WHERE tanggal='"+tglcari+"' AND kode_ruang= '"+kdgedung.getText()+"' ";  
            System.out.println(sql);

            try {
                int x=0;
                Statement stat = conn.createStatement();
                ResultSet hasil = stat.executeQuery(sql);
                if(hasil.first()){
                    if(hasil.getString("waktu").equalsIgnoreCase("siang")) {
                        siang.setEnabled(false);
                        System.out.println("Siang");
                    } else if(hasil.getString("waktu").equalsIgnoreCase("malam")){
                        malam.setEnabled(false);
                        System.out.println("Malam");
                    } 
                } else {
                        System.out.println(" KOSONG");
                }
                
             }catch (Exception e) {
                   e.printStackTrace();
            }
    }//GEN-LAST:event_cekgedungActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                penyewaan dialog = new penyewaan(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Harga;
    private javax.swing.JLabel Harga1;
    private javax.swing.JLabel Lokasi;
    private javax.swing.JLabel Lokasi1;
    private javax.swing.JLabel Lokasi2;
    private javax.swing.JButton batal;
    private javax.swing.JTextField bayar;
    private javax.swing.JButton cekgedung;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField kdgedung;
    private javax.swing.JTextField kdpenyewa;
    private javax.swing.JTextField kdsewa;
    private javax.swing.JRadioButton malam;
    private javax.swing.JLabel nama1;
    private javax.swing.JLabel nama2;
    private javax.swing.JLabel nama3;
    private javax.swing.JLabel nama4;
    private javax.swing.JLabel nama5;
    private javax.swing.JTextField nama_gedung;
    private javax.swing.JTextField nm_penyewa;
    private javax.swing.JTextField notelp;
    private javax.swing.JRadioButton siang;
    private javax.swing.JButton simpan;
    private com.toedter.calendar.JDateChooser tgl;
    private javax.swing.ButtonGroup wkt;
    // End of variables declaration//GEN-END:variables
}