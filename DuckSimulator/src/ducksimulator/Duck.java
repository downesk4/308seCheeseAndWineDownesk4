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
public abstract class Duck
{
    private IFlyBehaviour fFlyBehaviour;
    private IQuackBehaviour fQuackBehaviour;

    public Duck(IFlyBehaviour fFlyBehaviour, IQuackBehaviour fQuackBehaviour)
    {
        System.out.println("Created a new Duck object");
        this.fFlyBehaviour = fFlyBehaviour;
        this.fQuackBehaviour = fQuackBehaviour;
    }
    
    public void swim()
    {
        System.out.println("Duck swimming");
    }
    
    public abstract void display();
    
    public void performQuack()
    {
        fQuackBehaviour.quack();
    }
    
    public void performFly()
    {
        fFlyBehaviour.fly();
    }
    
    public void setQuackBehaviour(IQuackBehaviour qb)
    {
        fQuackBehaviour = qb;
    }
    
    public void setFlyBehaviour(IFlyBehaviour fb)
    {
        fFlyBehaviour = fb;
    }
    
}
