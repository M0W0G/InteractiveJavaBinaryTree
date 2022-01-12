/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTree;

/**
 *
 * @author brend
 */
public class Tree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BinaryTree BT = new BinaryTree();
        BT = BT.createBinaryTree();
        //System.out.print(BT.nums);
        //BT.traverseLevelOrder();
        
        
        //TODO
        //THIS WORKS
        //PARENT CONCEPT WORKS, JUST WRITE ERROR CHECKING TO MAKE SURE
        //THAT IM NOT WALKING OFF THE TREE
        
        BT.setVisible(true);
        
        System.out.print("left: " + BT.root);
        
        //S.setVisible(true);
      
        
    }
    
}
