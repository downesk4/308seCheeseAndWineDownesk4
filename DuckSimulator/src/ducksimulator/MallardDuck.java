/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ducksimulator;

/**
 *
 * @author Chris
 */
public class MallardDuck extends Duck
{
    public MallardDuck()
    {
        super(new FlyWithWings(), new Quack());
    }
    
    @Override
    public void display()
    {
        System.out.println("I am a real Mallard Duck");
    }
    
}
