package tampilan;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Data_Barang extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public Map param = new HashMap();
    
    private File f;
    public Image gbr = null;
    
    protected void DataTable(){
        Object[] baris = {"Kode Barang", "Nama Barang","Kategori"
                ,"Gambar","Harga Beli","Harga Jual","Jumlah"};
        tabmode = new DefaultTableModel(null, baris);
        tbldata.setModel(tabmode);
        String sql = "select * from databarang";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery (sql);
            while (hasil.next()){
                String a = hasil.getString("kd_barang"); //isi tabel database
                String b = hasil.getString("nm_barang");
                String c = hasil.getString("kategori");
                String d = hasil.getString("gambar");
                String e = hasil.getString("hrg_beli");
                String f = hasil.getString("hrg_jual");
                String g = hasil.getString("jumlah");
 
                String[]data = {a,b,c,d,e,f,g};
                tabmode.addRow(data);
            }
        } catch (Exception e){
        }
    }
    
    public void kodebarang(){
        try{
            String sql = "select kd_barang from databarang order by kd_barang desc";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    String kode = rs.getString("kd_barang").substring(2);
                    String AN = ""+(Integer.parseInt(kode)+1);
                    String Nol = "";
                    
                    if(AN.length()==1){
                        Nol="000";
                    }else if(AN.length()==2){
                        Nol="00";
                    }else if(AN.length()==3){
                        Nol="0";
                     }else if(AN.length()==4){
                        Nol="";
                     }
                    kdbarang.setText("KD" + Nol + AN);
                }else{
                    kdbarang.setText("KD0001");
                }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    protected void kosong() {
        nmbarang.setText("");
        kategori.setText("");
        hargabeli.setText("");
        hargajual.setText("");
        jumlah.setValue(Integer.valueOf(0));
        txtgambar.setText("");
        lblgambar.setIcon(null);
    }
    
    public Data_Barang() {
        initComponents();
        kodebarang();
        DataTable();
        this.setLocationRelativeTo(null);
        Locale l = new Locale("id","ID");
        Locale.setDefault(l);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelGambar = new javax.swing.JPanel();
        lblgambar = new javax.swing.JLabel();
        txtgambar = new javax.swing.JTextField();
        pilih = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        cari = new javax.swing.JTextField();
        lblcari = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        kodebarang = new javax.swing.JLabel();
        namabarang = new javax.swing.JLabel();
        kat = new javax.swing.JLabel();
        hrgbeli = new javax.swing.JLabel();
        hrgjual = new javax.swing.JLabel();
        jml = new javax.swing.JLabel();
        jumlah = new javax.swing.JSpinner();
        hargajual = new javax.swing.JTextField();
        hargabeli = new javax.swing.JTextField();
        kategori = new javax.swing.JTextField();
        nmbarang = new javax.swing.JTextField();
        kdbarang = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btbatal = new javax.swing.JButton();
        btubah = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        bttambah = new javax.swing.JButton();
        beranda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        data = new javax.swing.JMenu();
        barang = new javax.swing.JMenuItem();
        pemasok = new javax.swing.JMenuItem();
        karyawan = new javax.swing.JMenuItem();
        transakso = new javax.swing.JMenu();
        jual = new javax.swing.JMenuItem();
        beli = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        dBarang = new javax.swing.JMenuItem();
        dKaryawan = new javax.swing.JMenuItem();
        dPelanggan = new javax.swing.JMenuItem();
        transaksi = new javax.swing.JMenu();
        tBeli = new javax.swing.JMenuItem();
        tJual = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));
        setPreferredSize(new java.awt.Dimension(1028, 575));

        jPanel1.setBackground(new java.awt.Color(27, 152, 154));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 575));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelGambar.setBackground(new java.awt.Color(18, 1, 54));
        PanelGambar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        PanelGambar.setForeground(new java.awt.Color(0, 102, 204));

        lblgambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        txtgambar.setBackground(new java.awt.Color(255, 255, 255));
        txtgambar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgambarActionPerformed(evt);
            }
        });

        pilih.setText("Pilih Gambar");
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelGambarLayout = new javax.swing.GroupLayout(PanelGambar);
        PanelGambar.setLayout(PanelGambarLayout);
        PanelGambarLayout.setHorizontalGroup(
            PanelGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtgambar)
            .addComponent(pilih, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
            .addComponent(lblgambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelGambarLayout.setVerticalGroup(
            PanelGambarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelGambarLayout.createSequentialGroup()
                .addComponent(lblgambar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtgambar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(PanelGambar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, -1, 246));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbldata.setBackground(new java.awt.Color(64, 186, 213));
        tbldata.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbldata.setForeground(new java.awt.Color(0, 0, 0));
        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Nama Barang", "Kategori", "Gambar", "Harga Beli", "Harga Jual", "Jumlah"
            }
        ));
        tbldata.setGridColor(new java.awt.Color(64, 186, 213));
        tbldata.setOpaque(false);
        tbldata.setSelectionBackground(new java.awt.Color(18, 1, 54));
        tbldata.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbldata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 371, 880, 140));

        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });
        jPanel1.add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(805, 340, 150, 22));

        lblcari.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        lblcari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/icons8_Search_18px.png"))); // NOI18N
        jPanel1.add(lblcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 28, 20));

        jPanel2.setBackground(new java.awt.Color(18, 1, 54));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kodebarang.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        kodebarang.setForeground(new java.awt.Color(255, 255, 255));
        kodebarang.setText("Kode Barang");
        jPanel2.add(kodebarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, 20));

        namabarang.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        namabarang.setForeground(new java.awt.Color(255, 255, 255));
        namabarang.setText("Nama Barang");
        jPanel2.add(namabarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 22));

        kat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        kat.setForeground(new java.awt.Color(255, 255, 255));
        kat.setText("Kategori");
        jPanel2.add(kat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 22));

        hrgbeli.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        hrgbeli.setForeground(new java.awt.Color(255, 255, 255));
        hrgbeli.setText("Harga Beli");
        jPanel2.add(hrgbeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 22));

        hrgjual.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        hrgjual.setForeground(new java.awt.Color(255, 255, 255));
        hrgjual.setText("Harga Jual");
        jPanel2.add(hrgjual, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 22));

        jml.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jml.setForeground(new java.awt.Color(255, 255, 255));
        jml.setText("Jumlah");
        jPanel2.add(jml, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 22));
        jPanel2.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 55, -1));

        hargajual.setBackground(new java.awt.Color(255, 255, 255));
        hargajual.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(hargajual, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 120, 22));

        hargabeli.setBackground(new java.awt.Color(255, 255, 255));
        hargabeli.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(hargabeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 120, 22));

        kategori.setBackground(new java.awt.Color(255, 255, 255));
        kategori.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 160, 22));

        nmbarang.setBackground(new java.awt.Color(255, 255, 255));
        nmbarang.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(nmbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 280, 22));

        kdbarang.setBackground(new java.awt.Color(255, 255, 255));
        kdbarang.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jPanel2.add(kdbarang, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 100, 22));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 430, 246));

        jPanel3.setBackground(new java.awt.Color(18, 1, 54));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setForeground(new java.awt.Color(18, 1, 54));

        btbatal.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btbatal.setText("Batal");
        btbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbatalActionPerformed(evt);
            }
        });

        btubah.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btubah.setText("Ubah");
        btubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btubahActionPerformed(evt);
            }
        });

        bthapus.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        bthapus.setText("Hapus");
        bthapus.setPreferredSize(new java.awt.Dimension(57, 28));
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });

        bttambah.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        beranda.setText("Beranda");
        beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                berandaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bttambah, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(btbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(beranda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btubah, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bthapus, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btubah)
                    .addComponent(bthapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btbatal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(beranda, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 170, 178));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/DataBarangpsd.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1035, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        data.setBackground(new java.awt.Color(0, 153, 204));
        data.setText("Data ");

        barang.setBackground(new java.awt.Color(255, 255, 255));
        barang.setText("Data Barang");
        barang.setEnabled(false);
        barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangActionPerformed(evt);
            }
        });
        data.add(barang);

        pemasok.setBackground(new java.awt.Color(255, 255, 255));
        pemasok.setText("Data Pemasok");
        pemasok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pemasokActionPerformed(evt);
            }
        });
        data.add(pemasok);

        karyawan.setBackground(new java.awt.Color(255, 255, 255));
        karyawan.setText("Data Karyawan");
        karyawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                karyawanActionPerformed(evt);
            }
        });
        data.add(karyawan);

        jMenuBar1.add(data);

        transakso.setBackground(new java.awt.Color(0, 153, 204));
        transakso.setText("Transaksi");

        jual.setBackground(new java.awt.Color(255, 255, 255));
        jual.setText("Penjualan");
        jual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jualActionPerformed(evt);
            }
        });
        transakso.add(jual);

        beli.setBackground(new java.awt.Color(255, 255, 255));
        beli.setText("Pembelian");
        beli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliActionPerformed(evt);
            }
        });
        transakso.add(beli);

        jMenuBar1.add(transakso);

        jMenu2.setBackground(new java.awt.Color(0, 153, 204));
        jMenu2.setText("Laporan");

        jMenu3.setText("Data");

        dBarang.setText("Barang");
        dBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dBarangActionPerformed(evt);
            }
        });
        jMenu3.add(dBarang);

        dKaryawan.setText("Karyawan");
        dKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dKaryawanActionPerformed(evt);
            }
        });
        jMenu3.add(dKaryawan);

        dPelanggan.setText("Pelanggan");
        dPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dPelangganActionPerformed(evt);
            }
        });
        jMenu3.add(dPelanggan);

        jMenu2.add(jMenu3);

        transaksi.setText("Transaksi");

        tBeli.setText("Beli");
        tBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBeliActionPerformed(evt);
            }
        });
        transaksi.add(tBeli);

        tJual.setText("Jual");
        tJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJualActionPerformed(evt);
            }
        });
        transaksi.add(tJual);

        jMenu2.add(transaksi);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1028, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        JFileChooser j = new JFileChooser();
        j.showOpenDialog(null);
        f = j.getSelectedFile();
        String lokasi = f.getAbsolutePath();
        txtgambar.setText(lokasi);
        ImageIcon icon = new ImageIcon(lokasi);
        lblgambar.setIcon(icon);
    }//GEN-LAST:event_pilihActionPerformed

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
            String sql = "insert into databarang values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, kdbarang.getText());
            stat.setString(2, nmbarang.getText());
            stat.setString(3, kategori.getText());
            stat.setString(4, txtgambar.getText());
            stat.setInt(5,Integer.valueOf(hargabeli.getText()));
            stat.setInt(6,Integer.valueOf(hargajual.getText()));
            stat.setInt(7,Integer.valueOf(jumlah.getValue().toString()));
            
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");

            DataTable();
            kodebarang();
            kosong();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }//GEN-LAST:event_bttambahActionPerformed

    private void tbldataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldataMouseClicked
        int bar = tbldata.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 3).toString();
        String e = tabmode.getValueAt(bar, 4).toString();
        String f = tabmode.getValueAt(bar, 5).toString();
        String g = tabmode.getValueAt(bar, 6).toString();
        kdbarang.setText(a);
        nmbarang.setText(b);
        kategori.setText(c);
        txtgambar.setText(d);
        
        try{
            URL url = new URL("file:///"+d);
            gbr = ImageIO.read(url);
            lblgambar.setIcon(new ImageIcon(gbr));
        } catch(Exception ex) {
           System.out.println("ERROR NAMPILIN GAMBAR /n"+ex);
           lblgambar.setIcon(null);
        }
        
        hargabeli.setText(e);
        hargajual.setText(f);
        jumlah.setValue(Integer.valueOf(g));
        
    }//GEN-LAST:event_tbldataMouseClicked

    private void btubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btubahActionPerformed
        String sql = "update databarang set nm_barang=?, kategori=?, gambar=?,"
                + " hrg_beli=?, hrg_jual=?, jumlah=? where kd_barang='"+kdbarang.getText()+"'";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, nmbarang.getText());
            stat.setString(2, kategori.getText());
            stat.setString(3, txtgambar.getText());
            stat.setInt(4,Integer.valueOf(hargabeli.getText()));
            stat.setInt(5,Integer.valueOf(hargajual.getText()));
            stat.setInt(6,Integer.valueOf(jumlah.getValue().toString()));
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            kosong();
            nmbarang.requestFocus();
            DataTable();
            kodebarang();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah "+e);
        }
    }//GEN-LAST:event_btubahActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data?",
            "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "delete from databarang where kd_barang='"+kdbarang.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                nmbarang.requestFocus();
                DataTable();
                kodebarang();
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus "+e);
            }
        } else {
            kosong();
        }
    }//GEN-LAST:event_bthapusActionPerformed

    private void btbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbatalActionPerformed
        kosong();
        kodebarang();
    }//GEN-LAST:event_btbatalActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        Object [] baris = {"Kd Barang","Nama Barang","Kategori","Gambar","Harga Beli"
                + "Harga Jual","Jumlah"};
        tabmode = new DefaultTableModel(null, baris);
        tbldata.setModel(tabmode);
        String sql = "select * from databarang where kd_barang like '%"+cari.getText()+"%'"
                + "or nm_barang like '%"+cari.getText()+"%'"
                + "or kategori like '%"+cari.getText()+"%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                String a = hasil.getString("kd_barang");
                String b = hasil.getString("nm_barang");
                String c = hasil.getString("kategori");
                String d = hasil.getString("gambar");
                String e = hasil.getString("hrg_beli");
                String f = hasil.getString("hrg_jual");
                String g = hasil.getString("jumlah");
                String [] data = {a,b,c,d,e,f,g};
                tabmode.addRow(data);
            }
        }catch (Exception e){
        }
    }//GEN-LAST:event_cariKeyReleased

    private void berandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_berandaActionPerformed
        Menu m = new Menu();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_berandaActionPerformed

    private void txtgambarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgambarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgambarActionPerformed

    private void barangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangActionPerformed
        Data_Barang db = new Data_Barang();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_barangActionPerformed

    private void pemasokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pemasokActionPerformed
        Data_Pemasok dp = new Data_Pemasok();
        dp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_pemasokActionPerformed

    private void karyawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_karyawanActionPerformed
        Data_Karyawan dk = new Data_Karyawan();
        dk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_karyawanActionPerformed

    private void jualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jualActionPerformed
        Transaksi_Jual tj = new Transaksi_Jual();
        tj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jualActionPerformed

    private void beliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliActionPerformed
        Transaksi_Beli tb = new Transaksi_Beli();
        tb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_beliActionPerformed

    private void dBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dBarangActionPerformed
        try {
            File x = new File("src/Laporan/barang.jrxml");
            JasperReport y = JasperCompileManager.compileReport(x.getAbsolutePath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(y,param,conn);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Data Barang");
            jv.setVisible(true);
        }
        catch(Exception z) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan"+z);
        }
    }//GEN-LAST:event_dBarangActionPerformed

    private void dKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dKaryawanActionPerformed
        try {
            File x = new File("src/Laporan/karyawan.jrxml");
            JasperReport y = JasperCompileManager.compileReport(x.getAbsolutePath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(y,param,conn);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Data Karyawan");
            jv.setVisible(true);
        }
        catch(Exception z) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan"+z);
        }
    }//GEN-LAST:event_dKaryawanActionPerformed

    private void dPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dPelangganActionPerformed
        try {
            File x = new File("src/Laporan/pelanggan.jrxml");
            JasperReport y = JasperCompileManager.compileReport(x.getAbsolutePath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(y,param,conn);
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("Data Pelanggan");
            jv.setVisible(true);
        }
        catch(Exception z) {
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan"+z);
        }
    }//GEN-LAST:event_dPelangganActionPerformed

    private void tBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBeliActionPerformed
        periode n = new periode();
        n.settransaksi("beli");
        n.setVisible(true);
    }//GEN-LAST:event_tBeliActionPerformed

    private void tJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJualActionPerformed
        periode n = new periode();
        n.settransaksi("jual");
        n.setVisible(true);
    }//GEN-LAST:event_tJualActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Data_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Data_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Data_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Data_Barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Data_Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelGambar;
    private javax.swing.JMenuItem barang;
    private javax.swing.JMenuItem beli;
    private javax.swing.JButton beranda;
    private javax.swing.JButton btbatal;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton btubah;
    private javax.swing.JTextField cari;
    private javax.swing.JMenuItem dBarang;
    private javax.swing.JMenuItem dKaryawan;
    private javax.swing.JMenuItem dPelanggan;
    private javax.swing.JMenu data;
    private javax.swing.JTextField hargabeli;
    private javax.swing.JTextField hargajual;
    private javax.swing.JLabel hrgbeli;
    private javax.swing.JLabel hrgjual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jml;
    private javax.swing.JMenuItem jual;
    private javax.swing.JSpinner jumlah;
    private javax.swing.JMenuItem karyawan;
    private javax.swing.JLabel kat;
    private javax.swing.JTextField kategori;
    private javax.swing.JTextField kdbarang;
    private javax.swing.JLabel kodebarang;
    private javax.swing.JLabel lblcari;
    private javax.swing.JLabel lblgambar;
    private javax.swing.JLabel namabarang;
    private javax.swing.JTextField nmbarang;
    private javax.swing.JMenuItem pemasok;
    private javax.swing.JButton pilih;
    private javax.swing.JMenuItem tBeli;
    private javax.swing.JMenuItem tJual;
    private javax.swing.JTable tbldata;
    private javax.swing.JMenu transaksi;
    private javax.swing.JMenu transakso;
    private javax.swing.JTextField txtgambar;
    // End of variables declaration//GEN-END:variables
}
