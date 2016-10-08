package com.example.calculator;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
        private Button mButtonOne;
        private Button mButtonTwo;
        private Button mButtonThree;
        private Button mButtonFour;
        private Button mButtonFive;
        private Button mButtonSix;
        private Button mButtonSeven;
        private Button mButtonEight;
        private Button mButtonNine;
        private Button mButtonZero;
        private Button mButtonAdd;
        private Button mButtonSubtract;
        private Button mButtonDivide;
        private Button mButtonMultiply;
        private Button mButtonDelete;
        private Button mButtonResult;
        private EditText mText;
        private TextView mResult;
        private int mTempResult;
        private String mOperator = "";
        private String mOperands = "";
        private int mFirstOperand;
        private int mSecondOperand;


        //private List<String> mTempResult=new ArrayList<>();

        // private List<Button> calcButtons= ArrayList(
//        mOne,
//        mTwo,
//
// );
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mButtonOne  = (Button) findViewById(R.id.button_one);
            mButtonTwo = (Button) findViewById(R.id.button_two);
            mButtonThree = (Button) findViewById(R.id.button_three);
            mButtonFour = (Button) findViewById(R.id.button_four);
            mButtonFive = (Button) findViewById(R.id.button_five);
            mButtonSix = (Button) findViewById(R.id.button_six);
            mButtonSeven = (Button) findViewById(R.id.button_seven);
            mButtonEight = (Button) findViewById(R.id.button_eight);
            mButtonNine = (Button) findViewById(R.id.button_nine);
            mButtonZero = (Button) findViewById(R.id.button_zero);
            mButtonAdd = (Button) findViewById(R.id.button_add);
            mButtonSubtract = (Button) findViewById(R.id.button_subtract);
            mButtonDivide = (Button) findViewById(R.id.button_divide);
            mButtonMultiply = (Button) findViewById(R.id.button_multiply);
            mButtonDelete = (Button) findViewById(R.id.button_delete);
            mButtonResult = (Button) findViewById(R.id.button_result);
            mResult=(TextView) findViewById(R.id.outputText);


            mButtonOne.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonOne.getText();
                    mResult.setText(mOperands);
                }
            });

            mButtonTwo.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonTwo.getText();
                    mResult.setText(mOperands);

                }
            });
            mButtonThree.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperator = mButtonThree.getText().toString();
                    mResult.setText(mOperands);

                }
            });
            mButtonFour.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonFour.getText();
                    mResult.setText(mOperands);

                }
            });

            mButtonFive .setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonFive.getText();
                    mResult.setText(mOperands);

                }
            });
            mButtonSix.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonSix.getText();
                    mResult.setText(mOperands);

                }
            });
            mButtonSeven.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonSeven.getText();
                    mResult.setText(mOperands);

                }
            });
            mButtonEight.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonEight.getText();
                    mResult.setText(mOperands);

                }
            });
            mButtonNine.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonNine.getText();
                    mResult.setText(mOperands);

                }
            });
            mButtonZero.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonZero.getText();
                    mResult.setText(mOperands);

                }
            });

            mButtonAdd.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonAdd.getText();
                    mResult.setText(mOperands);
                }
            });

            mButtonSubtract.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonSubtract.getText();
                    mResult.setText(mOperands);
                }
            });
            mButtonDivide.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if(mOperands.length() > 0) {
                        mOperands = mOperands.substring(0, mOperands.length() - 1);
                    }
                    mResult.setText(mOperands);
                }
            });

            mButtonMultiply.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mFirstOperand = strToInt(mOperands);
                    mOperands="";
                    mOperator= mButtonMultiply.getText().toString();
                    mResult.setText(mOperator);
                }
            });

            mButtonDelete   .setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButtonDelete.getText();
                    mResult.setText(mOperands);

                }
            });

            mButtonResult.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mSecondOperand=strToInt(mOperands);

                    mResult.setText(mButtonResult.getText());
                    switch(mOperator){

                        case "+":
                            mTempResult=mFirstOperand+mSecondOperand;
                            mResult.setText(Integer.toString(mTempResult));
                            mOperands=Integer.toString(mTempResult);
                            break;
                        case "-":
                            mTempResult=mFirstOperand-mSecondOperand;
                            mResult.setText(Integer.toString(mTempResult));
                            mOperands=Integer.toString(mTempResult);
                            break;
                        case "*":
                            mTempResult=mFirstOperand*mSecondOperand;
                            mResult.setText(Integer.toString(mTempResult));
                            mOperands=Integer.toString(mTempResult);
                            break;
                        case "÷":
                            mTempResult=mFirstOperand/mSecondOperand;
                            mResult.setText(Integer.toString(mTempResult));
                            mOperands=Integer.toString(mTempResult);
                            break;
                    }

                }
            });

        }
        public static int strToInt( String str ){
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

//    }
    }
