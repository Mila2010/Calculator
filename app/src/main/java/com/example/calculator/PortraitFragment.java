package com.example.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
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
    private TextView history;
    private boolean mOperatorClicked = false;

    private Double mTempResult;
    private static String mOperator="";
    private String mOperands="";
    private static String mFirstOperand="";
    private static Double mSecondOperand=0.0;

    private static List<String> mOperandArray= new ArrayList<>();

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
    private static boolean mIsRotated = false;


    // BEGINNING OF GRAPHIC INSTALL, RETURNING A VIEW FROM HERE.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main,container, false);
        return view;}


    // THIS GIVES SUBCLASSES A CHANCE TO INITIALIZE THEMSELVES ONCE THEY KNOW
    // THEIR VIEW HEIRARCHY HAS BEEN COMPLETELY CREATE.
    @Override
    public void onViewCreated(View view,Bundle savedInstanceState ){
        super.onViewCreated(view,savedInstanceState);
        MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);


        // TO GET THE CURRENT CONFIGURATION ORIENTATION
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Initialization(view);
            mButton41 = (Button) view.findViewById(R.id.button41);                  // PORTRAIT'S DELETE BUTTON
            mButton41.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);
                    soundThree.start();
                    if(mOperands.length()>0){                                       // IF THERE ARE NUMBERS, DELETE FROM THE END TO ZERO
                         mOperands = mOperands.substring(0, mOperands.length()-1);
                    }
                    else{
                        mOperands="";
                        Log.d(TAG,"this is the else" + mOperands);
                    }
                    mResult.setText(mOperands);                                     // DISPLAY THE RESULT
                }
            });
            setOnClick();                                                           // THIS IS WHERE WE INITIALIZE THE PORTRAIT BUTTONSSSS
        }else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){     // THIS IS LANDSCAPE MODE
            Initialization(view);
            setOnClick();
            toInitializeS(view);
            setOnClickS();
        }

        // ACTIVITIES HAVE THE ABILITY, UNDER SPECIAL CIRCUMSTANCES,
        // TO RESTORE THEMSELVES TO A PREVIOUS STATE USING THE DATE STORED IN THIS BUNDLE.

        if (savedInstanceState != null) {                                           //  SHARE PORTRAIT TO LANDSCAPE
            mSharedPreferences=getActivity().getPreferences(Context.MODE_PRIVATE);  // DEFAULT OPERATION
            mClickEqual=mSharedPreferences.getBoolean("mClickEqual",false);         // TRUE OR FALSE
            mSavedFromTextView = mSharedPreferences.getString("mResult","7");       //
            mOperator=mSharedPreferences.getString("mOperator","");
            mFirstOperand = mSharedPreferences.getString("mFirstOperand","0");
            mClickEqual=mSharedPreferences.getBoolean("mClickEqual",false);
            mIsRotated = true;

            Set<String> set = mSharedPreferences.getStringSet("mOperandArray", null); // DOES NOT ACCEPT DUPLICATE ELEMENTS
            mOperandArray = new ArrayList<String>(set);                               // ASSIGNIN TO THE OPERANDARRAY

            Collections.reverse(mOperandArray);                                     // ARRAY IS RUNNING BACKWARDS

//            Log.d(TAG, "mClickEqual "+ Boolean.toString(mSharedPreferences.getBoolean("mClickEqual",false)));
//            Log.d(TAG, "mResult "+mSharedPreferences.getString("mResult","7"));
//            Log.d(TAG, mSharedPreferences.getString("mResult","7"));
//            Log.d(TAG, "mOperator "+mOperator);
//            Log.d(TAG, "mFirstOperand "+mSharedPreferences.getString("mFirstOperand","0"));
//            for(int i=0; i<mOperandArray.size();i++){
//                Log.d(TAG, "mOperandArray: "+mOperandArray.get(i));
//            }
        }

        // MINUS BUTTON
        mButton44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);
                soundThree.start();
                // AS LONG AS THERE IS NOT OPERATOR
                if(mOperator.equals("")&& mOperands.equals("")||!mOperator.equals("") && mOperands.equals("")){
                    mOperands = mOperands + mButton44.getText();     /// THE " # - " OR "-"
                    mResult.setText(mOperands);                      /// DISPLAY THE " # - " OR " - "
                    mClickEqual=false;                               /// SHARE FALSE FOR LANDSCAPE MODE
                    }
                else{
                    processOnClickOperators(mButton44);              /// OTHERWISE, PROCEED TO OPERATORS
                }
            }
        });
    }                                                                                   // END OF VIEW ONCREATE

    @Override
    public void onStart(){
        super.onStart();
        if(mIsRotated){
            mResult.setText(String.valueOf(mSavedFromTextView));
        }else{
        mResult.setText("");}
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
        history=(TextView) view.findViewById(R.id.outputHistory);

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
        if(mClickEqual){                        // IF FALSE,
            Log.d(TAG, "processOnClickNumbers : " + mClickEqual);
            mOperands="";}                      // CLEAR NUMBER
            mOperands  +=button.getText();      // ADD THE OPERATOR INTO THE NUMBER
        mResult.setText(mOperands);              // DISPLAY TO THE SCREEN AND ADD TO WHATEVER IS THERE
        mOperatorClicked=false;                 // OPERATOR NOT CLICKED
        mClickEqual=false;                      //
    }

    public void processOnClickOperators(Button button){

        if(!mOperatorClicked){              // YES, OPERATOR CLICKED
        mFirstOperand = mOperands;          // FIRST NUMBER ASSIGNED
        mOperandArray.add(mOperands);       // ADD THE FIRST NUMBER TO THE NUMBER ARRAY
            mOperands="";                   // OPERANDS = NULL

        mOperator=button.getText().toString();       // OPERATOR STRING == OPERATOR BUTTON
        mOperandArray.add(mOperator);                // ADD THE OPERATOR TO THE NUMBER ARRAY
        mResult.setText(mOperator);                  // DISPLAY OPERATOR CLICKED
        mOperatorClicked=true;                       // OPERATORCLICKED IS TRUE, FOR THE LANDSCAPE
//            for(int i=0; i<mOperandArray.size();i++){
//                Log.d(TAG, "mOperandArray: "+mOperandArray.get(i));
//            }
        } else{                                     // IF NO OPERATOR CLICKED
            mOperator=button.getText().toString();  // ASSIGN OPERATOR STRING TO THE OPERATOR THAT WAS CLICKED
            mResult.setText(mOperator);             //  DISPLAY THE OPERATOR
            mOperandArray.set(mOperandArray.size()-1,mOperator);  // THE INDEX OF THE OPERAND AND THE VALUE
            mOperatorClicked=true;                  // OPERATOR CLICKED
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

    public void applyExspression(String function){  // APPLY EXPRESSIONSSSSSSSSSS

        if(!mOperands.equals("")){                  // IF THE NUMBER IS NOT "" , THEN THERE IS AN ERROR
            mResult.setText("ERROR");
        }
        mOperandArray.add(mOperands);               // APPLY OPERANDS TO THE OPERAND STRING
        mResult.append(function);                   // DISPLAY THE FUNCTION
        mOperandArray.set(mOperandArray.size()-1,function +"("+mOperands+")");        //SET THE LAST THING WITH THE (#)
        mOperands=mOperandArray.get(mOperandArray.size()-1);  // ASSIGN OPERANDS STRING, GET THE LAST THING IN THE OPERAND STRING
        mOperandArray.remove(mOperandArray.size()-1);         // REMOVE THE LAST THING ON THE OPERAND STRING
    }

    @Override
    public void onClick(View view) {

        Button tempButton;
        OperationParsing operationParsed = null;
        MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);

        switch (view.getId()){

            // OPERANDS
            case R.id.button1:case R.id.button2:case R.id.button3:case R.id.button4:
            case R.id.button21:case R.id.button22:case R.id.button23:case R.id.button24:
            case R.id.button31:case R.id.button32:case R.id.button33:
                soundThree.start();
                tempButton=(Button) view.findViewById(view.getId());
                processOnClickNumbers(tempButton);
                break;

            // EQUAL BUTTON
            case R.id.button34:
                if(!mClickEqual){                           // IF TRUE
                    soundThree.start();
                    history.setText("");                    // RESET THE HISTORY
                    mOperandArray.add(mOperands);           // ADD NUMBER INTO THE NUMBER ARRAY
                    for(int i = 0; i < mOperandArray.size();i++) { // ADD EACH INPUT TO THE ARRAY
                        String input = mOperandArray.get(i);
                        history.append(input);
                    }
                    OperationParsing operationParsing = new OperationParsing(mOperandArray); // SEND OVER TO THE OPERATIONPARSING, WHERE IT CALCULATES
                    mTempResult= operationParsing.getResult();   // TEMPORARILY ASSIGNS THE ANSWER
                    mResult.setText(dToString(mTempResult));     // DISPLAY THE ANSWER
                    history.append("=" + dToString(mTempResult));
                    mOperands=dToString(mTempResult);            // CONVERT THE ANSWER TO NUMBER
                    setaToast();

                    Log.d(TAG,"EQUAL BUTTON: " + !mClickEqual);
                    Log.d(TAG,"EQUAL BUTTON: " + history);
                    Log.d(TAG,"EQUAL BUTTON: " + mTempResult);
                    Log.d(TAG,"EQUAL BUTTON: " + mResult);
                    Log.d(TAG,"EQUAL BUTTON: " + mOperands);

                mOperandArray.clear();                       // CLEAR THE NUMBER ARRAY
                } else {
                    mResult.setText("");                     // ELSE NOTHING
                }
                mClickEqual=true;
                break;

            case R.id.button42:case R.id.button43:case R.id.button45:
                soundThree.start();
                tempButton=(Button) view.findViewById(view.getId());
                processOnClickOperators(tempButton);
                break;

            case R.id.Ans:
                soundThree.start();
                if(mOperandArray!=null) {
                    operationParsed.getResult();
                    Log.d(TAG,"ANSWER : " + operationParsed.getResult());
                }
                break;

            case R.id.Rad:case R.id.Inv:case R.id.Deg:
            case R.id.cos: case R.id.sin:case R.id.tan:case R.id.log:case R.id.ln:
                soundThree.start();
                tempButton=(Button) view.findViewById(view.getId());
                applyExspression(tempButton.getText().toString());
                mClickEqual=false;
                break;

            case R.id.ac:
                soundThree.start();
                mOperands="";
                mResult.setText("");
                break;

            case R.id.oParen:case R.id.cParen:
                soundThree.start();
                if(!mOperands.equals("")){
                    mOperandArray.add(mOperands);
                    mOperands="";
                }
                tempButton=(Button) view.findViewById(view.getId());
                mOperandArray.add(tempButton.getText().toString());
                mResult.setText(tempButton.getText().toString());
                break;
        }

    }

    private void setaToast() {
        Random random = new Random();
        int num = random.nextInt(4);
        Toast toast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);
        ImageView view = new ImageView(getContext());

        MediaPlayer destiny1 = MediaPlayer.create(getContext(), R.raw.destiny1);
        MediaPlayer destiny2 = MediaPlayer.create(getContext(), R.raw.destiny2);
        MediaPlayer destiny3 = MediaPlayer.create(getContext(), R.raw.destiny3);
        MediaPlayer destiny4 = MediaPlayer.create(getContext(), R.raw.desinty4);

        switch(num) {
            case 1:
                destiny1.start();
                view.setImageResource(R.drawable.cattoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
            case 2:
                destiny2.start();
                view.setImageResource(R.drawable.milatoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
            case 3:
                destiny3.start();
                view.setImageResource(R.drawable.wesnietoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
            case 4:
                destiny4.start();
                view.setImageResource(R.drawable.hyuntoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
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
        set.addAll(mOperandArray);
        editor.putStringSet("mOperandArray",set);
        Log.d(TAG, "mFirstOperand"+ mFirstOperand);
        editor.apply();
        editor.commit();

    }
}
