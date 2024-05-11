package com.partials;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class cTable extends JTable {

    public cTable(javax.swing.table.TableModel dm){

        super(dm);
        setFont(cFonts.TEXTFIELD_FONT);
        getTableHeader().setFont(cFonts.HEADER_TABLE_FONT);
        getTableHeader().setBackground(cColors.BLUE);
        getTableHeader().setForeground(cColors.WHITE);
        setRowHeight(30);
        getTableHeader().setReorderingAllowed(false);
        setShowVerticalLines(false);
        setShowHorizontalLines(false);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setDragEnabled(true);
        setSelectionBackground(cColors.RED);
        setSelectionForeground(cColors.WHITE);

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
