/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javepadT7;

import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author FiercePC
 */

public class javapadT7 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        javapad jframe = new javapad();
        
        dataTable TheBrain = new dataTable(); //create object which is instance of datatable 
        //String searchTerm = "5473";
        //TheBrain.readRecord(searchTerm);
        //TheBrain.FileWrite();
        
        TheBrain.ReadFile();
        TheBrain.DataRead();
    }
}
