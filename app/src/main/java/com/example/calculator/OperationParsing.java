package com.example.calculator;

import android.util.Log;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.List;

/**
 * Created by Millochka on 10/13/16.
 */

public class OperationParsing {


    private final String TAG = "OperationParsing";
    public Expression expression ;

    public Double result;

    public OperationParsing(List<String> input){

        expression = new Expression(revertToString(input));

        setResult(expression.calculate());

    }



    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {

        this.result = result;
    }

    public String revertToString(List<String> input){
        String output="";

        for(String string: input){
            if(string.equals("÷")){
                output+="/";
            }else {
            output+=string;}
        }
        Log.d(TAG, output);
        return output;
    }
}
