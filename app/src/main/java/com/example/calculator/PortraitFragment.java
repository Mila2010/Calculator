package com.example.calculator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.calculator.TypeConvertor.strToDouble;

/**
 * Created by Millochka on 10/5/16.
 */

public class PortraitFragment extends Fragment {
    public static String TAG = "PortraitFragment";
    public static final String CLASS="PortraitFragment";

    private TextView mVisualizationView;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton21;
    private Button mButton22;
    private Button mButton23;
    private Button mButton24;
    private Button mButton31;
    private Button mButton32;
    private Button mButton33;
    private Button mButton34;
    private Button mButton45;
    private Button mButton41;
    private Button mButton42;
    private Button mButton43;
    private Button mButton44;
    private EditText mText;
    private TextView mResult;

    private Double mTempResult;
    private String mOperator="";
    private String mOperands="";
    private Double mFirstOperand;
    private Double mSecondOperand;
    private String mVisualization = " ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main,container, false);
    return view;}


    @Override
    public void onViewCreated(View view,Bundle savedInstanceState ){
        super.onViewCreated(view,savedInstanceState);
        mButton1 = (Button) view.findViewById(R.id.button1);
        mButton2 = (Button) view.findViewById(R.id.button2);
        mButton3 = (Button) view.findViewById(R.id.button3);
        mButton4 = (Button) view.findViewById(R.id.button4);
        mButton21 = (Button) view.findViewById(R.id.button21);
        mButton22 = (Button) view.findViewById(R.id.button22);
        mButton23 = (Button) view.findViewById(R.id.button23);
        mButton24 = (Button) view.findViewById(R.id.button24);
        mButton31 = (Button) view.findViewById(R.id.button31);
        mButton32 = (Button) view.findViewById(R.id.button32);
        mButton33 = (Button) view.findViewById(R.id.button33);
        mButton34 = (Button) view.findViewById(R.id.button34);
        mButton41 = (Button) view.findViewById(R.id.button41);
        mButton42 = (Button) view.findViewById(R.id.button42);
        mButton43 = (Button) view.findViewById(R.id.button43);
        mButton44 = (Button) view.findViewById(R.id.button44);
        mButton45 = (Button) view.findViewById(R.id.button45);
//        mText = (EditText) findViewById(R.id.inputText);
        mResult=(TextView) view.findViewById(R.id.outputText);
        //mVisualizationView = (TextView) view.findViewById(R.id.outputText1);


        mButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton1);


            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton2);

            }
        });

        mButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton3);

            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton4);

            }
        });
        mButton21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton21);

            }
        });
        mButton22.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton22);

            }
        });
        mButton23.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton23);

            }
        });
        mButton24.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton24);

            }
        });
        mButton31.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton31);

            }
        });
        mButton32.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton32);

            }
        });
        mButton33.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                processOnClick(mButton33);

            }
        });
        mButton34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mSecondOperand=strToDouble(mOperands);

                mResult.setText(mButton34.getText());
                switch(mOperator){

                    case "+":
                        mTempResult=mFirstOperand+mSecondOperand;
                        mResult.setText(Double.toString(mTempResult));
                        mOperands=Double.toString(mTempResult);

                        mOperands=Double.toString(mTempResult);
                        break;
                    case "-":
                        mTempResult=mFirstOperand-mSecondOperand;
                        mResult.setText(Double.toString(mTempResult));
                        mOperands=Double.toString(mTempResult);

                        mOperands=Double.toString(mTempResult);
                        break;
                    case "*":
                        mTempResult=mFirstOperand*mSecondOperand;
                        mResult.setText(Double.toString(mTempResult));
                        mOperands=Double.toString(mTempResult);

                        mOperands=Double.toString(mTempResult);
                        break;
                    case "%":
                        mTempResult=mFirstOperand/mSecondOperand;
                        mResult.setText(Double.toString(mTempResult));
                        mOperands=Double.toString(mTempResult);

                        mOperands=Double.toString(mTempResult);
                        break;

                }

            }
        });
        mButton41.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(mOperands.length()>0){
                    mOperands = mOperands.substring(0, mOperands.length()-1);
                    }
                else{
                    mOperands="";

                }

                mResult.setText(mOperands);


            }
        });

        mButton42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mFirstOperand = strToDouble(mOperands);
                mOperands="";
                mOperator=mButton42.getText().toString();

                mResult.setText(mOperator);


            }
        });

        mButton43.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mFirstOperand = strToDouble(mOperands);
                mOperands="";
                mOperator=mButton43.getText().toString();

                mResult.setText(mOperator);

            }
        });
        mButton44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mOperator.equals(null)&&mOperands.equals(null)){

                    mOperands = mOperands + mButton44.getText();
                    mResult.setText(mOperands);


                    }
                else{

                    mFirstOperand = strToDouble(mOperands);
                    mOperands="";
                    mOperator=mButton44.getText().toString();
                    mResult.setText(mOperator);


                }

            }
        });
        mButton45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mFirstOperand = strToDouble(mOperands);
                mOperands="";
                mOperator=mButton45.getText().toString();

                mResult.setText(mOperator);

            }
        });
    }

    public void displayOperations(Button button){
        mVisualization += button.getText();
        mVisualizationView.setText(mVisualization);

    }
    public void processOnClick(Button button){
        mOperands  +=button.getText();
        mResult.setText(mOperands);

    }



}
