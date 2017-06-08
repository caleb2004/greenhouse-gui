package com.joanjantz_lee.greenhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GHdata dataBlob = new GHdata();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
