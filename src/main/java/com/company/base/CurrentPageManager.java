package com.company.base;

public class CurrentPageManager {
	
	//public static ThreadLocal<Base> currentPage = new ThreadLocal<>();
	public static Base currentPage;
	
	public static Base getCurrentPage() {
		//return currentPage.get();
		return currentPage;
	}
	
	public static void setCurrentPage(Base page) {
		//currentPage.set(page);
		currentPage = page;
	}
	
}
