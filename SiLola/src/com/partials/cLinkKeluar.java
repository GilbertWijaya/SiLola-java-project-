package com.partials;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cLinkKeluar extends JLabel{

    public cLinkKeluar(int x){

        super();
        setBounds(x,0,82,70);
        setText("Keluar");
        setFont(cFonts.LINK_EXIT_FONT);
        setForeground(cColors.WHITE);

        addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                
                Object[] option = {"YA","TIDAK"};
                int konfirmasi = JOptionPane.showOptionDialog(null, "klik 'YA' untuk keluar","Konfirmasi",
                    JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE,null,option,option[0]);
                
                if (konfirmasi == 0) {
                    System.exit(0);
                }

            }

        });


    }

    public cLinkKeluar(int x,Color a){
        this(x);
        setForeground(a);
    }

}
