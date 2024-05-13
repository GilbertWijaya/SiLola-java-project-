package com.views;

import java.awt.event.ActionEvent;

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
    private cLabelInfo labelValueDebet = new cLabelInfo(" 0 ", 155, 470);
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

    private cRadioButton rdDebet = new cRadioButton("debet","Debet",25, 180, 80);
    private cRadioButton rdKredit = new cRadioButton("kredit","Kredit",40, 180, 190);
    private javax.swing.ButtonGroup rdPilihanDebetKredit = new javax.swing.ButtonGroup();

    private cFormLabel labelKeteranganSingkat = new cFormLabel("Masukan Keterangan singkat",25,210,300,false,cColors.BLACK);
    private cTextFields txtEditKeteranganSingkat = new cTextFields(25,240,300,false);

    private cGreenButton btnSimpanKeuangan = new cGreenButton("simpan",840,470,110);

    //komponen barang
    private cLabelInfo labelTotalCash = new cLabelInfo("Total Cash : ", 25, 470);
    private cLabelInfo labelValueCash = new cLabelInfo(" 0 ", 155, 470);
    private cLabelInfo labelTotalKreditBrg = new cLabelInfo("Total Kredit : ", 300, 470);
    private cLabelInfo labelValueKreditBrg = new cLabelInfo(" 0 " , 430, 470);
    private cTable tblDataBarang;
    private cScrollPane spDataBarang;
    private cGreenButton btnTambahDataBarang = new cGreenButton("tambah", 600, 470, 110);
    private cGreenButton btnHapusDataBarang = new cGreenButton("Hapus", 720, 470, 110);
    private cGreenButton btnEditDataBarang = new cGreenButton("Edit", 840, 470, 110);

    //komponent edit barang
    private cFormLabel labelTanggalBrg = new cFormLabel("Masukan tanggal",25,20,300,false,cColors.BLACK);
    private cTextFields txtEditTanggalBrg = new cTextFields(25,60,300,false);

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

    private cGreenButton btnEditBarang = new cGreenButton("simpan",840,470,110);

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
        tblDataKeuangan.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(0).setWidth(0);

        tblDataKeuangan.getColumnModel().getColumn(5).setMinWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(5).setMaxWidth(0);
        tblDataKeuangan.getColumnModel().getColumn(5).setWidth(0);


        spDataKeuangan = new cScrollPane(tblDataKeuangan,25, 65, 740, 310);

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

        content.add(btnEditDataKeuangan);
        btnEditDataKeuangan.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                initsEditKeuangan();
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
    
    private void initsEditKeuangan(){

        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Edit data keuangan");

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

        menuBarang.setSideBarAktif();
        content.add(labelTotalCash);
        content.add(labelValueCash);
        content.add(labelTotalKredit);
        content.add(labelValueKreditBrg);

        tblDataBarang = new cTable(Model.getAllDataBrg());
        tblDataBarang.getColumnModel().getColumn(0).setMinWidth(0);
        tblDataBarang.getColumnModel().getColumn(0).setMaxWidth(0);
        tblDataBarang.getColumnModel().getColumn(0).setWidth(0);

        tblDataBarang.getColumnModel().getColumn(7).setMinWidth(0);
        tblDataBarang.getColumnModel().getColumn(7).setMaxWidth(0);
        tblDataBarang.getColumnModel().getColumn(7).setWidth(0);

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

        content.add(btnEditDataBarang);
        btnEditDataBarang.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                initsTambahBarang();
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

        menuKeuangan.setSideBarAktif();
        content.add(labelTanggal);
        content.add(txtEditTanggal);
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
        content.add(btnEditBarang);
        setVisible(true);

    }

    private void initsEditBarang(){

        idSelected = null;
        resetSideBar();
        menuKeuangan.setForeground(cColors.WHITE);
        menuKeuangan.setBackground(cColors.RED);
        refreshContent();

        menuTitle.setText("Edit data Barang");
        menuKeuangan.setSideBarAktif();
        content.add(labelTanggal);
        content.add(txtEditTanggal);
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
        content.add(btnEditBarang);
        setVisible(true);

    }

}
