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
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

import static com.example.calculator.R.id.oParen;
import static com.example.calculator.TypeConvertor.dToString;

////import static com.example.calculator.R.raw.destiny1;
//import static com.example.calculator.R.raw.destiny2;
//import static com.example.calculator.R.raw.destiny3;

/**
 * Created by Millochka on 10/5/16.
 */

public class PortraitFragment extends Fragment implements View.OnClickListener {
    public static String TAG = "PortraitFragment = ";
    private boolean mClickEqual = false;
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
    private static String mOperator = "";
    private String mOperands = "";
    private static String mFirstOperand = "";
    private static Double mSecondOperand = 0.0;

    private static List<String> mOperandArray = new ArrayList<>();

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }

    // THIS GIVES SUBCLASSES A CHANCE TO INITIALIZE THEMSELVES ONCE THEY KNOW
    // THEIR VIEW HEIRARCHY HAS BEEN COMPLETELY CREATE.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TO GET THE CURRENT CONFIGURATION ORIENTATION
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            Initialization(view);
            mButton41 = (Button) view.findViewById(R.id.button41);                  // PORTRAIT'S DELETE BUTTON
            mButton41.setOnClickListener(new View.OnClickListener() {               // PASS CLICKS
                public void onClick(View v) {
                    MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);
                    soundThree.start();
                    if (mOperands.length() > 0) {                                       // IF THERE ARE NUMBERS, DELETE FROM THE END TO ZERO
                        mOperands = mOperands.substring(0, mOperands.length() - 1);
                    } else {
                        mOperands = "";
                    }
                    mResult.setText(mOperands);                                     // RESET TEXT
                }
            });
            setOnClick();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {     // THIS IS LANDSCAPE MODE
            Initialization(view);                                                                            // PASS CLICKS
            setOnClick();
            toInitializeS(view);
            setOnClickS();
        }
        // TO RESTORE THEMSELVES TO A PREVIOUS STATE USING THE DATE STORED IN THIS BUNDLE.
        if (savedInstanceState != null) {
            mSharedPreferences = getActivity().getPreferences(Context.MODE_PRIVATE);  // GET THE SAVED VALUES
            mClickEqual = mSharedPreferences.getBoolean("mClickEqual", false);         // INITIALLY FALSE
            mSavedFromTextView = mSharedPreferences.getString("mResult", "7");       // mSavedFromTextView = "7"
            mOperator = mSharedPreferences.getString("mOperator", "");                 // Operator = ""
            mFirstOperand = mSharedPreferences.getString("mFirstOperand", "0");      // First Number = "0"
            mClickEqual = mSharedPreferences.getBoolean("mClickEqual", false);
            mIsRotated = true;
            Set<String> set = mSharedPreferences.getStringSet("mOperandArray", null); // Pass List of String
            mOperandArray = new ArrayList<String>(set);                               // ASSIGNING TO THE OPERAND ARRAY
            Collections.reverse(mOperandArray);                                       // PRINT IN ORDER
        }
        // MINUS BUTTON
        mButton44.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);
                soundThree.start();
                // AS LONG AS THERE IS NOT OPERATOR
                if (mOperator.equals("") && mOperands.equals("") || !mOperator.equals("") && mOperands.equals("")) {
                    mOperands = mOperands + mButton44.getText();     /// THE " # - " OR "-"
                    mResult.setText(mOperands);                      /// DISPLAY THE " # - " OR " - "
                    mClickEqual = false;                               /// SHARE FALSE FOR LANDSCAPE MODE
                } else {
                    processOnClickOperators(mButton44);              /// OTHERWISE, PROCEED TO OPERATORS
                }
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mIsRotated) {
            mResult.setText(String.valueOf(mSavedFromTextView));     /// RETURNING THE VALUE FROM ORIENTATION
        } else {
            mResult.setText("");
        }
    }

    public void Initialization(View view) {
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
        mResult = (TextView) view.findViewById(R.id.outputText);
        history = (TextView) view.findViewById(R.id.outputHistory);

    }

    public void setOnClick() {

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

    public void setOnClickS() {
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

    public void processOnClickNumbers(Button button) {
        if (mClickEqual) {                      // IF FALSE,
            mOperands = "";                     // CLEAR Operands
            Log.d(TAG,mOperands);//<---------------------------------------------------------------------------LOGGING
        }                                       // ELSE TRUE,
        mOperands += button.getText();          // ADD number(s) clicked to Operands
        Log.d(TAG,mOperands);//<---------------------------------------------------------------------------LOGGING
        mResult.setText(mOperands);             // DISPLAY number(s)
        Log.d(TAG,"mResult");//<---------------------------------------------------------------------------LOGGING
        mOperatorClicked = false;               // OPERATOR is false
        mClickEqual = false;                    // CLICKEQUAL is false
    }

    public void processOnClickOperators(Button button) {
        if (!mOperatorClicked) {                // Operator Clicked is TRUE
            Log.d(TAG,Boolean.toString(mOperatorClicked));//<---------------------------------------------------------------------------LOGGING
            mFirstOperand = mOperands;          // Assign number as First Number
            Log.d(TAG,mFirstOperand);//<---------------------------------------------------------------------------LOGGING
            mOperandArray.add(mOperands);       // ADD THE FIRST NUMBER TO THE NUMBER ARRAY
            mOperands = "";                     // clear numbers
            mOperator = button.getText().toString();     // Assign the button clicked to the operator
            mOperandArray.add(mOperator);                // Then, ADD THE OPERATOR TO THE NUMBER ARRAY
            mResult.setText(mOperator);                  // Display the Operator
            mOperatorClicked = true;                     // Operator Clicked is true
        } else {                                         // Else , false :
            mOperator = button.getText().toString();     // Assign the operatorbutton to the Operator
            mResult.setText(mOperator);                  // DISPLAY THE OPERATOR
            mOperandArray.set(mOperandArray.size() - 1, mOperator);  // Set the value at the end of the array
            mOperatorClicked = true;                    // Operator Click is true
        }
        mClickEqual = false;
    }

    public void toInitializeS(View view) {
        mRad = (Button) view.findViewById(R.id.Rad);
        mDeg = (Button) view.findViewById(R.id.Deg);
        mInv = (Button) view.findViewById(R.id.Inv);
        mSin = (Button) view.findViewById(R.id.sin);
        mPi = (Button) view.findViewById(R.id.Pi);
        mE = (Button) view.findViewById(R.id.E);
        mAns = (Button) view.findViewById(R.id.Ans);
        mCos = (Button) view.findViewById(R.id.cos);
        mTan = (Button) view.findViewById(R.id.tan);
        mExp = (Button) view.findViewById(R.id.Exp);
        mFact = (Button) view.findViewById(R.id.fact);
        mln = (Button) view.findViewById(R.id.ln);
        mLog = (Button) view.findViewById(R.id.log);
        mSquereRoot = (Button) view.findViewById(R.id.squerRoot);
        mOParen = (Button) view.findViewById(oParen);
        mCParen = (Button) view.findViewById(R.id.cParen);
        mMod = (Button) view.findViewById(R.id.mod);
        mAc = (Button) view.findViewById(R.id.ac);
    }

    public void applyExpression(String function) {
        if (mOperands.equals("")) {                  // IF THE NUMBER IS not clicked , THEN SHOW AN ERROR
            mResult.setText("ERROR");
        } else {
            mOperandArray.add(mOperands);            // add Number to the OperandArray
            mResult.setText(function + "(" + mOperands + ")");        // DISPLAY the function
            mOperandArray.set(mOperandArray.size() - 1, function + "(" + mOperands + ")");  // Replace THE LAST INDEX WITH THE "function(#)" in the OperandArray
            mOperands = mOperandArray.get(mOperandArray.size() - 1);  // GET THE LAST VALUE IN OperandArray AND ASSIGN TO just Operand
            mOperandArray.remove(mOperandArray.size() - 1);           // Then, REMOVE THE LAST VALUE IN THE OperandArray
        }
    }
    @Override
    public void onClick(View view){

        Button tempButton;
        OperationParsing operationParsed = null;
        MediaPlayer soundThree = MediaPlayer.create(getContext(), R.raw.sound_three);
        soundThree.start();

        switch (view.getId()) {

            // OPERANDS
            case R.id.button1:case R.id.button2:case R.id.button3:case R.id.button4:
            case R.id.button21:case R.id.button22:case R.id.button23:case R.id.button24:
            case R.id.button31:case R.id.button32:case R.id.button33:
                tempButton = (Button) view.findViewById(view.getId());
                processOnClickNumbers(tempButton);
                break;

            // EQUAL BUTTON
            case R.id.button34:
                if (!mClickEqual) {                         // if TRUE or NOT FALSE
                    history.setText("");                    // RESET THE HISTORY
                    mOperandArray.add(mOperands);           // ADD NUMBER INTO THE NUMBER ARRAY
                    for (int i = 0; i < mOperandArray.size(); i++) { // ADD EACH INPUT TO THE ARRAY
                        String input = mOperandArray.get(i);
                        history.append(input);
                    }
                    Log.d(TAG, String.valueOf(mOperandArray));//<---------------------------------------------------------------------------LOGGING
                    OperationParsing operationParsing = new OperationParsing(mOperandArray); // SEND OVER TO THE OPERATIONPARSING, WHERE IT CALCULATES
                    mTempResult = operationParsing.getResult();   // TEMPORARILY ASSIGNS THE ANSWER
                    mResult.setText(dToString(mTempResult));      // DISPLAY THE ANSWER
                    history.append("=" + dToString(mTempResult)); // Add the result to the history display
                    mOperands = dToString(mTempResult);           // Number assigns the temporary answer
                    setaToast();                                  // Set a toast
                    mOperandArray.clear();                        // CLEAR OperandArray
                } else if (mClickEqual){
                    history.setText("");                    // RESET THE HISTORY
                    // this ListIterator will read the mOperandArray backwards and get the last item
                    for (ListIterator<String> scientificOps = mOperandArray.listIterator(mOperandArray.size()); scientificOps.hasPrevious(); ) {
                        // the last value in the OperandArray is assigned to "theLastSciOps"
                        String theLastSciOps = scientificOps.previous();
                        theLastSciOps+= mOperands + ")";
                        mOperandArray.add(theLastSciOps);
                        OperationParsing parseSciOps = new OperationParsing(mOperandArray);
                        mTempResult = parseSciOps.getResult();   // TEMPORARILY ASSIGNS THE ANSWER
                        mResult.setText(dToString(mTempResult));      // DISPLAY THE ANSWER
                        history.append("=" + dToString(mTempResult)); // Add the result to the history display
                        mOperands = dToString(mTempResult);           // Number assigns the temporary answer
                        setaToast();                                  // Set a toast
                        mOperandArray.clear();
                    }
                    mResult.setText("");                          // If False, then show nothing
                }
                mClickEqual = true;                               // set ClickEqual = true.
                break;

            // DIVISION , MULTIPLY, PLUS
            case R.id.button42:case R.id.button43:case R.id.button45:
                tempButton = (Button) view.findViewById(view.getId());
                processOnClickOperators(tempButton);
                break;

            case R.id.Ans:
                if (mOperandArray != null) {                         // IF NUMBER ARRAY IS NOT EMPTY
                    operationParsed.getResult();                  // GET ANSWER FROM OPERATION PARSED
                }
                break;

            case R.id.Rad:case R.id.Inv:case R.id.Deg:
            case R.id.log:
                break;

            case R.id.cos:case R.id.sin:case R.id.tan:case R.id.ln:
                tempButton = (Button) view.findViewById(view.getId());
                applyExpression(tempButton.getText().toString());
                mClickEqual = false;
                break;

            case R.id.ac:
                mOperands = "";
                mResult.setText("");
                break;

            case oParen:case R.id.cParen:
                if (!mOperands.equals("")) {                                    // if the Operands are not empty
                    mOperandArray.add(mOperands);
                    mOperands = "";
                }
                mClickEqual = true;
                tempButton = (Button) view.findViewById(view.getId());
                mOperandArray.add(tempButton.getText().toString());
                processOnClickNumbers(tempButton);
                mResult.append(tempButton.getText().toString());
                break;
//
//            case R.id.cParen:
//                if (!mOperands.equals("")) {                                    // if the Operands are not empty
//                    mOperandArray.add(mOperands);
////                    mOperands = "";
//                }
//                mClickEqual = true;
//                tempButton = (Button) view.findViewById(view.getId());
//                mOperandArray.add(tempButton.getText().toString());
//                mResult.append(tempButton.getText().toString());
//                break;
        }
    }

    private void setaToast() {                                                  // SET A TOAST METHOD
        Random random = new Random();                                           // CREATE A NEW RANDOM
        int num = random.nextInt(10);                                           // RANDOMLY SELECT FROM 0 TO 9 NUMBERS
        Toast toast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);     // CREATE A TOAST
        ImageView view = new ImageView(getContext());                           // CREATE AN IMAGEVIEW TO PASS

        switch (num) {
            case 0:
                view.setImageResource(R.drawable.cattoasting);                  // I GET MY IMAGE RESOURCE
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);                // SET THE IMAGE ON THE PHONE IN THE CENTER VERTICAL, SO THE ORIGIN IS OF COURSE X = 0 , Y = 0
                toast.setView(view);                                            // YOU SET THE TOAST VIEW WITH THE IMAGE, YOU CAN FIND MORE METHODS IN THE TOAST.JAVA CLASS
                toast.show();                                                   // DISPLAY THE TOAST
                break;
            case 1:
                view.setImageResource(R.drawable.thisisanothercat);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
            case 2:
                view.setImageResource(R.drawable.milatoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
            case 3:
                view.setImageResource(R.drawable.wesnietoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
            case 4:
                view.setImageResource(R.drawable.hyuntoastin);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.setView(view);
                toast.show();
                break;
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {   //ANDROID SAVING SOME STATES (WHEN THE LAYOUT IS CHANGED, IT WILL CALL THE ONSAVEDINSTANCESTATE
        super.onSaveInstanceState(outState);

        SharedPreferences settings = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString("mResult", mResult.getText().toString());
        editor.putString("mOperands", mOperands);
        editor.putBoolean("mClickEqual", mClickEqual);
        editor.putString("mOperator", mOperator);
        editor.putString("mFirstOperand", mFirstOperand);

        Set<String> set = new HashSet<String>();
        set.addAll(mOperandArray);
        editor.putStringSet("mOperandArray", set);
        editor.apply();
        editor.commit();

    }


}
