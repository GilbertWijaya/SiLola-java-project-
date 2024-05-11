package com.partials;

import javax.swing.JTextArea;;

public class cTextArea extends JTextArea{

    public cTextArea(boolean editable){
        
        super();
        setFont(cFonts.TEXTFIELD_FONT);

        if (editable) {
            setForeground(cColors.BLACK);
        }
        else{
            setForeground(cColors.RED);
            setEditable(false);
        }

        setLineWrap(true);
        setWrapStyleWord(true);

    }

    public cTextArea(String text,int x,int y,boolean editable){
        
        this(editable);
        setBounds(x,y,360,200);
    }

}
