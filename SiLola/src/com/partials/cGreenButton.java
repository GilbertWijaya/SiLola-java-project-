package com.partials;

import javax.swing.JButton;

public class cGreenButton extends JButton {

    public cGreenButton(String text,int x,int y,int width){
        super();

        setText(text);
        setBounds(x, y, width, 35);
        setFont(cFonts.BUTTON_FONT);
        setBackground(cColors.GREEN);
        setForeground(cColors.WHITE);

    }

}
