package com.partials;

import javax.swing.JLabel;

public class cBigFonts extends JLabel {

    public cBigFonts(String text,int x,int y){
        super();
        setText(text);
        setBounds(x, y, 450, 70);
        setVerticalAlignment(JLabel.CENTER);

        setFont(cFonts.BIG_FONT);
        setForeground(cColors.RED_BIG_FONT);

    }
    
}
