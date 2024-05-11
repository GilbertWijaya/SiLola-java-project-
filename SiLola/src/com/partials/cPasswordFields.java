package com.partials;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class cPasswordFields extends JPasswordField{

    public cPasswordFields(int x,int y,int width,boolean centerAllignment) {
        
        super();
        setBounds(x, y, width, 35);
        
        if (centerAllignment) {
            setHorizontalAlignment(JPasswordField.CENTER);
        }
        //setVerticalAlignment(JTextField.CENTER);
        
        setFont(cFonts.TEXTFIELD_FONT);
        setForeground(cColors.BLACK);
        setBorder(new javax.swing.border.LineBorder(cColors.BLUE,1));
        
    }
    
    
    
}