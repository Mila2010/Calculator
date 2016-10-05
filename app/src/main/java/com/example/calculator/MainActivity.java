package com.example.calculator;

    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {
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
            mButton1 = (Button) findViewById(R.id.button1);
            mButton2 = (Button) findViewById(R.id.button2);
            mButton3 = (Button) findViewById(R.id.button3);
            mButton4 = (Button) findViewById(R.id.button4);
            mButton21 = (Button) findViewById(R.id.button21);
            mButton22 = (Button) findViewById(R.id.button22);
            mButton23 = (Button) findViewById(R.id.button23);
            mButton24 = (Button) findViewById(R.id.button24);
            mButton31 = (Button) findViewById(R.id.button31);
            mButton32 = (Button) findViewById(R.id.button32);
            mButton33 = (Button) findViewById(R.id.button33);
            mButton34 = (Button) findViewById(R.id.button34);
            mButton41 = (Button) findViewById(R.id.button41);
            mButton42 = (Button) findViewById(R.id.button42);
            mButton43 = (Button) findViewById(R.id.button43);
            mButton44 = (Button) findViewById(R.id.button44);
            mButton45 = (Button) findViewById(R.id.button45);
//        mText = (EditText) findViewById(R.id.inputText);
            mResult=(TextView) findViewById(R.id.outputText);

//        if(mTempResult==null && mTempResult==null) {
            mButton1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton1.getText();
                    mResult.setText(mOperands);

                }
            });

            mButton2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton2.getText();
                    mResult.setText(mOperands);

                }
            });
//            mButton3.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    mOperator = mButton3.getText().toString();
//                    mResult.setText(mOperands);
//
//                }
//            });
            mButton3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton3.getText();
                    mResult.setText(mOperands);

                }
            });
        mButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    mOperands = mOperands + mButton4.getText();
                mResult.setText(mOperands);

            }
        });
            mButton21.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton21.getText();
                    mResult.setText(mOperands);

                }
            });
            mButton22.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton22.getText();
                    mResult.setText(mOperands);

                }
            });
            mButton23.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton23.getText();
                    mResult.setText(mOperands);

                }
            });
            mButton24.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton24.getText();
                    mResult.setText(mOperands);

                }
            });
            mButton31.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton31.getText();
                    mResult.setText(mOperands);

                }
            });
            mButton32.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton32.getText();
                    mResult.setText(mOperands);

                }
            });
            mButton33.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    mOperands = mOperands + mButton33.getText();
                    mResult.setText(mOperands);

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
                            break;
                        case "-":
                            mTempResult=mFirstOperand-mSecondOperand;
                            mResult.setText(Double.toString(mTempResult));
                            mOperands=Double.toString(mTempResult);
                            break;
                        case "*":
                            mTempResult=mFirstOperand*mSecondOperand;
                            mResult.setText(Double.toString(mTempResult));
                            mOperands=Double.toString(mTempResult);
                            break;
                        case "%":
                            mTempResult=mFirstOperand/mSecondOperand;
                            mResult.setText(Double.toString(mTempResult));
                            mOperands=Double.toString(mTempResult);
                            break;

                    }

                }
            });
            mButton41.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    if(mOperands.length()>0){
                    mOperands = mOperands.substring(0, mOperands.length()-1);}else{
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
                    if(mOperator.equals(null)&&!mOperands.equals(null)){
                    mFirstOperand = strToDouble(mOperands);
                    mOperands="";
                    mOperator=mButton44.getText().toString();
                    mResult.setText(mOperator);}
                else{

                        mOperands = mOperands + mButton44.getText();
                        mResult.setText(mOperands);

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

//    }
    }
