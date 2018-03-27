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
public class linktablemain {
    
    private int rowid;
    private int rowboardid;
    private int rowcheeseid;
    private int rowquantity;
    private float rowcost;
    
    public linktablemain(int prowid, int prowboardid, int prowcheeseid, int prowquantity, float prowcost)
    {
        this.rowid = prowid;
        this.rowboardid = prowboardid;
        this.rowcheeseid = prowcheeseid;
        this.rowquantity = prowquantity;
        this.rowcost = prowcost;
    }    
  
    
    public int getRowid()
    {
        return rowid; 
    }
    
    public int getRowboardid()
    {
        return rowboardid;
    }
    
    public int getRowcheeseid()
    {
        return rowcheeseid;
    }
    
    public int getRowquantitys()
    {
        return rowquantity;
    }
    
    public float getRowcost()
    {
        return rowcost;
    }

}
