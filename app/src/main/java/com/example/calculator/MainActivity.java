package com.example.calculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.start_page);
            if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){

            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new PortraitFragment(), PortraitFragment.TAG).commit();}

            else if(getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE){

                getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new LandscapeFragment(), LandscapeFragment.TAG).commit();
            }
        }


    }
