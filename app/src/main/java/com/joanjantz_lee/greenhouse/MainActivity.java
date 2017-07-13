package com.joanjantz_lee.greenhouse;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
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

        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = (String) dataSnapshot.getValue();
                // Put the luminosity onto the display
                tvLumin.setText(value);
                // Strip out anything not numeric.
                value=value.replaceAll("[^0-9.]","");

                // Turn the luminosity value (a string)
                // into a double for storage in the dataBlob.
                double L =Double.parseDouble(String.valueOf(value));
                dataBlob.setLuminosity(L);

                // Get the current max and min values and put them on the screen
                L = dataBlob.getMaxLuminosity();
                TextView outputLH = (TextView) findViewById(R.id.maxLuminosityInput);
                outputLH.setText(""+L);
                L = dataBlob.getMinLuminosity();
                TextView outputLL = (TextView) findViewById(R.id.minLuminosityInput);
                outputLL.setText(""+L);

                // Set the colour of the display accordingly.
                dataBlob.setLuminosityColor(tvLumin);

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

        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = (String) dataSnapshot.getValue();
                // Put the humidity onto the display
                tvHumid.setText(value);
                // Strip out anything not numeric.
                value=value.replaceAll("[^0-9.]","");

                // Turn the humidity value (a string)
                // into a double for storage in the dataBlob.
                double H =Double.parseDouble(String.valueOf(value));
                dataBlob.setHumidity(H);

                // Get the current max and min values and put them on the screen
                H = dataBlob.getMaxHumidity();
                TextView outputHH = (TextView) findViewById(R.id.maxHumidityInput);
                outputHH.setText(""+H);
                H = dataBlob.getMinHumidity();
                TextView outputHL = (TextView) findViewById(R.id.minHumidityInput);
                outputHL.setText(""+H);

                // Set the colour of the display accordingly.
                dataBlob.setHumidityColor(tvHumid);

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

        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = (String) dataSnapshot.getValue();
                // Put the temperature onto the display
                tvTemp.setText(value);
                // Strip out anything not numeric.
                value=value.replaceAll("[^0-9.]","");

                // Turn the temperature value (a string)
                // into a double for storage in the dataBlob.
                double T =Double.parseDouble(String.valueOf(value));
                dataBlob.setTemperature(T);

                // Get the current max and min values and put them on the screen
                T = dataBlob.getMaxTemperature();
                TextView outputTH = (TextView) findViewById(R.id.maxTempInput);
                outputTH.setText(""+T);
                T = dataBlob.getMinTemperature();
                TextView outputTL = (TextView) findViewById(R.id.minTempInput);
                outputTL.setText(""+T);

                // Set the colour of the display accordingly.
                dataBlob.setTempColor(tvTemp);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void setValues(View v){

        //minTemp
        EditText minTempInput = (EditText) findViewById(R.id.minTempInput);
        double minT = Double.parseDouble(minTempInput.getText().toString());
        dataBlob.setMinTemperature(minT);
        minT = dataBlob.getMinTemperature();
        tvTemp = (TextView)findViewById(R.id.tvTemp);
        dataBlob.setTempColor(tvTemp);

        //maxTemp
        EditText maxTempInput = (EditText) findViewById(R.id.maxTempInput);
        double maxT = Double.parseDouble(maxTempInput.getText().toString());
        dataBlob.setMaxTemperature(maxT);
        maxT = dataBlob.getMaxTemperature();
        tvTemp = (TextView)findViewById(R.id.tvTemp);
        dataBlob.setTempColor(tvTemp);

        //minLuminosity
        EditText minLumensInput = (EditText) findViewById(R.id.minLuminosityInput);
        double minL = Double.parseDouble(minLumensInput.getText().toString());
        dataBlob.setMinLuminosity(minL);
        minL = dataBlob.getMinLuminosity();
        tvLumin = (TextView)findViewById(R.id.tvLumin);
        dataBlob.setLuminosityColor(tvLumin);

        //maxLuminosity
        EditText maxLumensInput = (EditText) findViewById(R.id.maxLuminosityInput);
        double maxL = Double.parseDouble(maxLumensInput.getText().toString());
        dataBlob.setMaxLuminosity(maxL);
        maxL = dataBlob.getMaxLuminosity();
        tvLumin = (TextView)findViewById(R.id.tvLumin);
        dataBlob.setLuminosityColor(tvLumin);

        //minHumidity
        EditText minHumidityInput = (EditText) findViewById(R.id.minHumidityInput);
        double minH = Double.parseDouble(minHumidityInput.getText().toString());
        dataBlob.setMinHumidity(minH);
        minH = dataBlob.getMinHumidity();
        tvHumid = (TextView)findViewById(R.id.tvHumid);
        dataBlob.setHumidityColor(tvHumid);

        //maxHumidity
        EditText maxHumidityInput = (EditText) findViewById(R.id.maxHumidityInput);
        double maxH = Double.parseDouble(maxHumidityInput.getText().toString());
        dataBlob.setMaxHumidity(maxH);
        maxH = dataBlob.getMaxHumidity();
        tvHumid = (TextView)findViewById(R.id.tvHumid);
        dataBlob.setHumidityColor(tvHumid);
    }

}
