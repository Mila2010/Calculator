package com.example.calculator;

/**
 * Created by catwong on 10/11/16.
 */

public enum Operator {

    DIVISION,
    MULTIPLICATION,
    ADDITION,
    SUBTRACTION,
    OPEN_PARENTHESES,
    CLOSED_PARENTHESES;

    public double evaluate(double a, double b){
        switch (this){
            case DIVISION:
                return a/b;
            case MULTIPLICATION:
                return a*b;
            case ADDITION:
                return a+b;
            case SUBTRACTION:
                return a-b;
            default:
                throw new IllegalStateException("operator not found");
        }
    }
}
