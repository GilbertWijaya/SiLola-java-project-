package com.views;

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

    Integer idCustomer = null;
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

    private cLabelInfo labelJumlahTotalOmset = new cLabelInfo("Jumlah total omset", 495, 150);
    private cBigFonts valueJumlahTotalOmset = new cBigFonts("0", 495, 190);

    private cLabelInfo labelJumlahBarangExpired = new cLabelInfo("Jumlah barang expired", 495, 280);
    private cBigFonts valueJumlahBarangExpired = new cBigFonts("0", 495, 320);

    private cGreenButton editKasButton = new cGreenButton("Edit kas",50,280,169);

    //komponent edit kas
    private cFormLabel labelKas = new cFormLabel("Masukan jumlah dana kas baru",25,20,300,false);
    private cTextFields txtEditKas = new cTextFields(25,60,300,false);
    private cGreenButton btnEditKas = new cGreenButton("Simpan",25,100,170);

    //komponen keuangan
    private cLabelInfo labelDataKeuangan = new cLabelInfo("Keuangan", 25, 20);
    private cLabelInfo labelTotalDebet = new cLabelInfo("Total debet : ", 25, 660);
    private cLabelInfo labelValueDebet = new cLabelInfo(" 0 ", 50, 660);
    private cLabelInfo labelTotalKredit = new cLabelInfo("Total Kredit : ", 70, 660);
    private cLabelInfo labelValueKredit = new cLabelInfo(" 0 " , 100, 660);
    private cTable tblDataKeuangan;
    private cScrollPane spDataKeuangan;
    private cGreenButton btnTambahDataKeuangan = new cGreenButton("tambah", 125, 660, 110);
    private cGreenButton btnHapusDataKeuangan = new cGreenButton("Hapus", 250, 660, 110);
    private cGreenButton btnEditDataKeuangan = new cGreenButton("Edit", 425, 660, 110);

    //komponent edit kas
    private cFormLabel labelTanggal = new cFormLabel("Masukan tanggal",25,20,300,false);
    private cTextFields txtEditTanggal = new cTextFields(25,60,300,false);

    private cFormLabel labelJumlahUang = new cFormLabel("Masukan Jumlah uang",25,40,300,false);
    private cTextFields txtEditJumlahUang = new cTextFields(25,120,300,false);

    private cRadioButton rdDebet = new cRadioButton("debet","debet",25, 145, 300);
    private cRadioButton rdKredit = new cRadioButton("kredit","kredit",40, 145, 300);
    private javax.swing.ButtonGroup rdPilihanDebetKredit = new javax.swing.ButtonGroup();

    private cFormLabel labelKeteranganSingkat = new cFormLabel("Masukan Keterangan singkat",25,165,300,false);
    private cTextFields txtEditKeteranganSingkat = new cTextFields(25,185,300,false);

    private cGreenButton btnEditKeuangan = new cGreenButton("simpan",25,660,110);

    //komponen barang
    private cLabelInfo labelDataBarang = new cLabelInfo("Keuangan", 25, 20);
    private cLabelInfo labelTotalCash = new cLabelInfo("Total debet : ", 25, 660);
    private cLabelInfo labelValuekCash = new cLabelInfo(" 0 ", 50, 660);
    private cLabelInfo labelTotalKreditBrg = new cLabelInfo("Total Kredit : ", 70, 660);
    private cLabelInfo labelValueKreditBrg = new cLabelInfo(" 0 " , 100, 660);
    private cTable tblDataBarang;
    private cScrollPane spDataBarang;
    private cGreenButton btnTambahDataBarang = new cGreenButton("tambah", 125, 660, 110);
    private cGreenButton btnHapusDataBarang = new cGreenButton("Hapus", 250, 660, 110);
    private cGreenButton btnEditDataBarang = new cGreenButton("Edit", 425, 660, 110);

    //komponent edit barang
    private cFormLabel labelTanggalBrg = new cFormLabel("Masukan tanggal",25,20,300,false);
    private cTextFields txtEditTanggalBrg = new cTextFields(25,60,300,false);

    private cFormLabel labelHargaBrg = new cFormLabel("Masukan harga satuan barang",620,20,300,false);
    private cTextFields txtEditHargaBrg = new cTextFields(620,60,300,false);

    private cFormLabel labelNamaBarang = new cFormLabel("Masukan nama barang",25,40,300,false);
    private cTextFields txtEditNamaBarang = new cTextFields(25,120,300,false);

    private cFormLabel labelStokSatuan = new cFormLabel("Masukan jumlah stok satuan",620,40,300,false);
    private cTextFields txtEditHargaBarang = new cTextFields(620,120,300,false);

    private cRadioButton rdCash = new cRadioButton("cash","cash",25, 145, 300);
    private cRadioButton rdKreditBrg = new cRadioButton("kredit","kredit",40, 145, 300);
    private javax.swing.ButtonGroup rdPilihanCashKredit = new javax.swing.ButtonGroup();

    private cFormLabel labelKeteranganSingkatBrg = new cFormLabel("Masukan Keterangan singkat",25,165,300,false);
    private cTextFields txtEditKeteranganSingkatBrg = new cTextFields(25,185,300,false);

    private cGreenButton btnEditBarang = new cGreenButton("simpan",25,660,110);

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
            //RoleText.setText("Customer | " + Model.getDetailCustomer(idCustomer)[1].toString());
            content.removeAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public DashboardView(Integer id){

        super("Dashboard User");
        this.idCustomer = id;
        //RoleText.setText("Customer | " + Model.getDetailCustomer(idCustomer)[1].toString());

        menuBeranda.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                initsBeranda();
            }

        });

        menuKeuangan.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                //initsKeuangan();
            }

        });

        menuBarang.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                //initsBarang();
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
                  idCustomer = null;
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

        menuBeranda.setSideBarAktif();
        content.add(labelJumlahItemBarang);
        content.add(valueJumlahItemBarang);
        content.add(labelJumlahTotalBarang);
        content.add(valueJumlahTotalBarang);
        content.add(labelTotalKas);
        content.add(editKasButton); 
        content.add(valueTotalKas);
        setVisible(true);

    }

}
