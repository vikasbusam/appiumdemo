package com.company.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {
	public static String appName;
	public static String os;
	public static String deviceName;
	
	public static void configure() throws IOException {
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\company\\config\\config.properties");
		prop.load(fin);
		appName = prop.getProperty("appName");
		os  = prop.getProperty("OS");
		deviceName = prop.getProperty("deviceName");
	}

}
