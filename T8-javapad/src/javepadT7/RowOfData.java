/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javepadT7;

/**
 *
 * @author downesk4
 */
public class RowOfData {
    private String[] DataRow;
    RowOfData(int items, String[] s)
    {
        DataRow = new String[items];
        DataRow = s;
    }
    
    //can get data
public String[] readdata()              //send data      
{
    return DataRow;
}

public void recieveData(String[] i)      //recieve data 
{
    DataRow = i;
}

public String readcol(int i)              //search specific col    
{
    return DataRow[i];
}

 public boolean sameData(int i, String s) //check if word matches
 {
     if (DataRow[i].equals(s))
     {
         
         return true;
     }
     else
     {
         return false;
     }
 }
    
}
