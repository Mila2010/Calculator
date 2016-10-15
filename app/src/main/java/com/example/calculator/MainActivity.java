package com.example.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.start_page);


            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new PortraitFragment(), PortraitFragment.TAG).commit();


        }


    }
