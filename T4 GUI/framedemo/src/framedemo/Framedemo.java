/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framedemo;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 *
 * @author downesk4
 */
public class Framedemo {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //canvas
        
        //fr.setLayout(new BorderLayout());
        //topPanel.setLayout(new BorderLayout());
        //topPanel.setSize(200, 200);
        //fr.add(BorderLayout.CENTER, topPanel);
        //final MyCanvas can = new MyCanvas();
       // topPanel.add(BorderLayout.CENTER, can);
        //fr.setSize(300, 300);

        
        
        //menu
        MenuItem menuItemClose = new MenuItem("Exit");      
        Frame fr = new Frame("Hello World");
        fr.setLayout(new BorderLayout());
        Panel topPanel = new Panel();
        Panel bottomPanel = new Panel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setSize(500, 500);

        //topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //bottomPanel.add(new TextArea("Area", 5, 20));
        //bottomPanel.add(new TextField("Field"));
        //bottomPanel.add(new Checkbox("Checkbox"));
        //Choice option = new Choice();
        //option.addItem("Choice Item 1");
        //option.addItem("Choice Item 2");
        //bottomPanel.add(option);

        
        Button buttons[] = new Button[5];
        for (int i = 0; i <= 4; i++) {
	buttons[i] = new Button("Button " + i);
} // end of for loop
        
        MenuBar mBar = new MenuBar();
        Menu menuFile = new Menu("File");
        Menu menuEdit = new Menu("Edit");
        Menu menuView = new Menu("View");
        Menu menuHelp = new Menu("Help");      
        menuFile.add(new MenuItem("Open..."));
        
        mBar.add(menuFile);
        mBar.add(menuEdit);
        mBar.add(menuView);
        mBar.add(menuHelp);
        fr.setMenuBar(mBar);
        
        //canvas top
        
        fr.add(BorderLayout.CENTER, topPanel);
        final MyCanvas can = new MyCanvas();
        topPanel.add(BorderLayout.CENTER, can);
        fr.setSize(300, 300);
        //canvas bottom
        
        //fr.add(BorderLayout.NORTH, topPanel);
        // fr.add(BorderLayout.SOUTH, bottomPanel);
        //topPanel.add(buttons[3]);
        //bottomPanel.add(buttons[4]);
        //fr.pack(); // preferred size of subcomponents
        fr.setVisible(true);
        
fr.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent we) {
        System.exit(0);
} });


}
        
}
