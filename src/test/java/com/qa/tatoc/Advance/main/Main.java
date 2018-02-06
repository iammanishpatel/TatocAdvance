package com.qa.tatoc.Advance.main;

import java.sql.SQLException;

import com.qa.tatoc.Advance.action.CourseSelection;
import com.qa.tatoc.Advance.action.HoverMenu;
import com.qa.tatoc.Advance.action.QueryGate;
import com.qa.tatoc.Advance.driver.Chrome;
import com.qa.tatoc.Advance.driver.DriverFactory;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
		DriverFactory df =  DriverFactory.getInstance();
		
		Chrome ch = new Chrome(df);
		ch.chromeInitiation();
		
		CourseSelection cs = new CourseSelection(df);
		cs.courseSelect(); //Advance course selection...
		
		HoverMenu hm = new HoverMenu(df);
		hm.hoverMenu(); //Hover and Click action performed...
		
		QueryGate qg = new QueryGate(df);
		qg.databaseConnection(); // setting up with database...
		
	}
}
