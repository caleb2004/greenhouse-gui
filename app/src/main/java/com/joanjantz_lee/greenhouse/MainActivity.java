package com.joanjantz_lee.greenhouse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import org.androidannotations.annotations.ViewById;


public class MainActivity extends AppCompatActivity {
    GHdata dataBlob = new GHdata();
    public FirebaseDatabase firebaseDBInstance = FirebaseDatabase.getInstance();
    public DatabaseReference firebaseReference;

    private TextView tvLumin;
    private TextView tvHumid;
    private TextView tvTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the displayed levels
        setLuminLevels();
        setHumidLevels();
        setTempLevels();
    }

    public void setLuminLevels() {
        //do stuff
    }

    public void setHumidLevels() {
        //do stuff
    }

    public void setTempLevels() {
        //do stuff
    }

    protected void checkTemp(View v){
        //double T = dataBlob.getTemperature();
        //TextView outputT = (TextView) findViewById(R.id.tvTemp);
        //outputT.setText(""+T+"C");

        firebaseReference = firebaseDBInstance.getReference("Temperature: ");
        firebaseReference.addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot snapshot)
            {
                Log.d("message","in the on data change method");
                String T= snapshot.getValue().toString();
                Log.d("temperature: ", T);
                //TextView outputT = (TextView) findViewById(R.id.tvTemp);
                //outputT.setText(""+T+"C");

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });


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
