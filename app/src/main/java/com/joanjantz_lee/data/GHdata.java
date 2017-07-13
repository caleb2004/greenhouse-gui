package com.joanjantz_lee.data;

//========================
// Joan Jantz-Lee
// Greenhouse Data Class 
// 
//========================
public class GHdata
{
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
		setMaxTemperature(38);
		setTemperature   (25);   
		setMinTemperature(5);

		setMaxHumidity   (95);
		setHumidity      (80);   
		setMinHumidity   (40);

		setMaxLuminosity (7000);
		setLuminosity    (5000);   
		setMinLuminosity (2000);
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