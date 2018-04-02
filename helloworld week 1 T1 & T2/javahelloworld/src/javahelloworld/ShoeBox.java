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
public class ShoeBox extends Box{
    
    String shoe;
    Shoe myNewShoe = new Shoe("White", 15);
public ShoeBox(){
   
    Width = 5;
    Height = 5;
    Depth = super.Depth;   //using the depth from the Box class
    System.out.println("Created a new Shoebox!");  
    
}    

public void getShoe(){
        
    super.openLid();                            //myShoebox.openlid();
    System.out.println("Colour = " + myNewShoe.getColour()); 
    System.out.println("Size = " + myNewShoe.getSize()); 
    
    super.closeLid();
}
}
