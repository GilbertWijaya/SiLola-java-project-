package com.partials;

import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class cLinkStart extends JLabel {

    public cLinkStart(String text,int y){

        super();
        setText(text);
        setBounds(0, y, 450, 20);

        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);

        setFont(cFonts.LINK_START_FONT);
        setForeground(cColors.GREEN);

        addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseEntered(MouseEvent e) {
                
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

        });

    }

}
