package com.company.pages;

import org.openqa.selenium.WebElement;

import com.company.base.Base;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;

public class HomePage extends Base {
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Preference']")
	@iOSBy(xpath="")
	public MobileElement pref;

}
