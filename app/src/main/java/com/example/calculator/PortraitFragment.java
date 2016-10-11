package com.example.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.calculator.TypeConvertor.dToString;
import static com.example.calculator.TypeConvertor.strToDouble;

/**
 * Created by Millochka on 10/5/16.
 */

public class PortraitFragment extends Fragment implements View.OnClickListener{
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
    //private Button mRad;

    private Double mTempResult;
    private String mOperator="";
    private String mOperands="";
    private Double mFirstOperand;
    private Double mSecondOperand;
    private String mVisualization = " ";


    private Button mRad;
    private Button mDeg;
    private Button mInv;
    private Button mSin;
    private Button mPi;
    private Button mE;
    private Button mAns;
    private Button mCos;
    private Button mTan;
    private Button mExp;
    private Button mFact;
    private Button mln;
    private Button mLog;
    private Button mSquereRoot;
    private Button mOParen;
    private Button mCParen;
    private Button mMod;

    LandscapeFragment mPFragmnet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main,container, false);
    return view;}


    @Override
    public void onViewCreated(View view,Bundle savedInstanceState ){
        super.onViewCreated(view,savedInstanceState);
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT){
            Initialization(view);
            setOnClick();

        }else if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){
            Initialization(view);
            setOnClick();
            mPFragmnet = new LandscapeFragment();
//            mRad= (Button) view.findViewById(R.id.Rad);
//            mRad.setOnClickListener(this);
//           mPFragmnet.toInitialize();
//            mPFragmnet.setOnClick();
            toInitializeS(view);

        }


        mButton34.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mSecondOperand=strToDouble(mOperands);

                mResult.setText(mButton34.getText());
                switch(mOperator){

                    case "+":
                        mTempResult=mFirstOperand+mSecondOperand;
                        mResult.setText(dToString(mTempResult));
                        mOperands=dToString(mTempResult);

                        break;
                    case "-":
                        mTempResult=mFirstOperand-mSecondOperand;
                        Toast.makeText(getContext(),dToString(mFirstOperand) + " - "+dToString(mSecondOperand) + " = " + dToString(mTempResult),Toast.LENGTH_LONG).show();

                        mResult.setText(dToString(mTempResult));
                        mOperands=dToString(mTempResult);

                        break;
                    case "*":
                        mTempResult=mFirstOperand*mSecondOperand;
                        mResult.setText(dToString(mTempResult));
                        mOperands=dToString(mTempResult);

                        break;
                    case "÷":

                        mTempResult=mFirstOperand/mSecondOperand;
                        mResult.setText(dToString(mTempResult));
                        mOperands=dToString(mTempResult);

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

    public void Initialization(View view){
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

    }

    public void setOnClick(){

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton21.setOnClickListener(this);
        mButton22.setOnClickListener(this);
        mButton23.setOnClickListener(this);
        mButton24.setOnClickListener(this);
        mButton31.setOnClickListener(this);
        mButton32.setOnClickListener(this);
        mButton33.setOnClickListener(this);
        mButton34.setOnClickListener(this);
        mButton41.setOnClickListener(this);
        mButton42.setOnClickListener(this);
        mButton43.setOnClickListener(this);
        mButton44.setOnClickListener(this);
        mButton45.setOnClickListener(this);

    }


    public void displayOperations(Button button){
        mVisualization += button.getText();
        mVisualizationView.setText(mVisualization);

    }
    public void processOnClick(Button button){
        mOperands  +=button.getText();
        mResult.setText(mOperands);

    }
    public void processOnClicktest(Button button){
        mOperands  +=button.getText();
        mResult.setText(mOperands);

    }

    public void toInitializeS(View view){
        mRad= (Button) view.findViewById(R.id.Rad);
        mDeg= (Button) view.findViewById(R.id.Deg);
        mInv= (Button) view.findViewById(R.id.Inv);
        mSin= (Button) view.findViewById(R.id.sin);
        mPi= (Button) view.findViewById(R.id.Pi);
        mE= (Button) view.findViewById(R.id.E);
        mAns= (Button) view.findViewById(R.id.Ans);
        mCos= (Button) view.findViewById(R.id.cos);
        mTan= (Button) view.findViewById(R.id.tan);
        mExp= (Button) view.findViewById(R.id.Exp);
        mFact= (Button) view.findViewById(R.id.fact);
        mln= (Button) view.findViewById(R.id.ln);
        mLog= (Button) view.findViewById(R.id.log);
        mSquereRoot= (Button) view.findViewById(R.id.squerRoot);
        mOParen= (Button) view.findViewById(R.id.oParen);
        mCParen= (Button) view.findViewById(R.id.cParen);
        mMod= (Button) view.findViewById(R.id.mod);



    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button1:case R.id.button2:case R.id.button3:case R.id.button4:
            case R.id.button21:case R.id.button22:case R.id.button23:case R.id.button24:
            case R.id.button31:case R.id.button32:case R.id.button33:
                Button tempButton=(Button) view.findViewById(view.getId());
                processOnClick(tempButton);
                break;

            case R.id.Rad:case R.id.Inv:case R.id.sin:case R.id.Deg:case R.id.Ans:

                Toast.makeText(view.getContext(),"It's working",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
