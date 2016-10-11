package com.example.calculator;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Stack;

/**
 * Created by Millochka on 10/5/16.
 */

public class LandscapeFragment implements View.OnClickListener{

    View view;
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

    private Stack<String> mUserInput= new Stack();


public void toInitialize(){
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

public void setOnClick(){
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
}



    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.Rad:case R.id.Inv:case R.id.sin:case R.id.Deg:case R.id.Ans:

                Toast.makeText(view.getContext(),"It's working",Toast.LENGTH_LONG).show();
                break;

        }



    }
}
