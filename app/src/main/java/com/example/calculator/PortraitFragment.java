package com.example.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.example.calculator.TypeConvertor.dToString;

/**
 * Created by Millochka on 10/5/16.
 */

public class PortraitFragment extends Fragment implements View.OnClickListener{
    public static String TAG = "PortraitFragment";
    private boolean mClickEqual=false;
    private SharedPreferences mSharedPreferences;
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
    private TextView mResult;
    private boolean mOperatorClicked = false;
    //private Button mRad;

    private Double mTempResult;
    private static String mOperator="";
    private String mOperands="";
    private static String mFirstOperand="";
    private static Double mSecondOperand=0.0;

    private static List<String> mOperand= new ArrayList<>();



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
    private Button mAc;
    static String mSavedFromTextView;
    private static boolean mIsRotated =false;

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
            mButton41 = (Button) view.findViewById(R.id.button41);
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
            setOnClick();

        }else if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){

            Initialization(view);
            setOnClick();
            toInitializeS(view);
            setOnClickS();

        }

        if (savedInstanceState != null) {
            mSharedPreferences=getActivity().getPreferences(Context.MODE_PRIVATE);
            mClickEqual=mSharedPreferences.getBoolean("mClickEqual",false);
            mSavedFromTextView = mSharedPreferences.getString("mResult","7");
            mOperator=mSharedPreferences.getString("mOperator","");
            mFirstOperand = mSharedPreferences.getString("mFirstOperand","0");
            mClickEqual=mSharedPreferences.getBoolean("mClickEqual",false);
            mIsRotated = true;
            Set<String> set = mSharedPreferences.getStringSet("mOperand", null);

            mOperand =new ArrayList<String>(set);

            Collections.reverse(mOperand);
            Log.d(TAG, "mClickEqual "+ Boolean.toString(mSharedPreferences.getBoolean("mClickEqual",false)));

            Log.d(TAG, "mResult "+mSharedPreferences.getString("mResult","7"));
            Log.d(TAG, mSharedPreferences.getString("mResult","7"));
            Log.d(TAG, "mOperator "+mOperator);
            Log.d(TAG, "mFirstOperand "+mSharedPreferences.getString("mFirstOperand","0"));
            for(int i=0; i<mOperand.size();i++){
                Log.d(TAG, "mOperand: "+mOperand.get(i));
            }
        }

        mButton44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(mOperator.equals("")&&mOperands.equals("")||!mOperator.equals("")&&mOperands.equals("")){

                    mOperands = mOperands + mButton44.getText();
                    mResult.setText(mOperands);
                    mClickEqual=false;


                    }
                else{

                    processOnClickOperators(mButton44);


                }

            }
        });

    }

    @Override
    public void onStart(){
        super.onStart();

        if(mIsRotated){
            mResult.setText(String.valueOf(mSavedFromTextView));
        }else{
        mResult.setText("0");}
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

        mButton42 = (Button) view.findViewById(R.id.button42);
        mButton43 = (Button) view.findViewById(R.id.button43);
        mButton44 = (Button) view.findViewById(R.id.button44);
        mButton45 = (Button) view.findViewById(R.id.button45);
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
        mButton42.setOnClickListener(this);
        mButton43.setOnClickListener(this);
        mButton45.setOnClickListener(this);

    }

    public void setOnClickS(){
        mRad.setOnClickListener(this);
        mDeg.setOnClickListener(this);
        mInv.setOnClickListener(this);
        mSin.setOnClickListener(this);
        mPi.setOnClickListener(this);
        mE.setOnClickListener(this);
        mAns.setOnClickListener(this);
        mCos.setOnClickListener(this);
        mTan.setOnClickListener(this);
        mExp.setOnClickListener(this);
        mFact.setOnClickListener(this);
        mln.setOnClickListener(this);
        mLog.setOnClickListener(this);
        mSquereRoot.setOnClickListener(this);
        mOParen.setOnClickListener(this);
        mCParen.setOnClickListener(this);
        mMod.setOnClickListener(this);
        mAc.setOnClickListener(this);
    }


    public void processOnClickNumbers(Button button){
        if(mClickEqual){
            mOperands="";}

            mOperands  +=button.getText();
        mResult.setText(mOperands);

        mOperatorClicked=false;
        mClickEqual=false;



    }
    public void processOnClickOperators(Button button){

        if(!mOperatorClicked){
        mFirstOperand = mOperands;
        mOperand.add(mOperands);

        mOperands="";
        mOperator=button.getText().toString();
        mOperand.add(mOperator);
        mResult.setText(mOperator);
        mOperatorClicked=true;
            for(int i=0; i<mOperand.size();i++){
                Log.d(TAG, "mOperand: "+mOperand.get(i));
            }
        } else{
            mOperator=button.getText().toString();
            mResult.setText(mOperator);
            mOperand.set(mOperand.size()-1,mOperator);
            mOperatorClicked=true;
        }

        mClickEqual=false;
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
        mAc=(Button) view.findViewById(R.id.ac);


    }

    public void applyExspression(String function){


        if(!mOperands.equals("")){
            mResult.setText("ERROR");
        }
        mOperand.add(mOperands);
        mResult.setText(function);
        mOperand.set(mOperand.size()-1,function +"("+mOperands+")");
        mOperands=mOperand.get(mOperand.size()-1);
        mOperand.remove(mOperand.size()-1);
    }


    @Override
    public void onClick(View view) {
        Button tempButton;

        switch (view.getId()){
            case R.id.button1:case R.id.button2:case R.id.button3:case R.id.button4:
            case R.id.button21:case R.id.button22:case R.id.button23:case R.id.button24:
            case R.id.button31:case R.id.button32:case R.id.button33:
                tempButton=(Button) view.findViewById(view.getId());
                processOnClickNumbers(tempButton);
                for(int i=0; i<mOperand.size();i++){
                    Log.d(TAG, "mOperand: "+mOperand.get(i));
                }
                break;
            case R.id.button34:

                if(!mClickEqual){

                    mOperand.add(mOperands);
                    OperationParsing operationParsing =new OperationParsing(mOperand);

                mTempResult= operationParsing.getResult();
                    for(int i=0; i<mOperand.size();i++){
                        Log.d(TAG, "mOperand: "+mOperand.get(i));
                    }
                mResult.setText(dToString(mTempResult));
                mOperands=dToString(mTempResult);
                mOperand.clear();
                    }
                else {mResult.setText("");}
                mClickEqual=true;

                break;
            case R.id.button42:case R.id.button43:case R.id.button45:
                tempButton=(Button) view.findViewById(view.getId());
                processOnClickOperators(tempButton);

                break;
            case R.id.Rad:case R.id.Inv:case R.id.Deg:case R.id.Ans:

                Toast.makeText(view.getContext(),"It's working",Toast.LENGTH_LONG).show();
                break;
            case R.id.cos: case R.id.sin:case R.id.tan:case R.id.log:case R.id.ln:
                tempButton=(Button) view.findViewById(view.getId());
                applyExspression(tempButton.getText().toString());
                mClickEqual=false;
                break;
            case R.id.ac:
                mOperands="";
                mResult.setText("");

                break;

            case R.id.oParen:case R.id.cParen:

                if(!mOperands.equals("")){
                    mOperand.add(mOperands);
                    mOperands="";
                }
                tempButton=(Button) view.findViewById(view.getId());
                mOperand.add(tempButton.getText().toString());
                mResult.setText(tempButton.getText().toString());

                break;
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("mResult", mResult.getText().toString());
        editor.putString("mOperands",mOperands);
        editor.putBoolean("mClickEqual",mClickEqual);
        editor.putString("mOperator",mOperator);
        editor.putString("mFirstOperand",mFirstOperand);

        Set<String> set = new HashSet<String>();
        set.addAll(mOperand);
        editor.putStringSet("mOperand",set);
        Log.d(TAG, "mFirstOperand"+ mFirstOperand);
        editor.apply();
        editor.commit();

    }


}
