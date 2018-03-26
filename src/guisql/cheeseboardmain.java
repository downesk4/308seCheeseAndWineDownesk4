//kieran downes 6406875

package guisql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FiercePC
 */
public class cheeseboardmain {
    
    private int boardid;
    private String boardname;
    private float boardcost;
    private String boardstatus;
    
    public cheeseboardmain(int pboardid, String pboardname, float pboardcost, String pboardstatus)
    {
        this.boardid = pboardid;
        this.boardname = pboardname;
        this.boardcost = pboardcost;
        this.boardstatus = pboardstatus;
    }    
  
    
    public int getBoardid()
    {
        return boardid; 
    }
    
    public String getBoardname()
    {
        return boardname;
    }
    
    public float getBoardcost()
    {
        return boardcost;
    }
    
    public String getBoardstatus()
    {
        return boardstatus;
    }
}
