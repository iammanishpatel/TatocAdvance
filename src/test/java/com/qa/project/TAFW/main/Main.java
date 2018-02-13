package com.qa.project.TAFW.main;



import java.sql.SQLException;

import org.testng.annotations.Test;

import com.qa.project.TAFW.action.CourseSelection;
import com.qa.project.TAFW.action.HoverMenu;
import com.qa.project.TAFW.action.QueryGate;
import com.qa.project.TAFW.driverfactory.DriverFactory;

public class Main {
	
		@Test(priority = 1)
		public void urlInitiation(){
		DriverFactory.initDriver();  //url initiated
		}
		
		@Test(priority = 2)
		public void courseSelect(){
		CourseSelection.courseSelect(); //Advance course selection...
		}
		
		@Test(priority = 3)
		public void hover(){
		HoverMenu.hoverMenu(); //Hover and Click action performed...
		}
		
		@Test(priority = 4)
		public void querypass() throws ClassNotFoundException, SQLException{
			QueryGate.databaseConnection();// setting up with database...
		}
		
}
