package com.templates;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.partials.cLinkKeluar;
import com.partials.cRadioButton;
import com.partials.cColors;
import com.partials.cFonts;

public abstract class cDashboardFrame extends JFrame {

    public JPanel sideBar = new JPanel();
    public JPanel header = new JPanel();
    public JPanel main = new JPanel();
    public JPanel content = new JPanel();
    public JPanel appTitle = new JPanel();

    private JLabel appText = new JLabel("SiLola");
    public JLabel RoleText = new JLabel("nama user | role");
    public JLabel menuTitle = new JLabel("menu title");
    public JLabel CRText = new JLabel("Copyright 2024. KELOMPOK D.");

    private cLinkKeluar exitLink = new cLinkKeluar(938,cColors.RED);
    
    public cDashboardFrame() {
        
        super();
        setSize(1280,720);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setLayout(null);

        sideBar.setBackground(cColors.BLUE_PANEL);
        sideBar.setBounds(0, 0, 230, 720);
        sideBar.setLayout(null);

        header.setBackground(cColors.YELLOW);
        header.setBounds(230, 0, 1050, 70);
        header.setLayout(null);

        main.setBackground(cColors.RED);
        main.setBounds(230, 70, 1050, 650);
        main.setLayout(null);

        content.setBackground(cColors.WHITE);
        content.setBounds(30, 70, 990, 520);
        content.setLayout(null);

        appTitle.setBackground(cColors.WHITE);
        appTitle.setBounds(0, 0, 230, 70);
        appTitle.setLayout(null);

        appText.setFont(cFonts.APP_FONT);
        appText.setBounds(0, 0, 230, 70);
        appText.setHorizontalAlignment(JLabel.CENTER);
        appText.setVerticalAlignment(JLabel.CENTER);
        appText.setForeground(cColors.RED);

        RoleText.setFont(cFonts.ROLE_FONT);
        RoleText.setBounds(30, 0,400, 70);
        //RoleText.setHorizontalAlignment(JLabel.CENTER);
        RoleText.setVerticalAlignment(JLabel.CENTER);
        RoleText.setForeground(cColors.RED);

        menuTitle.setFont(cFonts.MENU_TITLE_FONT);
        menuTitle.setBounds(30, 10,600, 50);
        //menuTitle.setHorizontalAlignment(JLabel.CENTER);
        menuTitle.setVerticalAlignment(JLabel.CENTER);
        menuTitle.setForeground(cColors.WHITE);

        CRText.setFont(cFonts.TEXTFIELD_FONT);
        CRText.setBounds(0, 610,1050, 20);
        CRText.setHorizontalAlignment(JLabel.CENTER);
        CRText.setVerticalAlignment(JLabel.CENTER);
        CRText.setForeground(cColors.WHITE);

        appTitle.add(appText);

        sideBar.add(appTitle);
        header.add(RoleText);
        header.add(exitLink);
        
        main.add(content);
        main.add(menuTitle);
        main.add(CRText);
        
        add(sideBar);
        add(header);
        add(main);

    }

    public cDashboardFrame(String title) {
        
        this();
        setTitle(title);
    }

}
