package tampilan;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Transaksi_Jual extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    public Map param = new HashMap();
    DataBarang dialog;
    int totalBiaya = 0;
    
    public void NomorFaktur(){
        try{
            String sql = "SELECT nomor FROM transaksi_jual ORDER BY nomor DESC";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    String kode = rs.getString("nomor").substring(2);
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
                    txtno.setText("NO" + Nol + AN);
                }else{
                    txtno.setText("NO0001");
                }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void IdPelanggan(){
        try{
            String sql = "SELECT id_pelanggan FROM datapelanggan ORDER BY id_pelanggan DESC";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(sql);
                if(rs.next()){
                    String kode = rs.getString("id_pelanggan").substring(2);
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
                    txtid.setText("ID" + Nol + AN);
                }else{
                    txtid.setText("ID0001");
                }   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    protected void DataTableTransaksi(){
        Object[] baris = {"Nomor","Kode Barang","Nama Barang","Harga","Jumlah"
                ,"Id Pemasok","Nama Pemasok","Tanggal"};
        tabmode = new DefaultTableModel(null, baris);
        tblpesan.setModel(tabmode);
        String sql = "SELECT t.nomor, t.kd_barang, t.tanggal, t.jumlah, b.nm_barang, "
                    + "b.hrg_jual, t.id_pelanggan, p.nm_pelanggan "
                    + "FROM transaksi_jual AS t, databarang AS b, datapelanggan AS p "
                    + "WHERE t.kd_barang = b.kd_barang AND t.id_pelanggan = p.id_pelanggan "
                    + "AND t.nomor = '"+txtno.getText()+"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery (sql);
            while (hasil.next()){
                String a = hasil.getString("nomor"); //isi tabel database
                String b = hasil.getString("kd_barang");
                String c = hasil.getString("nm_barang");
                String d = hasil.getString("hrg_jual");
                String e = hasil.getString("jumlah");
                String f = hasil.getString("id_pelanggan");
                String g = hasil.getString("nm_pelanggan");
                String h = hasil.getString("tanggal");
                
                String[]data = {a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void kosong(){
        txtkode.setText("");
        txtnamabarang.setText("");
        tanggal.setDate(null);
        jumlah.setValue(Integer.valueOf(0));
        harga.setText("");
    }
    
    public Transaksi_Jual() {
        initComponents();
        NomorFaktur();
        IdPelanggan();
        DataTableTransaksi();
        dialog = new DataBarang(this,true);
        this.setLocationRelativeTo(null);
        Total();
        harga.hide();
        Locale l = new Locale("id","ID");
        Locale.setDefault(l);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblpesan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        kode = new javax.swing.JLabel();
        txtkode = new javax.swing.JLabel();
        pilihbarang = new javax.swing.JButton();
        namabarang = new javax.swing.JLabel();
        txtnamabarang = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        txtjumlah = new javax.swing.JLabel();
        jumlah = new javax.swing.JSpinner();
        bttambah = new javax.swing.JButton();
        btbatal = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        id = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        nama = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        notelp = new javax.swing.JLabel();
        txttelp = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtnama1 = new javax.swing.JLabel();
        btubah = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        btcetak = new javax.swing.JButton();
        txtno = new javax.swing.JLabel();
        txtkembali = new javax.swing.JLabel();
        txttotal = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        harga = new javax.swing.JLabel();
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
        setSize(new java.awt.Dimension(1035, 524));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 152, 154));
        jPanel1.setPreferredSize(new java.awt.Dimension(1035, 524));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblpesan.setBackground(new java.awt.Color(64, 186, 213));
        tblpesan.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tblpesan.setForeground(new java.awt.Color(0, 0, 0));
        tblpesan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Kode", "Barang", "Harga", "Jumlah", "Id", "Nama", "Tanggal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblpesan.setGridColor(new java.awt.Color(64, 186, 213));
        tblpesan.setSelectionBackground(new java.awt.Color(18, 1, 54));
        tblpesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblpesanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblpesan);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 570, 180));

        jPanel2.setBackground(new java.awt.Color(18, 1, 54));

        kode.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        kode.setForeground(new java.awt.Color(255, 255, 255));
        kode.setText("Kode");

        txtkode.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtkode.setForeground(new java.awt.Color(255, 255, 255));
        txtkode.setText("Kode");

        pilihbarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        pilihbarang.setText("Pilih");
        pilihbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihbarangActionPerformed(evt);
            }
        });

        namabarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        namabarang.setForeground(new java.awt.Color(255, 255, 255));
        namabarang.setText("NAMA BARANG");

        txtnamabarang.setBackground(new java.awt.Color(0, 0, 0));
        txtnamabarang.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtnamabarang.setForeground(new java.awt.Color(255, 255, 255));
        txtnamabarang.setText("NAMA BARANG");

        tgl.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setText("Tanggal");

        tanggal.setBackground(new java.awt.Color(255, 255, 255));
        tanggal.setForeground(new java.awt.Color(0, 0, 0));

        txtjumlah.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtjumlah.setForeground(new java.awt.Color(255, 255, 255));
        txtjumlah.setText("Jumlah");

        jumlah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N

        bttambah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bttambah.setText("Tambah");
        bttambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttambahActionPerformed(evt);
            }
        });

        btbatal.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btbatal.setText("Batal");
        btbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pilihbarang)
                        .addContainerGap(106, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tgl)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnamabarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bttambah)
                                .addGap(18, 18, 18)
                                .addComponent(btbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamabarang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bttambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 410, 170));

        jPanel3.setBackground(new java.awt.Color(18, 1, 54));

        id.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("ID");

        txtid.setBackground(new java.awt.Color(255, 255, 255));
        txtid.setForeground(new java.awt.Color(0, 0, 0));

        nama.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("Nama");

        txtnama.setBackground(new java.awt.Color(255, 255, 255));
        txtnama.setForeground(new java.awt.Color(0, 0, 0));

        notelp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        notelp.setForeground(new java.awt.Color(255, 255, 255));
        notelp.setText("No. Telepon");

        txttelp.setBackground(new java.awt.Color(255, 255, 255));
        txttelp.setForeground(new java.awt.Color(0, 0, 0));

        btntambah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        jButton1.setText("Baru");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(notelp)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntambah)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notelp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btntambah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 115, 370, 175));

        txtnama1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        txtnama1.setForeground(new java.awt.Color(0, 0, 0));
        txtnama1.setText("Total Bayar");
        jPanel1.add(txtnama1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 372, 70, 22));

        btubah.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btubah.setText("Ubah");
        btubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btubahActionPerformed(evt);
            }
        });
        jPanel1.add(btubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 78, 30));

        bthapus.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        bthapus.setText("Hapus");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });
        jPanel1.add(bthapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 78, 30));

        btcetak.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btcetak.setText("Cetak");
        btcetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcetakActionPerformed(evt);
            }
        });
        jPanel1.add(btcetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 420, 78, 70));

        txtno.setForeground(new java.awt.Color(0, 0, 0));
        txtno.setText("NO");
        jPanel1.add(txtno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtkembali.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtkembali.setForeground(new java.awt.Color(255, 0, 0));
        txtkembali.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txtkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 450, 120, 40));

        txttotal.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        txttotal.setForeground(new java.awt.Color(255, 0, 0));
        txttotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(txttotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 360, 200, 50));

        bayar.setBackground(new java.awt.Color(255, 255, 255));
        bayar.setForeground(new java.awt.Color(0, 0, 0));
        bayar.setBorder(null);
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });
        jPanel1.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 120, 22));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bayar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, -1, 22));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Kembali");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, -1, 22));
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, 100, 20));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background/TransaksiJual.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        data.setBackground(new java.awt.Color(0, 153, 204));
        data.setText("Data ");

        barang.setBackground(new java.awt.Color(255, 255, 255));
        barang.setText("Data Barang");
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
        jual.setEnabled(false);
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btcetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcetakActionPerformed
        Map param = new HashMap();
        param.put("no", txtno.getText());
        param.put("nama", txtnama.getText());
        try {
                File x = new File("src/Laporan/nota.jrxml");
                JasperReport y = JasperCompileManager.compileReport(x.getAbsolutePath());
                JasperPrint jasperPrint = JasperFillManager.fillReport(y, param, conn);
                JasperViewer jv = new JasperViewer(jasperPrint, false);
                jv.setTitle("Nota Transaksi ");
                jv.setVisible(true);
            }
            catch(Exception z) {
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Laporan"+z);
            }
    }//GEN-LAST:event_btcetakActionPerformed

    private void pilihbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihbarangActionPerformed
        dialog.setVisible(true);
        txtkode.setText(dialog.kode);
        txtnamabarang.setText(dialog.barang);
        harga.setText(dialog.hrga);
        //databarang.setSize(430,472);
        //databarang.setVisible(true);
    }//GEN-LAST:event_pilihbarangActionPerformed

    private void bttambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttambahActionPerformed
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
        String tgl = ft.format(tanggal.getDate());
           String sql = "INSERT INTO transaksi_jual VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtno.getText());
            stat.setString(2, txtkode.getText());
            stat.setString(3, txtid.getText());
            stat.setInt(4,Integer.valueOf(jumlah.getValue().toString()));
            stat.setString(5, tgl);
            int subtotal;
            subtotal = Integer.parseInt(harga.getText())*Integer.valueOf(jumlah.getValue().toString());
            stat.setInt(6, subtotal);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            kosong();
            DataTableTransaksi();
            Total();
            totalBiaya=0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }//GEN-LAST:event_bttambahActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        String sql = "INSERT INTO datapelanggan VALUES (?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtid.getText());
            stat.setString(2, txtnama.getText());
            stat.setString(3, txttelp.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            DataTableTransaksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        }
    }//GEN-LAST:event_btntambahActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        int ok = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data?",
            "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if(ok==0){
            String sql = "DELETE FROM transaksi_jual WHERE nomor='"+txtno.getText()+"' AND "
                    + "kd_barang='"+txtkode.getText()+"'";
            try {
                System.out.println(sql);
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                DataTableTransaksi();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                kosong();
                //int i = tbltransaksi.getSelectedRow();
                //tbltransaksi.remove(i);
                DefaultTableModel dataModel = (DefaultTableModel) tblpesan.getModel();
                int jumlahBaris = tblpesan.getRowCount();

                int jumlahBarang, hargaBarang;
                totalBiaya=0;
                for (int i=0; i<jumlahBaris; i++){
                    hargaBarang = Integer.parseInt(dataModel.getValueAt(i, 3).toString());
                    jumlahBarang = Integer.parseInt(dataModel.getValueAt(i, 4).toString());
                    totalBiaya = totalBiaya + (jumlahBarang*hargaBarang);
                }
                txttotal.setText(String.valueOf(totalBiaya));
                } catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus "+e);
                    e.printStackTrace();
                }
        } else {
            kosong();
        }
    }//GEN-LAST:event_bthapusActionPerformed

    private void btbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbatalActionPerformed
        kosong();
    }//GEN-LAST:event_btbatalActionPerformed

    private void btubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btubahActionPerformed
        String sql = "UPDATE transaksi_jual SET nomor=?, kd_barang=?, id_pelanggan=?, jumlah=?, "
                + "tanggal=?, subtotal=? WHERE nomor='"+txtno.getText()+"' AND "
                + "kd_barang='"+txtkode.getText()+"' ";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, txtno.getText());
            stat.setString(2, txtkode.getText());
            stat.setString(3, txtid.getText());
            stat.setInt(4, Integer.valueOf(jumlah.getValue().toString()));
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
            String tgl = ft.format(tanggal.getDate());
            stat.setString(5,tgl);
            int subtotal;
            subtotal = Integer.parseInt(harga.getText())*Integer.valueOf(jumlah.getValue().toString());
            stat.setInt(6, subtotal);
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            kosong();
            DataTableTransaksi();
            Total();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah "+e);
        }
        DataTableTransaksi();
    }//GEN-LAST:event_btubahActionPerformed

    private void tblpesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblpesanMouseClicked
        int bar = tblpesan.getSelectedRow();
        String a = tabmode.getValueAt(bar, 0).toString();
        String b = tabmode.getValueAt(bar, 1).toString();
        String c = tabmode.getValueAt(bar, 2).toString();
        String d = tabmode.getValueAt(bar, 5).toString();
        String e = tabmode.getValueAt(bar, 6).toString();
        String g = tabmode.getValueAt(bar, 3).toString();
        txtno.setText(a);
        txtkode.setText(b);
        txtnamabarang.setText(c);
        txtid.setText(d);
        txtnama.setText(e);
        harga.setText(g);
        
    }//GEN-LAST:event_tblpesanMouseClicked

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        double uang,kembalian,total;
        total = Double.parseDouble(txttotal.getText());
        uang = Double.parseDouble(bayar.getText());
        kembalian = uang - total;
        int a = (int)kembalian;
        txtkembali.setText(String.valueOf(a));
        
    }//GEN-LAST:event_bayarKeyReleased

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IdPelanggan();
        txtnama.setText("");
        txttelp.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Total(){
        DefaultTableModel dataModel = (DefaultTableModel) tblpesan.getModel();
        int jumlahBaris = tblpesan.getRowCount();
        
        int jumlahBarang, hargaBarang;
  
        for (int i=0; i<jumlahBaris; i++){
            hargaBarang = Integer.parseInt(dataModel.getValueAt(i, 3).toString());
            jumlahBarang = Integer.parseInt(dataModel.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahBarang*hargaBarang);
        }
        txttotal.setText(String.valueOf(totalBiaya));
    }

         
    
    
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
            java.util.logging.Logger.getLogger(Transaksi_Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_Jual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_Jual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem barang;
    private javax.swing.JTextField bayar;
    private javax.swing.JMenuItem beli;
    private javax.swing.JButton btbatal;
    private javax.swing.JButton btcetak;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton bttambah;
    private javax.swing.JButton btubah;
    private javax.swing.JMenuItem dBarang;
    private javax.swing.JMenuItem dKaryawan;
    private javax.swing.JMenuItem dPelanggan;
    private javax.swing.JMenu data;
    private javax.swing.JLabel harga;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem jual;
    private javax.swing.JSpinner jumlah;
    private javax.swing.JMenuItem karyawan;
    private javax.swing.JLabel kode;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel namabarang;
    private javax.swing.JLabel notelp;
    private javax.swing.JMenuItem pemasok;
    private javax.swing.JButton pilihbarang;
    private javax.swing.JMenuItem tBeli;
    private javax.swing.JMenuItem tJual;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTable tblpesan;
    private javax.swing.JLabel tgl;
    private javax.swing.JMenu transaksi;
    private javax.swing.JMenu transakso;
    private javax.swing.JTextField txtid;
    private javax.swing.JLabel txtjumlah;
    private javax.swing.JLabel txtkembali;
    private javax.swing.JLabel txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JLabel txtnama1;
    private javax.swing.JLabel txtnamabarang;
    private javax.swing.JLabel txtno;
    private javax.swing.JTextField txttelp;
    private javax.swing.JLabel txttotal;
    // End of variables declaration//GEN-END:variables
}
