package com.company.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.company.config.Configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Initialize {
	
	
	
	public static void initializeFramework(String app) throws IOException, InterruptedException {
		AppiumManager.startServer();
		Configuration.configure();
		startEmulator();
		AndroidDriver<AndroidElement> driver;
		driver = androidInitialize(app);
		DriverManager.setDriver(driver);
	}
	
	private static AndroidDriver<AndroidElement> androidInitialize(String app) throws MalformedURLException {
		File f = new File("apps");
		File appPath = new File(f,Configuration.appName);		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Configuration.deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Configuration.os);
		cap.setCapability(MobileCapabilityType.VERSION, "10.0");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ApiDemos");
		cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		return new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
	}
	
	private static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\resources\\startemulator.bat");
		Thread.sleep(7000);
	}
}
