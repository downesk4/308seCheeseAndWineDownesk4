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
public class Javahelloworld {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Hello World!!!");
        // TODO code application logic here
        
        //Box myBox = new Box();                  //creating a new box
        
        //myBox.Flatten();                        //flattening the box
            
        ShoeBox myShoeBox = new ShoeBox();      //creating new shoebox
        
        myShoeBox.Flatten();                    //using inherited method
    
        myShoeBox.getCount();
        
        myShoeBox.getShoe();
    
    }
    
    
}
