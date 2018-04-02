/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahelloworld;

/**
 *
 * @author downesk4
 */
public class Shoe {
    
   private static String Colour;
   private static int Size;
   
 public Shoe(String C, int S){
         
   Colour = C;
   Size = S;
         
 }      


   
public static String getColour(){
    
    return Colour;   
}   

public static int getSize(){
    
    return Size;
}
    
}


