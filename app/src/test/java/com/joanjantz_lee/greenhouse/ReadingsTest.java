package com.joanjantz_lee.greenhouse;

import android.content.Intent;
import android.support.annotation.RequiresPermission;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.wolkabout.hexiwear.activity.ReadingsActivity;
//import com.wolkabout.hexiwear.model.Characteristic;
//import com.wolkabout.hexiwear.service.BluetoothService;

import org.junit.Before;
import org.junit.Test;

import static com.joanjantz_lee.greenhouse.R.id.tvTemp;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class ReadingsTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    //create fake objects for outside the scope of the test with mocks

    @Mock
    private DatabaseReference firebaseReference;

    @Mock
    private FirebaseDatabase firebaseDBInstance;

    private TextView tvLumin;

    @Mock
    private TextView tvHumid;

    @Mock
    private TextView tvTemp;

    //temp high and low

    @Mock
    private TextView outputTH;

    @Mock
    private TextView outputTL;

    //lumin high and low

    @Mock
    private TextView outputLH;

    @Mock
    private TextView outputLL;

    //humidity high and low

    @Mock
    private TextView outputHH;

    @Mock
    private TextView outputHL;

    @Mock
    private View v;

    //inject your fake objects into the class you are testing
    //@InjectMocks
    private MainActivity sut;

    @SuppressWarnings("deprecation")
    public ReadingsTest()
    {
        super("com.joanjantz_lee.greenhouse.MainActivity", MainActivity.class);
    }

    @Before
    @Override
    public void setUp() throws Exception{
        super.setUp();
        mainActivity = this.getActivity();

        tvLumin = (TextView) mainActivity.findViewById(R.id.tvLumin);

        //set what will be returned when methods called
        MockitoAnnotations.initMocks(this);

        super.setUp();
        when(firebaseDBInstance.getReference(anyString())).thenReturn(firebaseReference);
    }

    @Test
    public void testGetTemp() throws Exception {
        //read temp from firebase
        sut.setTempLevels();
        verify(tvTemp, times(1)).setText(anyString());
    }

    @Test
    public void testGetHumidity() throws Exception {
        //read humidity from firebase
        sut.setHumidLevels();
        verify(tvHumid, times(1)).setText(anyString());
    }

    @Test
    public void testGetLuminocity() throws Exception {
        //read luminocity from firebase
        sut.setLuminLevels();
        verify(tvLumin, times(1)).setText(anyString());
    }

    @Test
    public void testSetTempHigh() throws Exception {
        String tempHighRange = "25";
        //sut.setThi(v);
        verify(outputTH.toString()).equals(tempHighRange);
    }

    @Test
    public void testSetTempLow() throws Exception {
        String tempLowRange = "5";
        //sut.setTlow(v);
        verify(outputTL.toString()).equals(tempLowRange);
    }

    @Test
    public void testSetLuminHigh() throws Exception {
        String luminHighRange = "25";
        //sut.setThi(v);
        verify(outputLH.toString()).equals(luminHighRange);
    }

    @Test
    public void testSetLuminLow() throws Exception {
        String luminLowRange = "5";
        //sut.setTlow(v);
        verify(outputLL.toString()).equals(luminLowRange);
    }

    @Test
    public void testSetHumidityHigh() throws Exception {
        String humidityHighRange = "25";
        //sut.setThi(v);
        verify(outputHH.toString()).equals(humidityHighRange);
    }

    @Test
    public void testSetHumidityLow() throws Exception {
        String humidityLowRange = "5";
        //sut.setTlow(v);
        verify(outputHL.toString()).equals(humidityLowRange);
    }

    @Test
    public void testGetTempLow() throws Exception {
        //read humidity from firebase
        //set in UI
        //verify(UI).setValue(anyString());
    }

    @Test
    public void testGetTempWarning() throws Exception {
        //read humidity from firebase
        //set in UI
        //verify(UI).setValue(anyString());
    }

    @Test
    public void testGetHumidityWarning() throws Exception {
        //read humidity from firebase
        //set in UI
        //verify(UI).setValue(anyString());
    }

    @Test
    public void testGetLuminocityWarning() throws Exception {
        //read humidity from firebase
        //set in UI
        //verify(UI).setValue(anyString());
    }

    @Test
    public void testSetTempWarning() throws Exception {
        //set UI warning
        //verify warning
    }

    @Test
    public void testSetHumidityWarning() throws Exception {
        //set UI warning
        //verify warning
    }

    @Test
    public void testSetLuminocityWarning() throws Exception {
        //set UI warning
        //verify warning
    }

    //TODO: test humidity update and luminosity
}