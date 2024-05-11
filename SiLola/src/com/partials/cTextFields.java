package com.partials;

import javax.swing.JTextField;

public class cTextFields extends JTextField {

    public cTextFields(int x,int y,int width,boolean centerAllignment){
        
        super();
        setBounds(x, y, width, 35);
        
        if (centerAllignment) {
            setHorizontalAlignment(JTextField.CENTER);
        }
        //setVerticalAlignment(JTextField.CENTER);
        
        setFont(cFonts.TEXTFIELD_FONT);
        setForeground(cColors.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColors.BLACK,1));
        
    }
}
