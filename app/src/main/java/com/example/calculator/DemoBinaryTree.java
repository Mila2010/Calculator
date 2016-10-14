package com.example.calculator;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * Created by wesniemarcelin on 10/5/16.
 */

public class DemoBinaryTree  {

    public static void main(String[] args) {
String expression = "2 * 3";



        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode('+');
        TreeNode n9 = new TreeNode('*');
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n7.setLeft(n5);
        n7.setRight(n2);

        n9.setLeft(n1);
        n6.setLeft(n7);
        n6.setRight(n9);

        BinaryTree myNew = new BinaryTree(n6);
        myNew.inOrder(myNew.root);
        System.out.println("");
        System.out.print(operate(n7));
        System.out.println();


    }

    public static void pemdas(TreeNode x){
        switch ((int) x.data){
            case '(':

        }
    }

    public static double operate(TreeNode x) {
        double a = x.getRight().data;
        double b = x.getLeft().data;
        switch ((int) x.data) {
            case '+':
                return a + b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '-':
                return a - b;
        }
        return 0;
    }

    public static void checkPrecedence(char a, char b){
        int decider;
        switch (a){
            case '/':
            switch (b){
                case '/':
                    decider = 0;
                    break;
                case '*':
                    decider = 1;
                    break;
                case '+':
                    decider =1;
                    break;
                case '-':
                    decider= 1;
                    break;
                default:
                    return;
            }
            case '*':
                switch (b){
                    case '/':
                        decider = 2;
                        break;
                    case '*':
                        decider = 0;
                        break;
                    case '+':
                        decider = 1;
                        break;
                    case '-':
                        decider = 1;
                        break;
                    default:
                        return;
                }
            case '+':
                switch (b){
                    case '/':
                        decider = 2;
                        break;
                    case '*':
                        decider = 2;
                        break;
                    case '+':
                        decider = 2;
                    case '-':
                        decider = 0;
                        default:
                            return;
                }
            case '-':
                switch (b){
                    case '/':
                        decider = 2;
                        break;
                    case '*':
                        decider = 2;
                        break;
                    case '+':
                        decider = 2;
                        break;
                    case '-':
                        decider = 0;
                        break;
                    default:
                        return;

                }
        }
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


}