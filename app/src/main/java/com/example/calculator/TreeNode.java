package com.example.calculator;

/**
 * Created by wesniemarcelin on 10/5/16.
 */

public class TreeNode {
    private double data;
    private TreeNode left;
    private TreeNode right;


    //Creates leaf node
    TreeNode(double data) {
        this.data = data;
        right = null;
        left = null;
    }

    public double getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
    public TreeNode getLeft(){
        return left;
    }
    public void setLeft(TreeNode left){
        this.left = left;
    }


    public TreeNode getRight(){
        return right;
    }
    public void setRight(TreeNode right){
        this.right = right;
    }


}
