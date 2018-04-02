package javahelloworld;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author downesk4
 */

public abstract class Box {           //can be only acessed by child class
    
    byte Width, Height, Depth;   
    static boolean open = false;
    static int count = 0;             //field in a class = varible
    
    
     
public Box(){                         //needs to be public so shoebox can inherit theses constructors
    
    Width = 4;
    Height = 4;
    Depth = 4;
    System.out.println("Created a new box!");
    count++;
    
}

public void Flatten() {
    
    Width = 0;
    Height = 0;
    Depth = 0;
    System.out.println("The box has been flattened!");  
} 

public static int getCount(){
    
    return count;
    
}

public void openLid(){
    
    open = true;   
}

public void closeLid(){
       
    open = false;
}
}