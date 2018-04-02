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
public class FlyNoWay implements IFlyBehaviour
{
    @Override
    public void fly() {
        System.out.println("I cannot fly");
    }
}
