package com.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import org.w3c.dom.events.MouseEvent;

import com.partials.cBigFonts;
import com.partials.cColors;
import com.partials.cFormLabel;
import com.partials.cGreenButton;
import com.partials.cLabelInfo;
import com.partials.cRadioButton;
import com.partials.cScrollPane;
import com.partials.cSidebarMenu;
import com.partials.cTable;
import com.partials.cTextFields;
import com.program.Model;
import com.templates.cDashboardFrame;

public class DashboardView extends cDashboardFrame {

    Integer idUser = null;
    Integer idSelected = null;

    //sidebar menu
    private cSidebarMenu menuBeranda = new cSidebarMenu("Beranda", 70);
    private cSidebarMenu menuKeuangan = new cSidebarMenu("Keuangan", 70 + 50);
    private cSidebarMenu menuBarang = new cSidebarMenu("Barang", 70+50+50);
    private cSidebarMenu menuLogOut = new cSidebarMenu("Logout", 70+50+50+50);

    //komponen beranda
    private cLabelInfo labelJumlahItemBarang = new cLabelInfo("Jumlah item barang", 25, 20);
    private cBigFonts valueJumlahItemBarang = new cBigFonts("0", 25, 60);

    private cLabelInfo labelJumlahTotalBarang = new cLabelInfo("Jumlah total barang", 25, 150);
    private cBigFonts valueJumlahTotalBarang = new cBigFonts("0", 25, 190);

    private cLabelInfo labelTotalKas = new cLabelInfo("Total kas", 25, 280);
    private cBigFonts valueTotalKas = new cBigFonts("0", 25, 320);

    private cLabelInfo labelJumlahTotalOmset = new cLabelInfo("Jumlah total omset", 495, 20);
    private cBigFonts valueJumlahTotalOmset = new cBigFonts("0", 495, 60);

    private cLabelInfo labelJumlahBarangExpired = new cLabelInfo("Jumlah barang expired", 495, 150);
    private cBigFonts valueJumlahBarangExpired = new cBigFonts("0", 495, 190);

    private cGreenButton editKasButton = new cGreenButton("Edit kas",130,283,169);

    //komponent edit kas
    private cFormLabel labelKas = new cFormLabel("Masukan jumlah dana kas baru",25,20,300,false,cColors.BLACK);
    private cTextFields txtEditKas = new cTextFields(25,60,300,false);
    private cGreenButton btnEditKas = new cGreenButton("Simpan",840,470,110);

    //komponen keuangan
    private cLabelInfo labelTotalDebet = new cLabelInfo("Total Debet : ", 25, 470);
    private cLabelInfo labelValueDebet = new cLabelInfo(" 0 ", 163, 470);
    private cLabelInfo labelTotalKredit = new cLabelInfo("Total Kredit : ", 300, 470);
    private cLabelInfo labelValueKredit = new cLabelInfo(" 0 " , 430, 470);
    private cTable tblDataKeuangan;
    private cScrollPane spDataKeuangan;
    private cGreenButton btnTambahDataKeuangan = new cGreenButton("tambah", 600, 470, 110);
    private cGreenButton btnHapusDataKeuangan = new cGreenButton("Hapus", 720, 470, 110);
    private cGreenButton btnEditDataKeuangan = new cGreenButton("Edit", 840, 470, 110);

    //komponent edit keuangan
    private cFormLabel labelTanggal = new cFormLabel("Masukan tanggal",25,20,300,false,cColors.BLACK);
    private cTextFields txtEditTanggal = new cTextFields(25,60,300,false);

    private cFormLabel labelJumlahUang = new cFormLabel("Masukan Jumlah uang",25,100,300,false,cColors.BLACK);
    private cTextFields txtEditJumlahUang = new cTextFields(25,135,300,false);

    private cRadioButton rdDebet = new cRadioButton("Debet","debet",25, 180, 80);
    private cRadioButton rdKredit = new cRadioButton("Kredit","kredit",40, 180, 190);
    private javax.swing.ButtonGroup rdPilihanDebetKredit = new javax.swing.ButtonGroup();

    private cFormLabel labelKeteranganSingkat = new cFormLabel("Masukan Keterangan singkat",25,210,300,false,cColors.BLACK);
    private cTextFields txtEditKeteranganSingkat = new cTextFields(25,240,300,false);

    private cGreenButton btnSimpanKeuangan = new cGreenButton("simpan",840,470,110);

    //komponen barang
    private cLabelInfo labelTotalCash = new cLabelInfo("Total Cash : ", 25, 470);
    private cLabelInfo labelValueCash = new cLabelInfo(" 0 ", 155, 470);
    private cLabelInfo labelTotalKreditBrg = new cLabelInfo("Total Kredit : ", 300, 470);
    private cLabelInfo labelValueKreditBrg = new cLabelInfo(" 0 " , 435, 470);
    private cTable tblDataBarang;
    private cScrollPane spDataBarang;
    private cGreenButton btnTambahDataBarang = new cGreenButton("tambah", 600, 470, 110);
    private cGreenButton btnHapusDataBarang = new cGreenButton("Hapus", 720, 470, 110);
    private cGreenButton btnEditDataBarang = new cGreenButton("Edit", 840, 470, 110);

    //komponent edit barang
    private cFormLabel labelTanggalEXPBrg = new cFormLabel("Masukan expired",25,20,300,false,cColors.BLACK);
    private cTextFields txtEditTanggalEXPBrg = new cTextFields(25,60,300,false);

    private cFormLabel labelHargaBrg = new cFormLabel("Masukan harga satuan barang",400,20,300,false,cColors.BLACK);
    private cTextFields txtEditHargaBrg = new cTextFields(400,60,300,false);

    private cFormLabel labelNamaBarang = new cFormLabel("Masukan nama barang",25,100,300,false,cColors.BLACK);
    private cTextFields txtEditNamaBarang = new cTextFields(25,135,300,false);

    private cFormLabel labelStokSatuan = new cFormLabel("Masukan jumlah stok satuan",400,100,300,false,cColors.BLACK);
    private cTextFields txtEditStokBarang = new cTextFields(400,135,300,false);

    private cRadioButton rdCash = new cRadioButton("cash","cash",25, 180, 80);
    private cRadioButton rdKreditBrg = new cRadioButton("kredit","kredit",40, 180, 190);
    private javax.swing.ButtonGroup rdPilihanCashKredit = new javax.swing.ButtonGroup();

    private cFormLabel labelKeteranganSingkatBrg = new cFormLabel("Masukan Keterangan singkat",25,210,300,false,cColors.BLACK);
    private cTextFields txtEditKeteranganSingkatBrg = new cTextFields(25,240,300,false);

    private cGreenButton btnSimpanBarang = new cGreenButton("simpan",840,470,110);

    //method reset sidebar
    private void resetSideBar(){

        try {

            setVisible(false);
            menuBeranda.setForeground(cColors.RED);
            menuBeranda.setBackground(cColors.YELLOW);
            menuBeranda.setSideBarnonAktif();

            menuKeuangan.setForeground(cColors.RED);
            menuKeuangan.setBackground(cColors.YELLOW);
            menuKeuangan.setSideBarnonAktif();

            menuKeuangan.setForeground(cColors.RED);
            menuKeuangan.setBackground(cColors.YELLOW);
            menuKeuangan.setSideBarnonAktif();

            menuLogOut.setSideBarnonAktif();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     //method refresh content
    private void refreshContent(){
        
        try {
            String nama = Model.getDetailUser(idUser)[1].toString();
            String jabatan = Model.getDetailUser(idUser)[2].toString();
            RoleText.setText(nama + " | " + jabatan);
            content.removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public DashboardView(Integer id){

        super("Dashboard User");
        this.idUser = id;

        String nama = Model.getDetailUser(idUser)[1].toString();
        String jabatan = Model.getDetailUser(idUser)[2].toString();

        RoleText.setText(nama + " | " + jabatan);

        menuBeranda.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                initsBeranda();
            }

        });

        menuKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                initsKeuangan();
            }

        });

        menuBarang.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                initsBarang();
            }

        });

        menuLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Object[] options = { "YA", "BATAL" };
                int confirm = JOptionPane.showOptionDialog(null, "Yakin ingin logout?", "Logout",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
                if(confirm == 0 ){
                  idUser = null;
                  idSelected = null;
                  com.program.Controller.showLoginUser();
                }
            }
            
        });

        sideBar.add(menuBeranda);
        sideBar.add(menuKeuangan);
        sideBar.add(menuBarang);
        sideBar.add(menuLogOut);

        rdPilihanDebetKredit.add(rdDebet);
        rdPilihanDebetKredit.add(rdKredit);
        rdPilihanCashKredit.add(rdCash);
        rdPilihanCashKredit.add(rdKreditBrg);

        initsBeranda();

    }

    private void initsBeranda(){

        idSelected = null;
        resetSideBar();
        menuBeranda.setForeground(cColors.WHITE);
        menuBeranda.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("beranda");

        valueJumlahItemBarang.setText(String.valueOf(Model.getCountAllBrg()));
        valueJumlahTotalBarang.setText(String.valueOf(Model.getCountAllTotalBrg()));
        valueJumlahBarangExpired.setText(String.valueOf(Model.getCountExpBrgAktif()));
        valueTotalKas.setText(String.valueOf(Model.getDetailUser(idUser)[3]));

        menuBeranda.setSideBarAktif();
        content.add(labelJumlahItemBarang);
        content.add(valueJumlahItemBarang);
        content.add(labelJumlahTotalBarang);
        content.add(valueJumlahTotalBarang);
        content.add(labelTotalKas);

        content.add(editKasButton); 
        editKasButton.addActionListener(new java.awt.event.ActionListener() {
           
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initsEditKas();
            }

        });

        content.add(valueTotalKas);
        content.add(labelJumlahTotalOmset);
        content.add(valueJumlahTotalOmset);
        content.add(labelJumlahBarangExpired);
        content.add(valueJumlahBarangExpired);
        setVisible(true);

    }

    public void initsEditKas(){

        idSelected = null;
        resetSideBar();
        menuBeranda.setForeground(cColors.WHITE);
        menuBeranda.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("beranda");

        btnEditKas.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                double totalKas = Double.valueOf(txtEditKas.getText());

                if (totalKas == 0) {
                    JOptionPane.showMessageDialog(DashboardView.this,"Isi jumlah kas terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    
                    if (Model.editKas(totalKas, idUser)) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Berhasil mengubah jumlah kas","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                        //valueTotalKas.setText(String.valueOf(totalKas));
                        initsBeranda();
                    }
                    else{
                    JOptionPane.showMessageDialog(DashboardView.this,"Error dalam mengubah kas","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    
                }

            }
            
        });

        menuBeranda.setSideBarAktif();
        content.add(labelKas);
        content.add(txtEditKas);
        content.add(btnEditKas);

        setVisible(true);

    }

    private void initsKeuangan(){
        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Keuangan");


        tblDataKeuangan = new cTable(Model.getAllDataKeuangan());

        tblDataKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int selectedIndex = tblDataKeuangan.getSelectedRow();
                int idKeuangan = Integer.parseInt(tblDataKeuangan.getValueAt(selectedIndex, 0).toString());
                
            }

        });

        tblDataKeuangan.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(0).setWidth(0);

        tblDataKeuangan.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(5).setWidth(0);


        spDataKeuangan = new cScrollPane(tblDataKeuangan,25, 65, 740, 310);

        labelValueDebet.setText(String.valueOf(Model.getJumlahKeuDebet()));
        labelValueKredit.setText(String.valueOf(Model.getJumlahKeuKredit()));

        menuKeuangan.setSideBarAktif();
        content.add(labelTotalDebet); 
        content.add(labelValueDebet);
        content.add(labelTotalKredit);
        content.add(labelValueKredit);
        content.add(spDataKeuangan);
        
        content.add(btnTambahDataKeuangan);
        btnTambahDataKeuangan.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initsTambahKeuangan();
            }
            
        });

        content.add(btnHapusDataKeuangan);
        btnHapusDataKeuangan.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selectedIndex = tblDataKeuangan.getSelectedRow();

                if (selectedIndex != -1) {

                    int idKeuangan = Integer.parseInt(tblDataKeuangan.getValueAt(selectedIndex, 0).toString());

                    if (Model.hapusDataKeuangan(idKeuangan)) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Berhasil menghapus data","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                        initsKeuangan();   
                    }
                    else{
                        JOptionPane.showMessageDialog(DashboardView.this, "Pilih tabel terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }

                }
                else{
                    JOptionPane.showMessageDialog(DashboardView.this, "Pilih tabel terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                }

            }

        });
        
        content.add(btnEditDataKeuangan);
        btnEditDataKeuangan.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                
                int selectedIndex = tblDataKeuangan.getSelectedRow();
                
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(DashboardView.this,"Pilih data terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int idKeuangan = Integer.parseInt(tblDataKeuangan.getValueAt(selectedIndex, 0).toString());
                    initsEditKeuangan(idKeuangan);
                }
                
            }
            
        });

        setVisible(true);

    }
    
    private void initsTambahKeuangan(){

        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Tambah data keuangan");

        btnSimpanKeuangan.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (/*txtEditTanggal.getText().trim().isEmpty() ||*/ txtEditJumlahUang.getText().trim().isEmpty()
                || rdPilihanDebetKredit.getSelection().getActionCommand().equals(null) || txtEditKeteranganSingkat.getText().trim().isEmpty() ) {
                    
                    DashboardView.this.setVisible(false);

                    // if (txtEditTanggal.getText().trim().isEmpty()) {
                    //     JOptionPane.showMessageDialog(DashboardView.this,"Masukan tanggal terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    // }

                    if (txtEditJumlahUang.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan jumlah uang terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    if (rdPilihanDebetKredit.getSelection().getActionCommand().equals(null)) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan pilihan terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    if (txtEditKeteranganSingkat.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan pilihan terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    DashboardView.this.setVisible(true);

                }
                else{

                    //String tanggal = txtEditTanggal.getText();
                    int jumlahUang = Integer.parseInt(txtEditJumlahUang.getText());
                    String keteranganSingkat = txtEditKeteranganSingkat.getText();
                    String pilihanDebetKredit = rdPilihanDebetKredit.getSelection().getActionCommand();

                    if (Model.tambahDataKeuangan(jumlahUang, keteranganSingkat, pilihanDebetKredit)) {
                        JOptionPane.showMessageDialog(DashboardView.this," Data berhasil ditambahkan","berhasil",JOptionPane.INFORMATION_MESSAGE);
                        initsKeuangan();
                    }else{
                        JOptionPane.showMessageDialog(DashboardView.this,"Data gagal ditambahkan","Error",JOptionPane.ERROR_MESSAGE);
                    }

                }


            }

        });

        menuKeuangan.setSideBarAktif();
        content.add(labelTanggal);
        content.add(txtEditTanggal);
        content.add(labelJumlahUang);
        content.add(txtEditJumlahUang);
        content.add(rdDebet);
        content.add(rdKredit);
        content.add(labelKeteranganSingkat);
        content.add(txtEditKeteranganSingkat);
        content.add(btnSimpanKeuangan);
        setVisible(true);

    }
    
    private void initsEditKeuangan(int id_keuangan){

        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Edit data keuangan");
        
        Object[] detailKeuangan = Model.getDetailKeuangan(id_keuangan);

        txtEditTanggal.setText(detailKeuangan[1].toString());
        txtEditJumlahUang.setText(detailKeuangan[2].toString());
        //rdPilihanDebetKredit.getSelection().setActionCommand(detailKeuangan[3].toString());
        txtEditKeteranganSingkat.setText(detailKeuangan[4].toString());

        btnSimpanKeuangan.addActionListener(new java.awt.event.ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (txtEditJumlahUang.getText().trim().isEmpty() || txtEditTanggal.getText().trim().isEmpty()
                || /*rdPilihanDebetKredit.getSelection().equals()*/  txtEditKeteranganSingkat.getText().trim().isEmpty() ) {
                    
                    DashboardView.this.setVisible(false);

                    if (txtEditJumlahUang.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan jumlah uang terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditTanggal.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan tanggal terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    // if (rdPilihanDebetKredit.getSelection().equals("")) {
                    //     JOptionPane.showMessageDialog(DashboardView.this, "Masukan pilihan terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    // }
                    if (txtEditKeteranganSingkat.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan keterangan singkat terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }

                    DashboardView.this.setVisible(true);
                    
                }
                else{

                    String tanggal = txtEditTanggal.getText();
                    int jumlahUang = Integer.parseInt(txtEditJumlahUang.getText());
                    String pilihan = rdPilihanDebetKredit.getSelection().getActionCommand();
                    String keteranganSingkat = txtEditKeteranganSingkat.getText();
                    //System.out.println(pilihan);
                    if (Model.ubahDataKeuangan(id_keuangan,pilihan, jumlahUang, keteranganSingkat)) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Ubah data berhasil","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                        initsKeuangan();
                    }
                    else{
                        JOptionPane.showMessageDialog(DashboardView.this, "Ubah data gagal","Error",JOptionPane.ERROR_MESSAGE);
                    }

                }

            }

        });        
        
        menuKeuangan.setSideBarAktif();
        content.add(labelTanggal);
        content.add(txtEditTanggal);
        content.add(labelJumlahUang);
        content.add(txtEditJumlahUang);
        content.add(rdDebet);
        content.add(rdKredit);
        content.add(labelKeteranganSingkat);
        content.add(txtEditKeteranganSingkat);
        content.add(btnSimpanKeuangan);
        setVisible(true);
    }

    private void initsBarang(){

        idSelected = null;
        resetSideBar();
        menuBarang.setForeground(cColors.WHITE);
        menuBarang.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Barang");

        labelValueCash.setText(String.valueOf(Model.getTotalBrgCash()));
        labelValueKreditBrg.setText(String.valueOf(Model.getTotalBrgKredit()));

        menuBarang.setSideBarAktif();
        content.add(labelTotalCash);
        content.add(labelValueCash);
        content.add(labelTotalKredit);
        content.add(labelValueKreditBrg);

        tblDataBarang = new cTable(Model.getAllDataBrg());

        tblDataBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                int selectedIndex = tblDataBarang.getSelectedRow();
                int idKeuangan = Integer.valueOf(tblDataBarang.getValueAt(selectedIndex,0).toString());
                //System.out.println(selectedIndex);
            }
            
        });

        tblDataBarang.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataBarang.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataBarang.getColumnModel().getColumn(0).setWidth(0);

        tblDataBarang.getColumnModel().getColumn(9).setMinWidth(0);
        tblDataBarang.getColumnModel().getColumn(9).setMaxWidth(0);
        tblDataBarang.getColumnModel().getColumn(9).setWidth(0);

        spDataBarang = new cScrollPane(tblDataBarang, 25, 65, 740, 310);

        content.add(spDataBarang);
        content.add(btnTambahDataBarang);
        btnTambahDataBarang.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                initsTambahBarang();
            }

        });

        content.add(btnHapusDataBarang);
        btnHapusDataBarang.addActionListener(new java.awt.event.ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selectedIndex = tblDataBarang.getSelectedRow();

                if (selectedIndex != -1) {
                    
                    int idBarang = Integer.parseInt(tblDataBarang.getValueAt(selectedIndex,0).toString());

                    if (Model.hapusDataBarang(idBarang)) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Data barang berhasil dihapus","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                        initsBarang();
                    }
                    else{
                        JOptionPane.showMessageDialog(DashboardView.this, "Data barang gagal dihapus","Gagal",JOptionPane.ERROR_MESSAGE);
                    }

                }
                else{

                }

            }

        });

        content.add(btnEditDataBarang);
        btnEditDataBarang.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int selectedIndex = tblDataBarang.getSelectedRow();
                //System.out.println(selectedIndex);

                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(DashboardView.this, "Pilih tabel terlebih dahulu","Error",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    int idBarang = Integer.parseInt(tblDataBarang.getValueAt(selectedIndex,0).toString());
                    initsEditBarang(idBarang);
                }

            }

        });

        setVisible(true);

    }

    private void initsTambahBarang(){

        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Tambah data Barang");

        btnSimpanBarang.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (txtEditHargaBrg.getText().trim().isEmpty() || txtEditNamaBarang.getText().trim().isEmpty()
                || txtEditStokBarang.getText().trim().isEmpty() || txtEditTanggalEXPBrg.getText().trim().isEmpty()
                || txtEditKeteranganSingkatBrg.getText().trim().isEmpty() || rdPilihanCashKredit.getSelection().getActionCommand().equals(null)) {
                    
                    DashboardView.this.setVisible(false);

                    if (txtEditTanggalEXPBrg.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan Expired barang terlebih dahulu" ,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditHargaBrg.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan harga barang terlebih dahulu" ,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditNamaBarang.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan nama barang terlebih dahulu" ,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditStokBarang.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan stok barang terlebih dahulu" ,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditKeteranganSingkatBrg.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan keterangan barang terlebih dahulu" ,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (rdPilihanCashKredit.getSelection().getActionCommand().equals(null)) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Masukan harga barang terlebih dahulu" ,"Error",JOptionPane.ERROR_MESSAGE);
                    }
                    DashboardView.this.setVisible(true);
                }
                else{

                    String namaBrg = txtEditNamaBarang.getText();
                    String expiredBrg = txtEditTanggalEXPBrg.getText();
                    int hargaBrg = Integer.parseInt(txtEditHargaBrg.getText());
                    int stokBrg = Integer.parseInt(txtEditStokBarang.getText());
                    String keteranganSingkatBrg = txtEditKeteranganSingkatBrg.getText();
                    String pilihanCashKredit = rdPilihanCashKredit.getSelection().getActionCommand();
                    int totalbrg = hargaBrg * stokBrg;

                    if (Model.tambahDataBarang(namaBrg, hargaBrg, expiredBrg, stokBrg, pilihanCashKredit, totalbrg, keteranganSingkatBrg)) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Data barang berhasil ditambahkan","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                        initsBarang();
                    }
                    else{
                        JOptionPane.showMessageDialog(DashboardView.this, "Data barang berhasil ditambahkan","Berhasil",JOptionPane.INFORMATION_MESSAGE);

                    }

                }
                
            }

        });

        menuKeuangan.setSideBarAktif();
        content.add(labelTanggalEXPBrg);
        content.add(txtEditTanggalEXPBrg);
        content.add(labelHargaBrg);
        content.add(txtEditHargaBrg);
        content.add(labelNamaBarang);
        content.add(txtEditNamaBarang);
        content.add(labelStokSatuan);
        content.add(txtEditStokBarang);
        content.add(rdCash);
        content.add(rdKreditBrg);
        content.add(labelKeteranganSingkatBrg);
        content.add(txtEditKeteranganSingkatBrg);
        content.add(btnSimpanBarang);
        setVisible(true);

    }

    private void initsEditBarang(int idBarang){

        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Edit data Barang");

        Object[] dataBarang = Model.getDetailBarang(idBarang);

        txtEditTanggalEXPBrg.setText(dataBarang[4].toString());
        txtEditHargaBrg.setText(dataBarang[3].toString());
        txtEditNamaBarang.setText(dataBarang[2].toString());
        txtEditStokBarang.setText(dataBarang[5].toString());
        txtEditKeteranganSingkatBrg.setText(dataBarang[8].toString());

        btnSimpanBarang.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (txtEditNamaBarang.getText().trim().isEmpty() || txtEditTanggalEXPBrg.getText().trim().isEmpty()
                || txtEditStokBarang.getText().trim().isEmpty() || txtEditHargaBrg.getText().trim().isEmpty()
                || txtEditKeteranganSingkatBrg.getText().trim().isEmpty()) {
                    
                    DashboardView.this.setVisible(false);

                    if (txtEditNamaBarang.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan nama barang terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditTanggalEXPBrg.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan tanggal expired terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditStokBarang.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan Stok barang terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditHargaBrg.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan harga barang terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    if (txtEditKeteranganSingkatBrg.getText().trim().isEmpty()) {
                        JOptionPane.showMessageDialog(DashboardView.this, "Masukan keterangan singkat barang terlebih dahulu","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    DashboardView.this.setVisible(true);

                }
                else{

                    String nama = txtEditNamaBarang.getText();
                    String expired = txtEditTanggalEXPBrg.getText();
                    int harga = Integer.parseInt(txtEditHargaBrg.getText());
                    int stok = Integer.parseInt(txtEditStokBarang.getText());
                    String keteranganSingkat = txtEditKeteranganSingkatBrg.getText();

                    if (Model.ubahDataBarang(idBarang,nama,expired,harga,stok,keteranganSingkat)) {
                        JOptionPane.showMessageDialog(DashboardView.this,"Data barang berhasil diubah","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                        initsBarang();
                    }
                    else{
                        JOptionPane.showMessageDialog(DashboardView.this,"Data barang gagal diubah","Gagal",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            }
            
        });

        menuKeuangan.setSideBarAktif();
        content.add(labelTanggalEXPBrg);
        content.add(txtEditTanggalEXPBrg);
        content.add(labelHargaBrg);
        content.add(txtEditHargaBrg);
        content.add(labelNamaBarang);
        content.add(txtEditNamaBarang);
        content.add(labelStokSatuan);
        content.add(txtEditStokBarang);
        content.add(rdCash);
        content.add(rdKreditBrg);
        content.add(labelKeteranganSingkatBrg);
        content.add(txtEditKeteranganSingkatBrg);
        content.add(btnSimpanBarang);
        setVisible(true);

    }

}
