package com.qa.project.TAFW.action;

import org.openqa.selenium.WebElement;

import com.qa.project.TAFW.driverfactory.DriverFactory;
import com.qa.project.TAFW.utils.HoverMenuUtils;


public class HoverMenu {
	
	public static void hoverMenu(){
		WebElement hover,click;
		hover =DriverFactory. elementByXpath(HoverMenuUtils.menuPath);
		click = DriverFactory.elementByXpath(HoverMenuUtils.menuClick);
		DriverFactory.hoverAndClick(hover,click);
		System.out.println("Hover and clicked.........................................");
	}

}