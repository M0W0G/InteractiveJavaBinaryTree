/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BTree;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;  



/**
 *
 * @author brend
 */
/*
public class Screen extends JFrame implements MouseListener{
    BinaryTree BT;
    JPanel panel;
    
    
    public Screen(BinaryTree BT){
        this.BT = BT;

    }
    
@Override
    //Overrides awt paint
    public void paint(Graphics g) {
        //gives graphics to parent paint method
        super.paint(g);
        super.setPreferredSize(new Dimension(800,800));
        super.pack();
        
       
        g.setColor(java.awt.Color.red);
        
        this.draw(g);
        
        
        
    }
    
    public void draw(Graphics g){
        System.out.print("draw()");
        g.setColor(java.awt.Color.black);
        
        int circleX;
        int circleY;
        int sWidth = this.getWidth();
        int cWidth = 100;
        int cHeight = 40;
        
        int zoom = 1;
        
        g.setFont(g.getFont().deriveFont(30f));
        
        g.drawLine(400, 0, 400, 1000);
        
        
        //TODO:
        //Draw circle is working, now make it recursive
        drawCircle(g, sWidth / 2, 40, 100, 0);

       // System.out.print("Width: " + sWidth);
       // System.out.print("Zoom: " + zoom);
        
    }
    public void drawCircle(Graphics g, int circleX, int circleY, int circleWidth, int index){
        int sWidth = this.getWidth();
        double textY = circleY + circleWidth / 2;
        Node currentNode = this.BT.nums.get(index);
        
        
        System.out.print("index: " + index);
        
        if(index == 0){
            g.drawString(String.valueOf(currentNode.num), sWidth / 2 + circleWidth / 3 - circleWidth / 2, (int) textY);
            g.drawOval(circleX - circleWidth / 2, circleY, circleWidth, circleWidth);
            
            
        }
        index +=1;
            //Draws to left
            if(currentNod
                this.drawCircle(g, circleX - 30, circleY + 30, 100, index);
                
                System.out.print("less than!");
            }
            //Draws to right
            else{
                
            }

        return;
        
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
*/