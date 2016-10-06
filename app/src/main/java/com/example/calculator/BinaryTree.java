package com.example.calculator;


/**
 * Created by wesniemarcelin on 10/5/16.
 */


public class BinaryTree  {


    TreeNode root;

    public BinaryTree(){
        root = null;
    }

    public BinaryTree(double data){
        TreeNode Node = root;
    }


    public  BinaryTree (TreeNode root){
        this.root = root;
    }

    public void visit(TreeNode x){
        System.out.println(x.getData() + "  ");
    }

    public void preOrder(TreeNode root){
        if (root == null){
            visit(root);
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

//    public void add(Node parent, Node child, String orientation){
//        if(orientation == "left"){
//            parent.setLeft(child);
//        }
//        else if (orientation == "right"){
//            parent.setRight(child);
//        }
//    }

}







