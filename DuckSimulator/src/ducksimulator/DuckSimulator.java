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
public class DuckSimulator
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Duck myDuck = new MallardDuck();
        myDuck.display();
        myDuck.swim();
        myDuck.performQuack();
        myDuck.performFly();
        
        System.out.println("");
        
        // With composition we can change duck behaviour dynamically...
        myDuck.setFlyBehaviour(new FlyNoWay());
        myDuck.setQuackBehaviour(new Squeak());
        myDuck.performQuack();
        myDuck.performFly();
    }
    
}
