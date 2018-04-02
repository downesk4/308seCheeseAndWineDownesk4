/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t5.swing;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author downesk4
 */
public class T5Swing {
    public T5Swing(){
        
        //A1 & 2
        final JFrame fr = new JFrame("Swing JFrame");
fr.setSize(300, 400);
fr.setVisible(true);
fr.setDefaultCloseOperation(
JFrame.DISPOSE_ON_CLOSE);
JLabel textLabel = new JLabel("Swing JLabel");
fr.add(textLabel, BorderLayout.NORTH);
JLabel imageLabel = new JLabel();
System.out.println(new File("javalogo.gif"));
System.out.println(new File("javalogo.gif").exists());
System.out.println(new File("javalogo.gif").getAbsolutePath());
imageLabel.setIcon(new ImageIcon("javalogo.gif"));
fr.add(imageLabel, BorderLayout.CENTER);

//A4

    JTabbedPane tabbedPane = new JTabbedPane();
    JPanel tab1 = new JPanel();
    tabbedPane.addTab("myTab1", tab1);
    tab1.add(new JLabel("This is a JLabel inside tab 1"));
    tab1.add(new JButton("JButton in tab 1"));
    tab1.add(new JToggleButton("JToggleButton in tab 1"));
    String[] items = {"item1", "item2"};
    tab1.add(new JComboBox(items)); JPanel tab2 = new JPanel();
    tabbedPane.addTab("myTab2", tab2);
    tab2.add(new JCheckBox("JCheckBox inside tab 2"));
    tab2.add(new JTextField("JTextField in tab 2"));
    tab2.add(new JList(items));
    tab2.add(new JSpinner());
    JPanel tab3 = new JPanel();
    tabbedPane.addTab("myTab3", tab3);
    JRadioButton radio1 = new JRadioButton("JRadioButton1");
    JRadioButton radio2 = new JRadioButton("JRadioButton2");
    ButtonGroup radioGroup = new ButtonGroup();
    radioGroup.add(radio1);
    radioGroup.add(radio2);
    tab3.add(radio1);
    tab3.add(radio2);
    tab3.add(new JRadioButton("Not in group"));
    tab3.add(new JTextArea("JTextArea inside tab 3", 3, 25));
    tab3.add(new JSlider(1, 10, 5));
    fr.add(tabbedPane, BorderLayout.CENTER);

    //A5 //comment out to remove big text field
    //JTextArea aLargeTextArea = new JTextArea();
   //JScrollPane scroller = new
   // JScrollPane(aLargeTextArea,
   // ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
    //ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   // fr.add(scroller, BorderLayout.CENTER);

//A6 - jtable

//String[] columnNames = {"First Name", "Last Name", "ID"};
//String[][] data = {
//{"Chris", "Bass", "123456"},
//{"Joe", "Bloggs", "654321"},
//{"Derek", "Trotter", "458645"},
//{"Mr", "Khan", "228252"},
//{"Basil", "Fawlty", "112288"},
//{"Sheldon", "Cooper", "336332"},
//{"Horatio", "Hornblower", "556484"},
//{"Edmund","Blackadder","557771"}
//};
//JTable myTable = new JTable(data, columnNames);
//JScrollPane scroller = new JScrollPane(myTable,
//ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
//ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//fr.add(scroller, BorderLayout.CENTER);

    
    
//A3
    JButton browse = new JButton("Browse...");
browse.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
    JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new
    FileNameExtensionFilter( "GIF Images", "gif");
    chooser.setFileFilter(filter);
    int returnVal = chooser.showOpenDialog(fr);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
    //System.out.println(“Chose to open this file: " +
          //  chooser.getSelectedFile().getAbsolutePath());
            imageLabel.setIcon(new ImageIcon(
            chooser.getSelectedFile().getAbsolutePath()));
        } // if
    } // actionPerformed
}); // ActionListener
fr.add(browse, BorderLayout.SOUTH);

    
}

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        T5Swing myswing = new T5Swing();
        // TODO code application logic here
        MyTableModel myTable = new MyTableModel();
    }
    
}
