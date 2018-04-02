

package duckyys;
public abstract class Duck
{
    
    private Quackable quacktype;
    private Flyable flytype;

    public Duck(Flyable Fly, Quackable Quack)
    {
        System.out.println("Created a new Duck object");
        this.flytype = Fly;
        this.quacktype = Quack;
    }
    
    public void swim()
    {
        System.out.println("Duck swimming");
    }
    
    public abstract void display();
    
    public void performQuack()
    {
        quacktype.Quack();
    }
    
    public void performFly()
    {
        flytype.Fly();
    }    
    public void SetFlyType(Flyable Fly)
    {
        flytype = Fly;
    }
    public void SetQuackType(Quackable Quack)
    {
        quacktype = Quack; 
    }
}
