package com.partials;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cSidebarMenu extends JLabel {

    public java.awt.event.MouseAdapter sidebarAktif = new java.awt.event.MouseAdapter() {
        
        @Override
        public void mouseEntered(MouseEvent e) {
            setBackground(cColors.RED);
            setForeground(cColors.WHITE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBackground(cColors.RED);
            setForeground(cColors.WHITE);
        }

    };

    public java.awt.event.MouseAdapter sideBarnonAktif = new java.awt.event.MouseAdapter(){
        
        @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                setBackground(cColors.RED);
                setForeground(cColors.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(cColors.YELLOW);
                setForeground(cColors.RED);
            }
        
    };

    public void setSideBarAktif(){
        try {
            removeMouseListener(sideBarnonAktif);
            addMouseListener(sidebarAktif);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setSideBarnonAktif(){
        try {
            addMouseListener(sideBarnonAktif);
            removeMouseListener(sidebarAktif);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public cSidebarMenu(String text,int y){

        super();
        setText(text);
        setBounds(0, y, 230, 50);     
        setOpaque(true);
        setFont(cFonts.SIDEBAR_FONT);
        setForeground(cColors.RED);
        setBackground(cColors.YELLOW);
        setHorizontalAlignment(JLabel.CENTER);
        
        addMouseListener(new java.awt.event.MouseAdapter(){
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e){
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });

        setSideBarnonAktif();

    }

}
