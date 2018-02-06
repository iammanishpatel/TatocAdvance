package com.qa.tatoc.Advance.action;

import org.openqa.selenium.WebElement;

import com.qa.tatoc.Advance.driver.DriverFactory;

public class HoverMenu  {
	
	DriverFactory driverFactory;
	
	public HoverMenu(DriverFactory df){
		this.driverFactory=df;
		df.initDriver();
	}
	
	public void hoverMenu(){
		String menuPath, menuClick;
		WebElement hover,click;
		menuPath = "//div[@class='menutop m2']";
		menuClick = "//span[@onclick='gonext();']";
		hover =driverFactory. elementByXpath(menuPath);
		click = driverFactory.elementByXpath(menuClick);
		driverFactory.hoverAndClick(hover,click);
		System.out.println("Hover and clicked.........................................");
	}

}
