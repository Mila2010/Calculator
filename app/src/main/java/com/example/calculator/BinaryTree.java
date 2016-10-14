package com.example.calculator;

import net.objecthunter.exp4j.*;
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

    public void visit(TreeNode x) {

        switch ((int) x.data) {
            case '+':
                System.out.print('+' + " ");
                break;
            case '/':
                System.out.print('/' + " ");
                break;
            case '*':
                System.out.print('*' + " ");
                break;
            case '-':
                System.out.print('-' + " ");
                break;
            default:
                System.out.print(x.data + "  ");
        }
    }




//public void evaluateMethod(TreeNode node){
//    switch(node.data){
//        case "+":
//            return node.getLeft().data + node.getRight().data;
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

    public double makeBinaryTree(String expression){
        Expression e = new ExpressionBuilder(expression)
                .variables("x", "y")
                .build()
                .setVariable("x", 2.3)
                .setVariable("y", 3.14);
        double result = e.evaluate();
        return result;
//        String element;
//        switch (element){
//            case '+'
//        })
    }
// Idea behind operation method
//    public Tree makeBinaryTree(expr) {
//        element = next element in expr
//        if element is a number:
//        return new Leave(element)
//        else: // element is an operator
//        left = makeBinaryTree(expr)
//        right = makeBinaryTree(expr)
//        return new Expr(left, right, element)
//    }

}







