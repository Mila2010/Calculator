package com.example.calculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by catwong on 10/4/16.
 */

public class CustomMath {

    public final double PI = Math.PI;
    public final double E = Math.E;
    ArrayList<String> calculateThis = new ArrayList<>();
    Stack<String> calculateStack = new Stack<>();


    public double add(double a, double b){
        System.out.println("Add " + a + " and " + b);
        return a + b;
    }

    public double subtract(double a, double b){
        System.out.println("Subtract " + b + " from " + a);
        return a - b;
    }

    public double multiply(double a, double b){
        System.out.println("Multiply " + a + " by " + b);
        return a * b;
    }

    public int divide(int firstNum, int secondNum){
        System.out.println("Divide " + firstNum + " by " + secondNum);
        return firstNum/secondNum;
    }

    public double percent(double a){
        int toPercent = 100;

        System.out.println(a + " as a %");
        return a * toPercent;
    }

    public double exponent(double a, double b){
        System.out.println(a + " to the " + b + " power");
        return Math.pow(a, b);
    }

    public double pi(){
        System.out.println("Pi is ");
        return PI;
    }

    public double e(){
        System.out.println("E is ");
        return E;
    }

    public double sin(double a){
        System.out.println("sin " + a);
        return Math.sin(a);
    }

    public double cos(double a){
        System.out.println("cos " + a);
        return Math.cos(a);
    }

    public double tan(double a){
        System.out.println("double " + a);
        return Math.tan(a);
    }

    // TODO need to rework math logic
    public double log(double a){
        System.out.println("log " + a);
        return Math.log(a);
    }

    public double sqrt(double a){
        System.out.println("sqrt of " + a);
        return Math.sqrt(a);
    }

    public double cbrt(double a){
        System.out.println("cbrt of " + a);
        return Math.cbrt(a);
    }

    public double abs(double a){
        System.out.println("absolute value of " + a);
        return Math.abs(a);
    }

    public double round(double a){
        System.out.println("round " + a + " to the nearest whole number");
        return Math.round(a);
    }

    public double factorial(double a) {
        double product = 1.0;

        for (double i = 1; i <= a; i++) {
            product = product * i;
        }
        System.out.println("factorial of " + a);
        return product;
    }

    public double ln(double a){
        System.out.println("Natural log of " + a + " is:");
        return Math.log(a);
    }

    public int SciCalc(String input){
        for (int i = 0; i < input.length(); i++) {
            String newString = Character.toString(input.charAt(i));
            calculateThis.add(newString);
        }
        calculateThis.add(null);
        Pemdas();
        return 0;
    }

    public void numbersBetweenParentheses(String string){

    }

    public int Pemdas(){
        //System.out.println("Inside Pemdas() ");
        System.out.println(calculateThis);
        for (int i = 0; calculateThis.get(i) != null; i++){
//            System.out.println("Made it passed first for loop");
            if (calculateThis.get(i).equals("(")){
                String newString = "";
//                System.out.println("inside parentheses");
//                System.out.println("i is " + calculateThis.get(i));
                for (int j = i+1; !calculateThis.get(j).equals(")"); j++){
                    newString += calculateThis.get(j) ;

//                    System.out.println("not equal closing parenthesis");
                    if (calculateThis.get(j+1).equals("/") && calculateThis.get(j+1) != null){

                        String firstNum = (String) calculateThis.get(j);
                        calculateThis.remove(j);
                        String operand = (String) calculateThis.get(j);
                        calculateThis.remove(j);
                        String secondNum = (String) calculateThis.get(j);
//
//                        System.out.println("First number is: " + firstNum + "index is " + (j));
//                        System.out.println("Operand number is: " + operand + "index is " + (j));
//                        System.out.println("Second number is: " + secondNum + "index is " + (j));

                        int firstVal = Integer.parseInt(firstNum);
                        int secondVal = Integer.parseInt(secondNum);
                        int result = divide(firstVal, secondVal);
                        String stringResult = Integer.toString(result);

                        calculateThis.set(j, stringResult);
//                        System.out.println(calculateThis);
                    }
                }

                numbersBetweenParentheses(newString);
                System.out.println(calculateThis);
            }
        }
        return 0;
    }
}

