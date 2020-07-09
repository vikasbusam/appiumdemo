package com.company.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DriverManager {
	
	public static ThreadLocal<AndroidDriver<AndroidElement>> localDriver = new ThreadLocal<>();
	public static ThreadLocal<AndroidDriver<AndroidElement>> localAndroidDriver = new ThreadLocal<>();
	
	public static AndroidDriver<AndroidElement> getDriver() {
		return localDriver.get();
	}
	
	public static void setDriver(AndroidDriver<AndroidElement> driver) {
		localDriver.set(driver);
		
	}
	


}
