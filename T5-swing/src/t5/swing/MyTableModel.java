/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t5.swing;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author downesk4
 */
public class MyTableModel extends AbstractTableModel{
    
    
private String[] columnNames = {"First Name", "Last Name", "ID"};
private String[][] data = {
{"Chris", "Bass", "123456"},
{"Joe", "Bloggs", "654321"},
{"Derek", "Trotter", "458645"},
{"Mr", "Khan", "228252"},
{"Basil", "Fawlty", "112288"},
{"Sheldon", "Cooper", "336332"},
{"Horatio", "Hornblower", "556484"},
{"Edmund","Blackadder","557771"}
};
JTable myTable = new JTable(data, columnNames);
JScrollPane scroller = new JScrollPane(myTable,
ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//fr.add(scroller, BorderLayout.CENTER);

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
