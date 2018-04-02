/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framedemo;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


/**
 *
 * @author downesk4
 */
public class MyCanvas extends Canvas{
    @Override public void paint(Graphics g){
    // this is called on a repaint()
        int red = (int) (Math.random()*256);
        int green = (int) (Math.random()*256);
        int blue = (int) (Math.random()*256);
        g.setColor(new Color(red, green, blue));
        g.drawString("Canvas", 100, 100);
        g.fillRect(40, 40, 50, 50);
        
        System.out.println("height: " + this.getSize().height + "width: " + this.getSize().width);

    } // end of paint method

}
