package BTree;

import java.awt.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*; 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Binary Tree modified from https://www.baeldung.com/java-binary-tree

/**
 *
 * @author brend
 */
public class BinaryTree extends JFrame implements KeyListener {
    Node root;
    Node currentNode;
    JPanel panel;
    ArrayList<Node> nums = new ArrayList<Node>();
    Graphics g;
    
    
    int circleWidth = 100;
    int sWidth;
    int cWidth = 100;
    int cHeight = 40;
    
    
    
    
    public BinaryTree(){
      //  this.currentNode = this.root;
        this.addKeyListener(this);
    }
    
    @Override
    //Overrides awt paint
    public void paint(Graphics g) {
        //gives graphics to parent paint method
        this.g = g;
        super.paint(g);
        super.setPreferredSize(new Dimension(800,800));
        super.pack();
        
        
        g.setColor(java.awt.Color.red);
        
       //g.drawLine(400, 0, 400, 1000);
       g.setFont(g.getFont().deriveFont(15f));
       // this.draw(g);
       
        g.drawString("Press down arrow to initialize", 10 , 50);
        g.drawString("Press left, up, or right arrows, to traverse", 10 , 70);
        g.drawString("Press delete key to delete selected node", 10 , 90);
        g.drawString("Press insert key to add a node", 10 , 110);
       
        g.setFont(g.getFont().deriveFont(30f));
        sWidth = this.getWidth();
        this.traverseLevelOrder(g);
        
        //g.drawString(String.valueOf(node.num), sWidth / 2 - circleWidth / 2, (int) 40);
        //g.drawOval(sWidth / 2 - circleWidth / 2, 40, circleWidth, circleWidth);
        //g.drawString(String.valueOf(root.num), sWidth / 2 - circleWidth*1/8 , 100);
        
        //System.out.print("GOING GOING GOING");
        this.drawNode(g, root, sWidth / 2 - circleWidth / 2, 40, 100);
        
        panel = new JPanel();
        getContentPane().add(panel);
        //setSize(800,800);
        
    }
    
    
    
    
    private Node addNode(Node current, int num) {
        if (current == null) {
            return new Node(num);
        }

        if (num < current.num) {
            current.left = addNode(current.left, num);
            current.left.parent = current;
        } else if (num > current.num) {
            current.right = addNode(current.right, num);
            current.right.parent = current;
        } else {
            // value already exists
            return current;
        }

       return current;
    }
    public void add(int num) {
        root = addNode(root, num);
    }
    
    public BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();
        
    bt.add(6);
    bt.add(4);
    bt.add(3);
    bt.add(7);
    bt.add(2);
    bt.add(100);
    bt.add(58);
    bt.add(5);
    bt.add(27);
    bt.add(100000);
    
    
    
    //bt.add(9);
        return bt;
    }
    
    private boolean containsNodeRecursive(Node current, int num) {
        if (current == null) {
            return false;
        } 
        if (num == current.num) {
            return true;
        } 
        return num < current.num ? containsNodeRecursive(current.left, num): containsNodeRecursive(current.right, num);
    }
    public boolean containsNode(int num) {
        return containsNodeRecursive(root, num);
    }
    
    private Node deleteRecursive(Node current, int num) {
        if (current == null) {
            return null;
        }

        if (num == current.num) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.num = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;

        } 
        if (num < current.num) {
            current.left = deleteRecursive(current.left, num);
            return current;
        }
        current.right = deleteRecursive(current.right, num);
        return current;
        
    }
    
    public int findSmallestValue(Node root) {
        return root.left == null ? root.num : findSmallestValue(root.left);
        
    }
    
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }
 
    
   
    
    
    private Node drawCircle(Graphics g, Node current, int num){
        
        
        if (current == null) {
            return new Node(num);
        }

        if (num < current.num) {
            current.left = drawCircle(g,current.left, num);
        } else if (num > current.num) {
            current.right = drawCircle(g, current.right, num);
        } else {
            // value already exists
            return current;
        }
       return current;
    }
    
    public Node drawNode(Graphics g, Node current, int circleX, int circleY, int textY){
        
        if(current == null){
            System.out.print("I am null");
            return current;
        }
        
        if(current.left != null){
            drawNode(g, current.left, circleX - 75, circleY + 60, textY + 60);
           
        }
        
        if(current.right != null){
            System.out.print("drawing right");
            drawNode(g, current.right, circleX + 75, circleY + 60, textY + 60);
            
            //g.drawOval(circleX, circleY, 100, 100);
        }
        if(currentNode != null){
            if(current.num == currentNode.num){
            g.setColor(java.awt.Color.green);
            }
            else{
               g.setColor(java.awt.Color.red); 
            }
        }
        
        g.drawOval(circleX, circleY, 100, 100);
        
        g.drawString(String.valueOf(current.num), circleX + circleWidth*1/8, textY);

       return current;
        
       
    }
    
    //top down print
    public void traverseLevelOrder(Graphics g) {
    if (root == null) {
        return;
    }

    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);

    while (!nodes.isEmpty()) {
        
            
        
        Node node = nodes.remove();
        
       
        
        this.nums.add(node);
        System.out.print(" " + node.num);
        

        if (node.left != null) {
            nodes.add(node.left);
            
            //System.out.print("drawing");
            
            //g.drawString(String.valueOf(node.num), 60, 60);
           // g.drawOval(40,40, circleWidth, circleWidth);
            
            
        }

        if (node.right != null) {
            nodes.add(node.right);
           //g.drawOval(circleX + circleWidth, circleY + circleWidth, 100, 100);
        }
    }
    
}

    
    public void transverseUP(Node Current){
        //System.out.print("THE NODE ABOVE" + Current.num + " IS " + Current.parent.num);
        
        if(Current.parent != null){
            System.out.print(Current.parent.num + " ");
            this.currentNode = Current.parent;
        }
        
    }
    
    public void transverseLEFT(Node Current){
        //System.out.print("THE NODE to the left of " + Current.num + " IS " + Current.left.num);
        
        if(Current.left != null){
           System.out.print(Current.left.num + " ");
           this.currentNode = Current.left; 
        }
        
    }
    
    public void transverseRIGHT(Node Current){
        //System.out.print("THE NODE to the right of" + Current.num + " IS " + Current.right.num);
        
        if(Current.right != null){
            System.out.print(Current.right.num + " ");
            this.currentNode = Current.right;
        }
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            
            transverseUP(this.currentNode);
            revalidate(); 
             repaint();
            
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            
            transverseLEFT(this.currentNode);
            revalidate(); 
            repaint();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            
            transverseRIGHT(this.currentNode);
            revalidate(); 
             repaint();
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.print("Key pressed--");
            this.currentNode = root;
            System.out.print(root.num);
         
        }
        if(e.getKeyCode() == KeyEvent.VK_DELETE){
             System.out.print("deleting");
             this.delete(currentNode.num);
             //this.drawNode(g, root, sWidth / 2 - circleWidth / 2, 40, 100);
             //his.panel.
             revalidate(); 
             repaint();
             //this.delete(currentNode.num);
         }
        if(e.getKeyCode() == KeyEvent.VK_INSERT){
             
            String x = JOptionPane.showInputDialog(null, "This is the message", "This is the default text");
            
            try{
                this.add(Integer.parseInt(x));
               
            }
            catch(Exception error)
            {
                System.out.print("please only put in numbers");
            }
            
            
            revalidate(); 
            repaint();
             //this.delete(currentNode.num);
         }
        
    }
    
}

