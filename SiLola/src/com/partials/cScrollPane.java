package com.partials;

import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class cScrollPane extends JScrollPane {

    public cScrollPane(java.awt.Component view,int x,int y,int width,int height){

        super(view);
        setBounds(x, y, width, height);
        getViewport().setBackground(cColors.WHITE);
        setBorder(new LineBorder(cColors.BLUE_TABLE_HEADER,2));

    }

}
