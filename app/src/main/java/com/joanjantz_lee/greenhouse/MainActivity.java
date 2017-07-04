package com.joanjantz_lee.greenhouse;

import android.graphics.Color;
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
        tvLumin = (TextView)findViewById(R.id.tvLumin);
        firebaseReference = firebaseDBInstance.getReference("Light: ");

        firebaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = (String) dataSnapshot.getValue();
                tvLumin.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void setHumidLevels() {
        tvHumid = (TextView)findViewById(R.id.tvHumid);
        firebaseReference = firebaseDBInstance.getReference("Humidity: ");

        firebaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = (String) dataSnapshot.getValue();
                tvHumid.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void setTempLevels() {
        tvTemp = (TextView)findViewById(R.id.tvTemp);
        firebaseReference = firebaseDBInstance.getReference("Temperature: ");

        firebaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = (String) dataSnapshot.getValue();
                // Strip out anything not numeric.
                value=value.replaceAll("[^0-9.]","");

                // Put the temperature onto the display
                tvTemp.setText(value+" C");

                // Turn the temperature value (a string)
                // into a double for storage in the dataBlob.
                double T =Double.parseDouble(String.valueOf(value));
                dataBlob.setTemperature(T);

                // Get the current max and min values and put them on the screen
                T = dataBlob.getMaxTemperature();
                TextView outputTH = (TextView) findViewById(R.id.tvThigh);
                outputTH.setText(""+T+"C");
                T = dataBlob.getMinTemperature();
                TextView outputTL = (TextView) findViewById(R.id.tvTlow);
                outputTL.setText(""+T+"C");

                // Set the colour of the display accordingly.
                dataBlob.setTempColor(tvTemp);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    protected void checkTemp(View v){
        double T = dataBlob.getTemperature();
        TextView outputT = (TextView) findViewById(R.id.tvTemp);
        outputT.setText(""+T+"C");
    }

    protected void setThi(View v){

        EditText inputT = (EditText) findViewById(R.id.numT);
        double T = Double.parseDouble(inputT.getText().toString());
        dataBlob.setMaxTemperature(T);
        T = dataBlob.getMaxTemperature();
        TextView outputTH = (TextView) findViewById(R.id.tvThigh);
        outputTH.setText(""+T+"C");
        tvTemp = (TextView)findViewById(R.id.tvTemp);

        dataBlob.setTempColor(tvTemp);
    }

    public void setTlow(View v){

        EditText inputT = (EditText) findViewById(R.id.numT);
        double T = Double.parseDouble(inputT.getText().toString());
        dataBlob.setMinTemperature(T);
        T = dataBlob.getMinTemperature();
        TextView outputTL = (TextView) findViewById(R.id.tvTlow);
        outputTL.setText(""+T+"C");

        tvTemp = (TextView)findViewById(R.id.tvTemp);

        dataBlob.setTempColor(tvTemp);
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

    protected void checkValues(View v){
        //allows all three functions with one button
        checkHumidity(v);
        checkLuminosity(v);
        checkTemp(v);
    }

}
