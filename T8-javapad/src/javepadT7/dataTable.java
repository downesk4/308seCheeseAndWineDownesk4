/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javepadT7;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;


/**
 *
 * @author downesk4
 */
public class dataTable {
    private String filepath = "cheeses.txt";
    private String[] Headers;
    private List<RowOfData> EntireRow = new ArrayList<RowOfData>();
    
    dataTable()     
    {
        Headers = new String[9];  
        Headers[0] = "ID";
        Headers[1] = "Supplier";
        Headers[2] = "Cheese";
        Headers[3] = "style";
        Headers[4] = "origin";
        Headers[5] = "age";
        Headers[6] = "milktype";
        Headers[7] = "strength";
        Headers[8] = "quantity";
        //Headers[9] = "costPKG";
    }
    
    public void ReadFile()
    {
        try{
            Scanner x;
        
            x = new Scanner(new File(filepath));
            x.useDelimiter("[\n]");        //used to seperate fields in a file

            while(x.hasNext())  //condition checker, if no lines left this becomes false, terminating the loop
            {
                    String TempString = x.next();
                    String[] TempRow = TempString.split(",");
                    EntireRow.add(new RowOfData(9, TempRow)); //next element of RowOfData to list, with 9 items to row
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void DataRead()
    {
        for (RowOfData Row: EntireRow)
        {
            for (int i = 0; i < 10; i++)
            //for (String Col: Row.readdata())
            {
                System.out.print((i == 0) ? "" : ","); // only puts comma after first word of line.
                System.out.print(Row.readcol(i));
            }
            System.out.println();
        }
    }
    /*public void readRecord(String searchTerm)
    {
        Scanner x;
        
        boolean found = false;
        String ID = ""; String Supplier = ""; String Cheese = ""; 
        String style = ""; String origin = ""; String age = ""; 
        String milktype = ""; String strength = ""; String quantity = ""; 
        String costPKG = "";
                
        try
        {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[\n]");        //used to seperate fields in a file
 
            while(x.hasNext() && !found )  //condition checker, if no lines left this becomes false, terminating the loop
            {
                String TempString = x.next();
                String[] TempRow = TempString.split(",");
                EntireRow.recieveData(TempRow);
                
                if (EntireRow.sameData(0, searchTerm))
                {
                    found = true;
                }
            
                /*ID = x.next();               //reads all text till next comma
                Supplier = x.next();
                Cheese = x.next();
                style = x.next();
                origin = x.next();
                age = x.next();
                milktype = x.next();
                strength = x.next();
                quantity = x.next();
                costPKG = x.next();
                  
                if(ID.equals(searchTerm))   //is id = search term
                {
                    found = true;
                }
            }
            
            if (found)
            {
                for (int i = 0; i < 9; i++)
                {
                    System.out.print(Headers[i] + ": " + EntireRow.readcol(i) + ", ");
                }
                JOptionPane.showMessageDialog(null,"ID;"+ ID + " Supplier; " + Supplier + " Cheese;" + Cheese + " style;" + style + " Origin;" + origin + " age;" + age + " Milk type;" + milktype + " Strength;" + strength + " Qauntity:" + quantity + " costPKG;" + costPKG);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No Records");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Error");
        }
    }
    public void FileWrite()
    {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cheeses.txt"))) //created file writer for cheeses.txt
        {
             if (EntireRow.readdata() != null)    //check if empty
             {
                 for (String Col: EntireRow.readdata())         //loops through data
                     bufferedWriter.append(Col + ",");
                  bufferedWriter.append("\n");
             }
        }
        catch (IOException ex) 
        {
            ex.printStackTrace();
        }
    }*/

    
}


