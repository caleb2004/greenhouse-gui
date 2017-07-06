package com.joanjantz_lee.greenhouse;

import android.graphics.Color;
import android.widget.TextView;

/**
 * Created by joanjantz-lee on 2017-06-07.
 */

public class GHdata {
    //========================
    // Data
    //========================
    // Temperature
    private double temperature;
    private double maxTemperature;
    private double minTemperature;
    // Humidity
    private double humidity;
    private double maxHumidity;
    private double minHumidity;
    // Luminosity
    private double luminosity;
    private double maxLuminosity;
    private double minLuminosity;

    //==============================
    // SETTEMPCOLOR
    //==============================

    public void setTempColor(TextView tv)
    {
        if (getTemperature()>getMaxTemperature())
        {
            tv.setTextColor(Color.RED);
        }
        else if (getTemperature() < getMinTemperature())
        {
            tv.setTextColor(Color.LTGRAY);
        }
        else
        {
            tv.setTextColor(Color.BLACK);
        }
    }

    //===============================
    // SETHUMIDITYCOLOR
    //===============================

    public void setHumidityColor(TextView tv)
    {
        if (getHumidity()>getMaxHumidity())
        {
            tv.setTextColor(Color.RED);
        }
        else if (getHumidity() < getMinHumidity())
        {
            tv.setTextColor(Color.LTGRAY);
        }
        else
        {
            tv.setTextColor(Color.BLACK);
        }
    }
    //=================================
    // SETLUMINOSITYCOLOR
    //==================================
    public void setLuminosityColor(TextView tv)
    {
        if (getLuminosity()>getMaxLuminosity())
        {
            tv.setTextColor(Color.RED);
        }
        else if (getLuminosity() < getMinLuminosity())
        {
            tv.setTextColor(Color.LTGRAY);
        }
        else
        {
            tv.setTextColor(Color.BLACK);
        }
    }

    //========================
    // Setters
    //========================
    public void setTemperature   (double t)   { temperature    = t;   }
    public void setHumidity      (double h)   { humidity       = h;   }
    public void setLuminosity    (double l)   { luminosity     = l;   }
    public void setMaxTemperature(double maxT){ maxTemperature = maxT;}
    public void setMinTemperature(double minT){ minTemperature = minT;}
    public void setMaxHumidity   (double maxH){ maxHumidity    = maxH;}
    public void setMinHumidity   (double minH){ minHumidity    = minH;}
    public void setMaxLuminosity (double maxL){ maxLuminosity  = maxL;}
    public void setMinLuminosity (double minL){ minLuminosity  = minL;}

    //========================
    // Getters
    //========================
    public double getTemperature()    { return temperature;   }
    public double getHumidity()       { return humidity;      }
    public double getLuminosity()     { return luminosity;    }
    public double getMaxTemperature() { return maxTemperature;}
    public double getMinTemperature() { return minTemperature;}
    public double getMaxHumidity()    { return maxHumidity;   }
    public double getMinHumidity()    { return minHumidity;   }
    public double getMaxLuminosity()  { return maxLuminosity; }
    public double getMinLuminosity()  { return minLuminosity; }

    //========================
    // Constructors
    //========================
    public GHdata()
    {
        setMaxTemperature(100);
        setTemperature   (50);
        setMinTemperature(0);

        setMaxHumidity   (101);
        setHumidity      (51);
        setMinHumidity   (1);

        setMaxLuminosity (102);
        setLuminosity    (52);
        setMinLuminosity (2);
    }

    public GHdata(
            double maxT,
            double t,
            double minT,
            double maxH,
            double h,
            double minH,
            double maxL,
            double l,
            double minL)

    {
        setMaxTemperature(maxT);
        setTemperature   (t);
        setMinTemperature(minT);

        setMaxHumidity   (maxH);
        setHumidity      (h);
        setMinHumidity   (minH);

        setMaxLuminosity (maxL);
        setLuminosity    (l);
        setMinLuminosity (minL);
    }

}

