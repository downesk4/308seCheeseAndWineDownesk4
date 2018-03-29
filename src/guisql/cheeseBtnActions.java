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

public class cheeseBtnActions extends ControlWindow {
    int pos = 0;
    
    public int first()
    {
        pos = 0;
        return pos;
    }
    
    public int next()
    {
        pos++;

        if(pos >= getCheeseList(txt_search.getText()).size())
        {
            pos = getCheeseList(txt_search.getText()).size()-1;
        }
        return pos;
    }
    
    public int last()
    {
        pos = getCheeseList(txt_search.getText()).size()-1;
        return pos;
    }
    
    public int previous()
    {
        pos--;

        if(pos < 0)
        {
            pos = 0;
        }
        return pos;
    }
    
}
