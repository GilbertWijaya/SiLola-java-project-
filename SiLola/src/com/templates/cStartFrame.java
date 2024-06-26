package com.templates;

import com.partials.cGreenButton;
import com.partials.cColors;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import com.partials.cFonts;
import com.partials.cLinkKeluar;

public abstract class cStartFrame extends JFrame {

    public JPanel bg = new JPanel();
    public JPanel cardStart = new JPanel();
    public cLinkKeluar linkKeluar = new cLinkKeluar(1168);
    public JLabel titleStart = new JLabel("Title Start");

    public cStartFrame(){

        super();
        setSize(1280,720);
        setLocationRelativeTo(null);
        setLayout(null);
        setUndecorated(true);
        setDefaultCloseOperation(cStartFrame.EXIT_ON_CLOSE);

        bg.setBackground(cColors.RED);
        bg.setBounds(0,0,1280,720);
        bg.setLayout(null);

        cardStart.setBackground(cColors.BLUE_PANEL);
        cardStart.setBounds(415,90,450,540);
        cardStart.setLayout(null);

        titleStart.setFont(cFonts.TTILE_START_FONT);
        titleStart.setForeground(cColors.WHITE);
        titleStart.setBounds(0,30,450,40);
        titleStart.setHorizontalAlignment(JLabel.CENTER);
        titleStart.setVerticalAlignment(JLabel.CENTER);

        cardStart.add(titleStart);

        bg.add(cardStart);
        bg.add(linkKeluar);
        add(bg);


    }

    public cStartFrame(String title){
        this();
        setTitle(title);
    }


}
