package BTree;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brend
 */
public class Node {
    int num;
    
    Node parent;
    Node left;
    Node right;

    Node(int num) {
        this.num = num;
        right = null;
        left = null;
        parent = null;
    }
}

