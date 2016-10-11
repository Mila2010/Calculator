package com.example.calculator;

/**
 * Created by Millochka on 10/9/16.
 */

public abstract class TypeConvertor{


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


    public static int strToInt(String str ){
        int i = 0;
        int num = 0;
        boolean isNeg = false;


        if (str.charAt(0) == '-') {
            isNeg = true;
            i = 1;
        }


        while( i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0';
        }

        if (isNeg)
            num = -num;
        return num;
    }

    public static double strToDouble( String str ){
        int i = 0;
        double num = 0;
        double reminder=0;
        boolean isNeg = false;


        if (str.charAt(0) == '-') {
            isNeg = true;
            i = 1;
        }


        do{
            if(str.charAt(i)!='.'){
                num *= 10;

                num += str.charAt(i) - '0';
                System.out.println(num);
            }


            else{
                for(int j=str.length()-1;j>i;j--){

                    reminder+=str.charAt(j)-'0';
                    reminder/=10;
                    System.out.println(reminder);

                }

                break;

            }
            i++;
        }while( i < str.length());

        num+=reminder;

        if (isNeg)
            num = -num;
        return num;
    }
}
