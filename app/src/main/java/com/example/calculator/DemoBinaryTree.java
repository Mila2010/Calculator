package com.example.calculator;

import org.w3c.dom.Node;

/**
 * Created by wesniemarcelin on 10/5/16.
 */

public class DemoBinaryTree {

    public static void main(String[] args) {
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n9= new TreeNode(9);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1= new TreeNode(1);


        n7.setLeft(n5);
        n7.setRight(n2);

        n9.setLeft(n1);
        n1.setLeft(n7);
        n1.setRight(n9);

        BinaryTree myNew = new BinaryTree(n6);
        myNew.preOrder(myNew.root);
//        System.out.println(myNe);
    }
}