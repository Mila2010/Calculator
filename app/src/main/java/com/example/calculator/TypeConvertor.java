package com.example.calculator;

/**
 * Created by Millochka on 10/9/16.
 */

public abstract class TypeConvertor{

    private final static String TAG = "TypeConvertor";

    public static String dToString(Double input){

        String output = "";
        String temp = Double.toString(input);
        int i =0;
        if(input%1==0){
            while(temp.charAt(i)!='.'){
                output+=temp.charAt(i);
                i++;
            }
        }else{
            output=temp;
        }

        return output;
    }
}
