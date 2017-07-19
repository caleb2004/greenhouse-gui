package com.joanjantz_lee.greenhouse;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class GHDataTest {

    //create fake objects for outside the scope of the test with mocks

    @Mock
    private TextView textView;

    @Mock
    private ColorStateList colorStateList;

    //inject your fake objects into the class you are testing
    @InjectMocks
    private GHdata ghData;


    @Before
    public void setup() {
        //set what will be returned when methods called
        MockitoAnnotations.initMocks(this);
    }

    //Test the case where the temp is above the desired range
    @Test
    public void testSetTempColorAboveRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.RED);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setTemperature(20.0);
        ghData.setMaxTemperature(19.0);

        ghData.setTempColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.RED);
    }

    //Test the case where the temp is below the desired range
    @Test
    public void testSetTempColorBelowRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.LTGRAY);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setTemperature(19.0);
        ghData.setMaxTemperature(21.0);
        ghData.setMinTemperature(20.0);

        ghData.setTempColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.LTGRAY);
    }

    //Test the case where the temp is within the desired range
    @Test
    public void testSetTempColorInRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.BLACK);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setTemperature(20.0);
        ghData.setMaxTemperature(21.0);
        ghData.setMinTemperature(19.0);

        ghData.setTempColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.BLACK);
    }

    //Test the case where the humidity is above the desired range
    @Test
    public void testSetHumidityColorAboveRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.RED);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setHumidity(20.0);
        ghData.setMaxHumidity(19.0);

        ghData.setHumidityColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.RED);
    }

    //Test the case where the humidity is below the desired range
    @Test
    public void testSetHumidityColorBelowRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.LTGRAY);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setHumidity(19.0);
        ghData.setMaxHumidity(21.0);
        ghData.setMinHumidity(20.0);

        ghData.setHumidityColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.LTGRAY);
    }

    //Test the case where the Humidity is within the desired range
    @Test
    public void testSetHumidityColorInRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.BLACK);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setHumidity(20.0);
        ghData.setMaxHumidity(21.0);
        ghData.setMinHumidity(19.0);

        ghData.setHumidityColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.BLACK);
    }

    //Test the case where the luminosity is above the desired range
    @Test
    public void testSetLuminosityColorAboveRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.RED);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setLuminosity(20.0);
        ghData.setMaxLuminosity(19.0);

        ghData.setLuminosityColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.RED);
    }

    //Test the case where the luminosity is below the desired range
    @Test
    public void testSetLuminosityColorBelowRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.LTGRAY);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setLuminosity(19.0);
        ghData.setMaxLuminosity(21.0);
        ghData.setMinLuminosity(20.0);

        ghData.setLuminosityColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.LTGRAY);
    }

    //Test the case where the luminosity is within the desired range
    @Test
    public void testSetLuminosityColorInRange() throws Exception {
        when(colorStateList.getDefaultColor()).thenReturn(Color.BLACK);
        when(textView.getTextColors()).thenReturn(colorStateList);
        ghData.setLuminosity(20.0);
        ghData.setMaxLuminosity(21.0);
        ghData.setMinLuminosity(19.0);

        ghData.setLuminosityColor(textView);
        assertEquals(textView.getTextColors().getDefaultColor(), Color.BLACK);
    }

}

