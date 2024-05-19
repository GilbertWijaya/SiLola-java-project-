package com.program;

import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.DriverManager;

public class Model {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_silola";
    private static final String Username = "root";
    private static final String Password = "";

    private static Connection conn;
    private static Statement stmt;

    public static void connection(){

        try {
            
            conn = DriverManager.getConnection(DB_URL, Username, Password);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Object[] getDetailUser(int id){

        connection();
        Object[] rowData = new Object[7];

        try {
            
            stmt = conn.createStatement();

            String query = "SELECT * FROM vwuseraktif WHERE id_user = " + id;

            ResultSet resultData = stmt.executeQuery(query);

            resultData.next();

            rowData[0] = resultData.getInt("id_user");
            rowData[1] = resultData.getString("nama_user");
            rowData[2] = resultData.getString("password");
            rowData[3] = resultData.getString("no_warga_user");
            rowData[4] = resultData.getString("jabatan_user");
            rowData[5] = resultData.getString("total_kas_user");
            rowData[6] = resultData.getString("s_aktif_user");

            stmt.close();
            conn.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;
    }

    public static int getCountAllBrg(){

        connection();
        int count = 0;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) FROM vwallbrgaktif";

            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);

            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getCountAllTotalBrg(){

        connection();
        int count = 0;

        try {

            stmt = conn.createStatement();
            String query = "SELECT SUM(total_barang) FROM vwallbrgaktif";

            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getCountExpBrgAktif(){

        connection();
        int count = 0;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) FROM vwexpiredbrgaktif";

            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            count = rs.getInt(1);

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static boolean editKas(double jumlahKas,int idUser){
        
        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();

            String query = "UPDATE tbl_user SET total_kas_user = " + jumlahKas + " WHERE id_user = " + idUser;

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static DefaultTableModel getAllDataKeuangan(){

        connection();
        String[] dataHeader = {"id keuangan","tanggal entry","jumlah uang","debet/kredit","keterangan singkat","status aktif"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {
            
            stmt = conn.createStatement();
            String query = "select * from vwkeuanganaktif";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Object[] rowData = {rs.getInt("id_keuangan"),rs.getString("tanggal"),rs.getInt("jumlah_uang"),
                rs.getString("debet_kredit"),rs.getString("keterangan_singkat"),rs.getString("s_aktif_keu")};
                tm.addRow(rowData);
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }        


        return tm;
    }

    public static DefaultTableModel getAllDataBrg(){

        connection();
        String[] dataHeader = {"id barang","tanggal entry","nama barang","harga satuan","expired barang","stok satuan","cash/kredit","total barang","keterangan singkat","status aktif"};
        DefaultTableModel tm = new DefaultTableModel(null, dataHeader);

        try {

            stmt = conn.createStatement();
            String query = "select * from vwbarangaktif";

            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                Object rowData[] = {rs.getInt("id_barang"),rs.getString("tanggal"),rs.getString("nama_barang"),
            rs.getInt("harga_satuan"),rs.getString("expired_brg"),rs.getInt("stok_satuan"),rs.getString("cash_kredit"),
            rs.getInt("total_barang"),rs.getString("keterangan_singkat"),rs.getString("s_aktif_brg")};
            tm.addRow(rowData);
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return tm;
    }

    public static int getJumlahKeuDebet(){

        connection();
        int count = 0;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT SUM(`jumlah_uang`) FROM `vwkeudebetaktif`";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getJumlahKeuKredit(){

        connection();
        int count = 0;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT SUM(`jumlah_uang`) FROM `vwkeukreditaktif`";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getTotalBrgCash(){

        connection();
        int count = 0;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT SUM(`total_barang`) FROM `vwbrgcashaktif`";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);

            stmt.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int getTotalBrgKredit(){

        connection();
        int count = 0;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT SUM(`total_barang`) FROM `vwbrgkreditaktif`";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            count = rs.getInt(1);

            stmt.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static boolean tambahDataKeuangan(int jumlahUang,String ketSingkat,String pilihanDebetKredit){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "INSERT INTO `tbl_keuangan` VALUES( " + null + ",NOW()," + jumlahUang + ",'" + pilihanDebetKredit + "'," + "'" + ketSingkat + "'," + 1 + ")";

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static boolean tambahDataBarang(String namaBrg,int hargaBrg,String expiredBrg,int stokBrg,String rdPilihanCashKredit,int totalbrg,String keteranganSingkatBrg){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "INSERT INTO `tbl_barang` VALUES( " + null + ",NOW(),'" + namaBrg + "'," + hargaBrg + ","  + "'" +expiredBrg + "'" + "," + stokBrg + ",'" + rdPilihanCashKredit + "'," + totalbrg + ",'" + keteranganSingkatBrg + "'," + "'1'" + ")";

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Object[] getDetailKeuangan(int id_keuangan){

        connection();
        Object[] rowData = new Object[6];

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT * FROM tbl_keuangan WHERE id_keuangan = " + id_keuangan;

            ResultSet resultData = stmt.executeQuery(query);

            resultData.next();

            rowData[0] = resultData.getInt("id_keuangan");
            rowData[1] = resultData.getString("tanggal");
            rowData[2] = resultData.getInt("jumlah_uang");
            rowData[3] = resultData.getString("debet_kredit");
            rowData[4] = resultData.getString("keterangan_singkat");
            rowData[5] = resultData.getString("s_aktif_keu");

            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;
    }

    public static boolean ubahDataKeuangan(int selectedIndex,String pilihan,int jumlah,String ketSingkat){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "UPDATE `tbl_keuangan` SET tanggal = NOW(),`jumlah_uang` = " + jumlah + ",`debet_kredit` = '" + pilihan+"',`keterangan_singkat` = '" + ketSingkat+"' WHERE `id_keuangan` = " + selectedIndex;

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Object[] getDetailBarang(int idBarang){

        connection();
        Object[] rowData = new Object[10];

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT * FROM tbl_barang WHERE id_barang = " + idBarang;

            ResultSet resultData = stmt.executeQuery(query);

            resultData.next();

            rowData[0] = resultData.getInt("id_barang");
            rowData[1] = resultData.getString("tanggal");
            rowData[2] = resultData.getString("nama_barang");
            rowData[3] = resultData.getInt("harga_satuan");
            rowData[4] = resultData.getString("expired_brg");
            rowData[5] = resultData.getInt("stok_satuan");
            rowData[6] = resultData.getString("cash_kredit");
            rowData[7] = resultData.getInt("total_barang");
            rowData[8] = resultData.getString("keterangan_singkat");
            rowData[9] = resultData.getString("s_aktif_brg");

            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;
    }

    public static boolean ubahDataBarang(int idBarang,String nama,String expired,int harga,int stok,String ketSingkat){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "UPDATE `tbl_barang` SET tanggal = NOW(),`nama_barang` = '" + nama + "',`harga_satuan` = " + harga + ",`expired_brg` = '" + expired + "',`stok_satuan` = " + stok + ",`keterangan_singkat` = '" + ketSingkat + "' WHERE `id_barang` = " + idBarang;

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static boolean hapusDataKeuangan(int idKeuangan){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "UPDATE tbl_keuangan SET s_aktif_keu = '0' WHERE id_keuangan = " + idKeuangan ;

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static boolean hapusDataBarang(int idBarang){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "UPDATE tbl_barang SET s_aktif_brg = '0' WHERE id_barang = " + idBarang ;

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    public static Object[] getDetailUserByUsername(String username){

        connection();
        Object[] rowData = new Object[7];

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT * FROM `vwuseraktif` WHERE `nama_user` = '" + username + "'";

            ResultSet resultData = stmt.executeQuery(query);

            resultData.next();

            rowData[0] = resultData.getInt("id_user");
            rowData[1] = resultData.getString("nama_user");
            rowData[2] = resultData.getString("password");
            rowData[3] = resultData.getString("no_warga_user");
            rowData[4] = resultData.getString("jabatan_user");
            rowData[5] = resultData.getInt("total_kas_user");
            rowData[6] = resultData.getString("s_aktif_user");

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;
    }

    public static boolean verifyAkunUser(String username, String password){

        connection();
        boolean Available = false;

        try {
            
            stmt = conn.createStatement();

            String query = "SELECT COUNT(*) FROM `vwuseraktif` WHERE `nama_user` = '" +username+ "' AND `password` = '" +password+"'";

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            if (rs.getInt(1) == 1) {
                Available = true;
            }
            

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Available;
    }

    public static boolean verifyNoWargaUser(String noWarga){

        connection();
        boolean Available = false;

        try {
            
            stmt = conn.createStatement();
            String query = "SELECT COUNT(*) FROM `vwuseraktif` WHERE `no_warga_user` =" + noWarga;

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            if (rs.getInt(1) == 0) {
                Available = true;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Available;
    }

    public static boolean daftarUser(String username,String noWarga,String password){

        connection();
        boolean status = false;

        try {
            
            stmt = conn.createStatement();
            String query = "INSERT INTO tbl_user VALUES(NULL,'"+username+"','karyawan',"+noWarga+",'"+password+"',0,'1')";

            if (stmt.executeUpdate(query) > 0) {
                status = true;
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


}
