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
        Object[] data = new Object[5];

        try {
            
            stmt = conn.createStatement();

            String query = "SELECT* FROM vwuseraktif WHERE id_user = " + id;

            ResultSet rs = stmt.executeQuery(query);

            rs.next();

            data[0] = rs.getString("id_user");
            data[1] = rs.getString("nama_user");
            data[2] = rs.getString("jabatan_user");
            data[3] = rs.getString("total_kas_user");
            data[4] = rs.getString("s_aktif_user");

            stmt.close();
            conn.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
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
        String[] dataHeader = {"id keuangan","tanggal","jumlah uang","debet/kredit","keterangan singkat","status aktif"};
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
        String[] dataHeader = {"id barang","tanggal","nama barang","harga satuan","expired barang","stok satuan","cash/kredit","total barang","keterangan singkat","status aktif"};
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

}
