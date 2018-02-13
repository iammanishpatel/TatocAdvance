package com.qa.project.TAFW.action;

import com.qa.project.TAFW.driverfactory.DriverFactory;
import com.qa.project.TAFW.utils.CourseSelectionUtils;

public class CourseSelection {

	public static void courseSelect(){
		DriverFactory.clickByXpath(CourseSelectionUtils.coursePath);
		System.out.println("Advance coures selected.........................................");
	}

}