package com.example.calculator;


/**
 * Created by wesniemarcelin on 10/5/16.
 */


public class BinaryTree  {

    TreeNode root;

    public BinaryTree(){

        root = null;
    }

    public  BinaryTree (TreeNode root){

        this.root = root;
    }

    public void visit(TreeNode x){

        System.out.print(x.data + "  ");
    }

//    public BinaryTree(double data){
//
//        this.root.data = data;
//    }







    public void preOrder(TreeNode root){
        if (root == null) {
            return;
        }
            visit(root);
            preOrder(root.getLeft());
            preOrder(root.getRight());

        }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.getLeft());
        visit(root);
        inOrder(root.getRight());
    }

    public void postOrder(TreeNode root){
        if (root == null){
            return;
        }
        postOrder(root.getLeft());
        postOrder(root.getRight());
        visit(root);
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







