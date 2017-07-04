package com.joanjantz_lee.greenhouse;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.TextView;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ReadingsUITest {

    private String displayTemp;
    private String displayLumin;
    private String displayHumid;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidReadings() {
        displayTemp = "15 C";
        displayLumin = "5432 LM";
        displayHumid = "98%";
    }

    @Test
    public void checkTempDisplay() {
        onView(withId(R.id.tvTemp))
                .check(matches(withText(displayTemp)));
    }

    @Test
    public void checkLuminDisplay() {
        onView(withId(R.id.tvLumin))
                .check(matches(withText(displayLumin)));
    }

    @Test
    public void checkHumidDisplay() {
        onView(withId(R.id.tvHumid))
                .check(matches(withText(displayHumid)));
    }

}