package com.company.base;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Base {
	
	
	public <T extends Base> T getInstance(Class<T> page) throws InstantiationException, IllegalAccessException {
		//Object obj = PageFactory.initElements(DriverManager.getDriver(), page);
		
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),page);
		return page.cast(this);
		
		
	}
	
	public <T extends Base> T castAs(Class<T> page) {
		return (T)this;
	}
	
	public <T extends Base> Base get(T obj) {
		
		PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()),obj);
		return (Base) obj;
		
	}

}
