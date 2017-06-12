package com.joanjantz_lee.greenhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    GHdata dataBlob = new GHdata();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    protected void checkTemp(View v){


        double T = dataBlob.getTemperature();
        TextView outputT = (TextView) findViewById(R.id.tvTemp);
        outputT.setText(""+T+"C");



    }

    protected void checkHumidity(View v){



        double H = dataBlob.getHumidity();
        TextView outputH = (TextView) findViewById(R.id.tvHumid);
        outputH.setText(""+H+"%");



    }

    protected void checkLuminosity(View v){



        double L = dataBlob.getLuminosity();
        TextView outputL = (TextView) findViewById(R.id.tvLumin);
        outputL.setText(""+L+"L");


    }



}
