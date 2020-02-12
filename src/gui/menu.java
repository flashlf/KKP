package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.Timer;
import koneksi.konek;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class menu extends javax.swing.JFrame {

 public void setTanggal(){
        Date skrg = new Date();
        SimpleDateFormat kal = new SimpleDateFormat("E, dd MMMM yyyy");
        tanggal.setText(kal.format(skrg));
    }  
    
    public void setJam(){
    ActionListener taskPerformer = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
        String nol_jam = "", nol_menit = "",nol_detik = "";

        java.util.Date dateTime = new java.util.Date();
        int nilai_jam = dateTime.getHours();
        int nilai_menit = dateTime.getMinutes();
        int nilai_detik = dateTime.getSeconds();

        if(nilai_jam <= 9) nol_jam= "0";
        if(nilai_menit <= 9) nol_menit= "0";
        if(nilai_detik <= 9) nol_detik= "0";

        String waktu = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);

        time.setText(waktu+":"+menit+":"+detik+" WIB");
        }                             
    };
new Timer(1000, taskPerformer).start();
}    
    
    private Connection conn = new konek().connect();
    public menu() {
        initComponents();
        this.setTitle("Aplikasi Penyewaan Ruang Diklat");
        this.setLocationRelativeTo(null);
        setTanggal();
        setJam();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paneldasar = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        tanggal1 = new javax.swing.JLabel();
        time1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        paneldasar2 = new javax.swing.JPanel();
        penginapan = new javax.swing.JButton();
        jadwal = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        saung = new javax.swing.JButton();
        gedung = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        laporan = new javax.swing.JMenu();
        Laporan = new javax.swing.JMenuItem();
        dewantoro = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        KartiniI = new javax.swing.JMenuItem();
        KartiniII = new javax.swing.JMenuItem();
        AgusSalim = new javax.swing.JMenuItem();
        Sudirman = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU UTAMA APLIKASI PENYEWAAN RUANG DIKLAT BERBASIS JAVA");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneldasar.setBackground(new java.awt.Color(51, 102, 0));

        panel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel.setPreferredSize(new java.awt.Dimension(595, 415));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        panel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        panel2.setPreferredSize(new java.awt.Dimension(595, 415));
        panel2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("APLIKASI PENYEWAAN RUANG DIKLAT");

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TAMAN REKREASI WILADATIKA CIBUBUR");

        tanggal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggal.setForeground(new java.awt.Color(204, 255, 204));
        tanggal.setText("TANGGAL");

        time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        time.setForeground(new java.awt.Color(204, 255, 204));
        time.setText("WAKTU");

        tanggal1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tanggal1.setForeground(new java.awt.Color(255, 255, 255));
        tanggal1.setText("TANGGAL : ");

        time1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        time1.setForeground(new java.awt.Color(255, 255, 255));
        time1.setText("PUKUL : ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/wiladatika.png"))); // NOI18N

        javax.swing.GroupLayout paneldasarLayout = new javax.swing.GroupLayout(paneldasar);
        paneldasar.setLayout(paneldasarLayout);
        paneldasarLayout.setHorizontalGroup(
            paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldasarLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldasarLayout.createSequentialGroup()
                        .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(123, 123, 123))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldasarLayout.createSequentialGroup()
                        .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneldasarLayout.createSequentialGroup()
                                .addComponent(tanggal1)
                                .addGap(1, 1, 1)
                                .addComponent(tanggal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(paneldasarLayout.createSequentialGroup()
                                .addComponent(time1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(time)))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        paneldasarLayout.setVerticalGroup(
            paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneldasarLayout.createSequentialGroup()
                .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneldasarLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneldasarLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)))
                .addGap(27, 27, 27)
                .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggal)
                    .addComponent(tanggal1)
                    .addComponent(time)
                    .addComponent(time1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneldasarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        getContentPane().add(paneldasar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 1230, 730));

        paneldasar2.setBackground(new java.awt.Color(0, 0, 0));
        paneldasar2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        penginapan.setBackground(new java.awt.Color(255, 255, 255));
        penginapan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        penginapan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ihome.png"))); // NOI18N
        penginapan.setText("Penginapan");
        penginapan.setActionCommand("");
        penginapan.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        penginapan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        penginapan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penginapanActionPerformed(evt);
            }
        });
        paneldasar2.add(penginapan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 100, 30));

        jadwal.setBackground(new java.awt.Color(255, 255, 255));
        jadwal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ijadwal.png"))); // NOI18N
        jadwal.setText("Jadwal");
        jadwal.setActionCommand("");
        jadwal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jadwal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jadwalActionPerformed(evt);
            }
        });
        paneldasar2.add(jadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 100, 30));

        logout.setBackground(new java.awt.Color(255, 255, 255));
        logout.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iexit.png"))); // NOI18N
        logout.setText("Logout");
        logout.setActionCommand("");
        logout.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        paneldasar2.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 100, 30));

        saung.setBackground(new java.awt.Color(255, 255, 255));
        saung.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        saung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/igedung.png"))); // NOI18N
        saung.setText("Saung");
        saung.setActionCommand("");
        saung.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        saung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saungActionPerformed(evt);
            }
        });
        paneldasar2.add(saung, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, 30));

        gedung.setBackground(new java.awt.Color(255, 255, 255));
        gedung.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        gedung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/igedung.png"))); // NOI18N
        gedung.setText("Gedung");
        gedung.setActionCommand("");
        gedung.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        gedung.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        gedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gedungActionPerformed(evt);
            }
        });
        paneldasar2.add(gedung, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 30));

        getContentPane().add(paneldasar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 730));

        laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/idata.png"))); // NOI18N
        laporan.setText("Laporan");
        laporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Laporan.setText("Laporan");
        Laporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });
        laporan.add(Laporan);

        dewantoro.setText("Dewantoro");
        dewantoro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dewantoro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dewantoroActionPerformed(evt);
            }
        });
        laporan.add(dewantoro);

        jMenu1.setText("Kartini");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        KartiniI.setText("Kartini I");
        KartiniI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KartiniI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KartiniIActionPerformed(evt);
            }
        });
        jMenu1.add(KartiniI);

        KartiniII.setText("Kartini II");
        KartiniII.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        KartiniII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KartiniIIActionPerformed(evt);
            }
        });
        jMenu1.add(KartiniII);

        laporan.add(jMenu1);

        AgusSalim.setText("R.H Agus Salim");
        AgusSalim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        AgusSalim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgusSalimActionPerformed(evt);
            }
        });
        laporan.add(AgusSalim);

        Sudirman.setText("Sudirman");
        Sudirman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SudirmanActionPerformed(evt);
            }
        });
        laporan.add(Sudirman);

        jMenuBar2.add(laporan);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void penginapanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penginapanActionPerformed
      
    }//GEN-LAST:event_penginapanActionPerformed

    private void jadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jadwalActionPerformed
        jadwal m = new jadwal();
        panel2.add(m);
        m.setVisible(true);
    }//GEN-LAST:event_jadwalActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        login n = new login();
        n.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_logoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setExtendedState(menu.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
      periode n = new periode();
        n.setVisible(true);
/*try {
            HashMap data = new HashMap();
            String lap=("./src/laporan/Laporan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(lap, data, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Laporan Penyewaan Ruang Diklat");
            jv.setVisible(true);
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan!");
        }
*/
    }//GEN-LAST:event_LaporanActionPerformed

    private void AgusSalimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgusSalimActionPerformed
        try {
            HashMap data = new HashMap();
            String lap=("./src/laporan/Lap_Agus.jasper");
            JasperPrint jp = JasperFillManager.fillReport(lap, data, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Laporan Gedung R.H.Agus Salim");
            jv.setVisible(true);
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan!");
        }
     //coba dari komputer riza
    }//GEN-LAST:event_AgusSalimActionPerformed

    private void dewantoroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dewantoroActionPerformed
        try {
            HashMap data = new HashMap();
            String lap=("./src/laporan/Lap_Dewan.jasper");
            JasperPrint jp = JasperFillManager.fillReport(lap, data, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Laporan Gedung Dewantoro");
            jv.setVisible(true);
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan!");
        }
    }//GEN-LAST:event_dewantoroActionPerformed

    private void KartiniIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KartiniIActionPerformed
        try {
            HashMap data = new HashMap();
            String lap=("./src/laporan/Lap_Kar1.jasper");
            JasperPrint jp = JasperFillManager.fillReport(lap, data, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Laporan Gedung Kartini I");
            jv.setVisible(true);
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan!");
        }
    }//GEN-LAST:event_KartiniIActionPerformed

    private void KartiniIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KartiniIIActionPerformed
        try {
            HashMap data = new HashMap();
            String lap=("./src/laporan/Lap_Kar2.jasper");
            JasperPrint jp = JasperFillManager.fillReport(lap, data, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Laporan Gedung Kartini II");
            jv.setVisible(true);
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan!");
        }
    }//GEN-LAST:event_KartiniIIActionPerformed

    private void SudirmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SudirmanActionPerformed
        try {
            HashMap data = new HashMap();
            String lap=("./src/laporan/Lap_Sudir.jasper");
            JasperPrint jp = JasperFillManager.fillReport(lap, data, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Laporan Gedung Sudirman");
            jv.setVisible(true);
        } catch (Exception e){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan!");
        }
    }//GEN-LAST:event_SudirmanActionPerformed

    private void saungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saungActionPerformed
        daftar_saung m = new daftar_saung();
        panel.add(m);
        m.setVisible(true);
    }//GEN-LAST:event_saungActionPerformed

    private void gedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gedungActionPerformed
        daftar_gedung n = new daftar_gedung();
        panel.add(n);
        n.setVisible(true);
    }//GEN-LAST:event_gedungActionPerformed

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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AgusSalim;
    private javax.swing.JMenuItem KartiniI;
    private javax.swing.JMenuItem KartiniII;
    private javax.swing.JMenuItem Laporan;
    private javax.swing.JMenuItem Sudirman;
    private javax.swing.JMenuItem dewantoro;
    private javax.swing.JButton gedung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JButton jadwal;
    private javax.swing.JMenu laporan;
    private javax.swing.JButton logout;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel paneldasar;
    private javax.swing.JPanel paneldasar2;
    private javax.swing.JButton penginapan;
    private javax.swing.JButton saung;
    private javax.swing.JLabel tanggal;
    private javax.swing.JLabel tanggal1;
    private javax.swing.JLabel time;
    private javax.swing.JLabel time1;
    // End of variables declaration//GEN-END:variables
}
