package com.qa.tatoc.Advance.action;

import com.qa.tatoc.Advance.driver.DriverFactory;

public class CourseSelection   {
	
	DriverFactory driverFactory;
	
	public CourseSelection(DriverFactory df){
		this.driverFactory=df;
	}
	public void courseSelect(){
		String coursePath = "//a[@href='/tatoc/advanced']";
		driverFactory.clickByXpath(coursePath);
		System.out.println("Advance coures selected.........................................");
	}

}
