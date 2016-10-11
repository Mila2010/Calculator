package com.example.calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static com.example.calculator.Operator.ADDITION;
import static com.example.calculator.Operator.DIVISION;
import static com.example.calculator.Operator.MULTIPLICATION;
import static com.example.calculator.Operator.SUBTRACTION;

/**
 * Created by catwong on 10/4/16.
 */

public class CustomMath {

    public final double PI = Math.PI;
    public final double E = Math.E;
    ArrayList<String> calculateThis = new ArrayList<>();
    Stack<String> calculateStack = new Stack<>();
    ArrayDeque<Number> values = new ArrayDeque<>();
    ArrayDeque<Operator> operators = new ArrayDeque<>();


    public double add(int firstNum, int secondNum) {
        System.out.println("Add " + firstNum + " and " + secondNum);
        return firstNum + secondNum;
    }

    public double subtract(int firstNum, int secondNum) {
        System.out.println("Subtract " + secondNum + " from " + firstNum);
        return firstNum - secondNum;
    }

    public double multiply(int firstNum, int secondNum) {
        System.out.println("Multiply " + firstNum + " by " + secondNum);
        return firstNum * secondNum;
    }

    public double divide(int firstNum, int secondNum) {
        System.out.println("Divide " + firstNum + " by " + secondNum);
        return firstNum / secondNum;
    }

    public double percent(double a) {
        int toPercent = 100;

        System.out.println(a + " as a %");
        return a * toPercent;
    }

    public double exponent(double a, double b) {
        System.out.println(a + " to the " + b + " power");
        return Math.pow(a, b);
    }

    public double pi() {
        System.out.println("Pi is ");
        return PI;
    }

    public double e() {
        System.out.println("E is ");
        return E;
    }

    public double sin(double a) {
        System.out.println("sin " + a);
        return Math.sin(a);
    }

    public double cos(double a) {
        System.out.println("cos " + a);
        return Math.cos(a);
    }

    public double tan(double a) {
        System.out.println("double " + a);
        return Math.tan(a);
    }

    // TODO need to rework math logic
    public double log(double a) {
        System.out.println("log " + a);
        return Math.log(a);
    }

    public double sqrt(double a) {
        System.out.println("sqrt of " + a);
        return Math.sqrt(a);
    }

    public double cbrt(double a) {
        System.out.println("cbrt of " + a);
        return Math.cbrt(a);
    }

    public double abs(double a) {
        System.out.println("absolute value of " + a);
        return Math.abs(a);
    }

    public double round(double a) {
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

    public double ln(double a) {
        System.out.println("Natural log of " + a + " is:");
        return Math.log(a);
    }

    public int SciCalc(String userInput) {
        List<String> inputs = Arrays.asList(userInput.split(" "));
        for (String input : inputs) {
            switch (input.charAt(0)) {
                case '+':
                    operators.addLast(ADDITION);
                    break;
                case '-':
                    // TOOD handle negative
                    operators.addLast(SUBTRACTION);
                    break;
                case '/':
                    operators.addLast(DIVISION);
                    break;
                case '*':
                    operators.addLast(MULTIPLICATION);
                    break;
                default:
                    values.addLast(Integer.parseInt(input));
            }
        }
        // call methods
        multiplyDivide();
        addSubtract();

        return (int) values.removeLast();
    }

    public void addSubtract() {
        ArrayDeque<Number> valuesBuffer = new ArrayDeque<>();
        ArrayDeque<Operator> operatorsBuffer = new ArrayDeque<>();


        while (!operators.isEmpty()) {
            int a = (Integer) values.removeFirst();
            Operator operator = operators.removeFirst();
            if (operator == ADDITION || operator == SUBTRACTION) {
                int b = (Integer) values.removeFirst();
                values.addFirst(operator.evaluate(a, b));
            } else {
                valuesBuffer.addLast(a);
                operatorsBuffer.addLast(operator);
            }
        }

        valuesBuffer.addLast(values.removeFirst());

        values.addAll(valuesBuffer);
        operators.addAll(operatorsBuffer);
    }


    public void multiplyDivide() {
        ArrayDeque<Number> valuesBuffer = new ArrayDeque<>();
        ArrayDeque<Operator> operatorsBuffer = new ArrayDeque<>();

        while (!operators.isEmpty()) {
            int a = (Integer) values.removeFirst();
            Operator operator = operators.removeFirst();
            if (operator == MULTIPLICATION || operator == DIVISION) {
                int b = (Integer) values.removeFirst();
                values.addFirst(operator.evaluate(a, b));
            } else {
                valuesBuffer.addLast(a);
                operatorsBuffer.addLast(operator);
            }
        }

        valuesBuffer.addLast(values.removeFirst());

        values.addAll(valuesBuffer);
        operators.addAll(operatorsBuffer);
    }
}
