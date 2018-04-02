/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duckyys;

/**
 *
 * @author downesk4
 */
public class RedheadDuck extends Duck {
    
    public RedheadDuck()
    {
        super(new CanFly(), new CanQuack());
    }
    
    @Override
    public void display()
    {
        System.out.println("I am a Redhead Duck!");
    }
    
}
