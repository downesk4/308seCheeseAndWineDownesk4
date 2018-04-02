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
public class Duckyys {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Duck myDuck = new ModelDuck();
        myDuck.display();
        myDuck.swim();
        myDuck.performQuack();
        myDuck.performFly();
        
        System.out.println("");
        myDuck.SetFlyType(new RocketPower());
        myDuck.performFly();
    }
    
}
