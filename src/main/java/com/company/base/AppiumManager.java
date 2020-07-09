package com.company.base;

import java.io.IOException;
import java.net.ServerSocket;

import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumManager {
	
	public static AppiumDriverLocalService service;
	
	public static void startServer() throws IOException {
		boolean flag = checkrunningStatus();
		if(!flag) {
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
	}
	
	public static void stopServer() {
		service.stop();
	}
	
	private static boolean checkrunningStatus()  {
		boolean running = false;
		ServerSocket socket;
		try {
			socket = new ServerSocket(4723);
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			running = true;
		}
		finally {
			socket=null;
		}
		
		
		return running;
		
	}

}
