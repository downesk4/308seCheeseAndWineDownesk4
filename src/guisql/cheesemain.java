//kieran downes 6406875

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guisql;

/**
 *
 * @author FiercePC
 */
public class cheesemain {
    
    private int id;
    private String name;
    private float price;
    private String style;
    private String supplier;
    private String origin;
    private String milk;
    private int age;
    private int strength;
    private String rating;
    private float stock;
    private String info;
    

    
    public cheesemain(int pid, String pname, float pprice, String pstyle, String psupplier, String porigin, String pmilk, int page, int pstrength, String prating, float pstock, String pinfo)
    {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.style = pstyle;
        this.supplier = psupplier;
        this.origin = porigin;
        this.milk = pmilk;
        this.age = page;
        this.strength = pstrength;
        this.rating = prating;
        this.stock = pstock;
        this.info = pinfo;
    }
    
    public int getid()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public float getPrice()
    {
        return price;
    } 
    
    public String getStyle()
    {
        return style; 
    }
    
    public String getSupplier()
    {
        return supplier;
    }   
    
    public String getOrigin()
    {
        return origin;
    }
    
    public String getMilk()
    {
        return milk;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public String getRating()
    {
        return rating;
    }
    
    public float getStock()
    {
        return stock;
    }
    
    public String getInfo()
    {
        return info;
    }
}
