package com.views;

import com.templates.cStartFrame;
import com.partials.*;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.program.Controller;
import com.program.Model;

import java.awt.event.ActionEvent;

public class StartView extends cStartFrame{

    //komponen login aplikasi
    private cFormLabel labelLoginUsername = new cFormLabel("Username",0,84,450,true);
    private cTextFields txtLoginUsername = new cTextFields(65,114,320,true);

    private cFormLabel labelLoginPassword = new cFormLabel("Password",0,183,450,true);
    private cPasswordFields txtLoginPassword = new cPasswordFields(65, 213, 320, true);

    private cGreenButton btnLoginUser = new cGreenButton("Login", 65, 282, 320);

    private cLinkStart toDaftarUser = new cLinkStart("Belum punya akun ?",322);

    //komponen daftar aplikasi
    private cFormLabel labelDaftarUsername = new cFormLabel("Username",0,84,450,true);
    private cTextFields txtDaftarUsername = new cTextFields(65,114,320,true);

    private cFormLabel labelDaftarNIK = new cFormLabel("Nomor Kewarganegaraan",0,183,450,true);
    private cTextFields txtDaftarNIK = new cTextFields(65,213,320,true);

    private cFormLabel labelDaftarPassword = new cFormLabel("Password",0,282,450,true);
    private cPasswordFields txtDaftarPassword = new cPasswordFields(65, 312, 320, true);

    private cGreenButton btnDaftarUser = new cGreenButton("Daftar", 65, 381, 320);

    private cLinkStart toLoginUser = new cLinkStart("Sudah punya akun ?",421);
    

    public StartView(){

        toLoginUser.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                Controller.showLoginUser();
            }

        });

        toDaftarUser.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent e) {
                Controller.showDaftarUser();
            }

        });

    }

    public void initsLoginUser(){

        this.setTitle("Login User");
        cardStart.removeAll();
        titleStart.setText("Login User");
        cardStart.add(titleStart);
        
        btnLoginUser.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                
                String username = txtLoginUsername.getText();
                String password = String.valueOf(txtLoginPassword.getPassword());
                
                if (txtLoginUsername.getText().equalsIgnoreCase("") || String.valueOf(txtLoginPassword.getPassword()).equalsIgnoreCase("")) {
                    
                    Controller.showLoginUser();
                    
                    if (txtLoginUsername.getText().equalsIgnoreCase("")) {
                        //cardStart.add();
                        JOptionPane.showMessageDialog(StartView.this, "Username tidak boleh kosong","Peringatan",JOptionPane.WARNING_MESSAGE);
                    }
                    if (String.valueOf(txtLoginPassword.getPassword()).equalsIgnoreCase("")) {
                        //cardStart.add();
                        JOptionPane.showMessageDialog(StartView.this, "Password tidak boleh kosong","Peringatan",JOptionPane.WARNING_MESSAGE);

                    }
                }else{

                    if (Model.verifyAkunUser(username,password)) {

                        Controller.showDashboard(Integer.valueOf(Model.getDetailUserByUsername(username)[0].toString()));
                        StartView.this.setVisible(false);
                        //System.out.println("login berhasil");
                        //System.out.println(Model.verifyAkunUser(username, password));
                    }else{
                        JOptionPane.showMessageDialog(StartView.this, "Login gagal, silahkan periksa username dan password anda","error",JOptionPane.ERROR_MESSAGE);
                        //System.out.println(Model.verifyAkunUser(username, password));
                    }
              }
            }
        });

        cardStart.add(labelLoginUsername);
        cardStart.add(txtLoginUsername);

        cardStart.add(labelLoginPassword);
        cardStart.add(txtLoginPassword);

        cardStart.add(btnLoginUser);

        cardStart.add(toDaftarUser);

    }

    public void initsDaftarUser(){

        this.setTitle("Daftar User");
        cardStart.removeAll();
        titleStart.setText("Daftar User");
        cardStart.add(titleStart);

        btnDaftarUser.addActionListener(new java.awt.event.ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {

                String username = txtDaftarUsername.getText();
                String noWarga = txtDaftarNIK.getText();
                String password = String.valueOf(txtDaftarPassword.getPassword());

                if (txtDaftarUsername.getText().equalsIgnoreCase("") || txtDaftarNIK.getText().equalsIgnoreCase("") || String.valueOf(txtDaftarPassword.getPassword()).equalsIgnoreCase("")) {
                    
                    Controller.showDaftarUser();
                    
                    if (txtDaftarUsername.getText().equalsIgnoreCase("")) {
                        //cardStart.add();
                        JOptionPane.showMessageDialog(StartView.this, "Username tidak boleh kosong","Peringatan",JOptionPane.WARNING_MESSAGE);
                    }
                    if (txtDaftarNIK.getText().equalsIgnoreCase("")) {
                        //cardStart.add();
                        JOptionPane.showMessageDialog(StartView.this, "NIK tidak boleh kosong","Peringatan",JOptionPane.WARNING_MESSAGE);

                    }
                    if (String.valueOf(txtDaftarPassword.getPassword()).equalsIgnoreCase("")) {
                        //cardStart.add();
                        JOptionPane.showMessageDialog(StartView.this, "Username tidak boleh kosong","Peringatan",JOptionPane.WARNING_MESSAGE);

                    }
                }
                else{

                    if (Model.verifyNoWargaUser(noWarga)) {
                        
                        if (Model.daftarUser(username,noWarga,password)) {
                            JOptionPane.showMessageDialog(StartView.this, "Data berhasil terdaftar","Berhasil",JOptionPane.INFORMATION_MESSAGE);
                            //initsLoginUser();
                        }else{
                            JOptionPane.showMessageDialog(StartView.this, "Data gagal terdaftar","Gagal",JOptionPane.ERROR_MESSAGE);
                        }

                    }else{
                        JOptionPane.showMessageDialog(StartView.this, "Silahkan cek kembali data anda","Peringatan",JOptionPane.WARNING_MESSAGE);
                    }

                }

            }

        });
        
        cardStart.add(labelDaftarUsername);
        cardStart.add(txtDaftarUsername);

        cardStart.add(labelDaftarNIK);
        cardStart.add(txtDaftarNIK);

        cardStart.add(labelDaftarPassword);
        cardStart.add(txtDaftarPassword);

        cardStart.add(btnDaftarUser);

        cardStart.add(toLoginUser);

    }

}
