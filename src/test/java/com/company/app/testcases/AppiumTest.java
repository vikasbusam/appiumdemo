package com.company.app.testcases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.company.base.AppiumManager;
import com.company.base.Base;
import com.company.base.CurrentPageManager;
import com.company.base.DriverManager;
import com.company.base.Initialize;
import com.company.pages.HomePage;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.offset.ElementOption.element;

//import android.support.test.uiautomator.UiSelector;


public class AppiumTest extends Base {
	DesiredCapabilities cap;
	
	
	@BeforeTest
	public void setUp1() throws IOException, InterruptedException {
		
		Initialize.initializeFramework("app");
	}
	
	@Test
	public void t1() throws MalformedURLException, InterruptedException, InstantiationException, IllegalAccessException {
		//AndroidDriver<AndroidElement> driver = setUp();
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		DriverManager.getDriver().findElementByXPath("//android.widget.Button[@text='Continue']").click();
		Thread.sleep(1000);
		DriverManager.getDriver().findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		Thread.sleep(1000);
		
		CurrentPageManager.setCurrentPage(get(new HomePage()));
		
		CurrentPageManager.getCurrentPage().castAs(HomePage.class).pref.click();
		
		//DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
		DriverManager.getDriver().findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
		DriverManager.getDriver().findElement(By.id("android:id/checkbox")).click();
		DriverManager.getDriver().findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		DriverManager.getDriver().findElement(By.className("android.widget.EditText")).sendKeys("hello");
		
		DriverManager.getDriver().findElements(By.className("android.widget.Button")).get(1).click();
	}
	
	
	@AfterTest
	public void tearDown() {
		AppiumManager.stopServer();
	}
	
	public void t2() {
		
	}
	
	
}
