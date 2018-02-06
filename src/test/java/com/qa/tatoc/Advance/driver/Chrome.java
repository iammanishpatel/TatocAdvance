package com.qa.tatoc.Advance.driver;

public class Chrome {

	DriverFactory driverFactory;
	
	public Chrome(DriverFactory df){
		this.driverFactory=df;
	}
	
	public void chromeInitiation() {
		driverFactory.initDriver();
		System.out.println("Tatoc is opened in chrome browser.........................................");
	}
}
