package com.qa.tatoc.Advance.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.ResultSetMetaData;
import com.qa.tatoc.Advance.driver.DriverFactory;

public class QueryGate {

	DriverFactory driverFactory;
	public QueryGate(DriverFactory df){
		this.driverFactory=df;
	}
	
	public void databaseConnection() throws SQLException, ClassNotFoundException{
		String userName, password,url,symbolPath,symbolText,name,passkey,nameXpath,passkeyXpath,proceed;
		name="";
		passkey="";
		int id=0;
		symbolPath = "//div[@id='symboldisplay']";
		symbolText = driverFactory.getTextByXpath(symbolPath);
		nameXpath = "//input[@name='name']";
		passkeyXpath = "//input[@name='passkey']";
		proceed = "//input[@value='Proceed']"; 
		url="jdbc:mysql://10.0.1.86/tatoc";
		userName="tatocuser";
		password="tatoc01";
		System.out.println("symbolText "+symbolText);
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, userName ,password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from identity;");
		ResultSetMetaData identityMetaData = (ResultSetMetaData) rs.getMetaData();
		System.out.println("Total columns in Identity table are: "+identityMetaData.getColumnCount());
		System.out.println("Column name are : "+identityMetaData.getColumnLabel(1)+" "+identityMetaData.getColumnLabel(2));
		while (rs.next()){
			if(rs.getString(2).equalsIgnoreCase(symbolText)){
				id = rs.getInt(1);
				//System.out.println("Symbol found and its ID is: "+id);
				break;
			}
		}
		
		ResultSet rs1 = stmt.executeQuery("select * from credentials;");
		ResultSetMetaData credentialsMetaData = (ResultSetMetaData) rs1.getMetaData();
		System.out.println("Total columns in credentials table are: "+credentialsMetaData.getColumnCount());
		System.out.println("Column name are : "+credentialsMetaData.getColumnLabel(1)+" "+credentialsMetaData.getColumnLabel(2)+" "+credentialsMetaData.getColumnLabel(3));
		while (rs1.next()){
			if(id==rs1.getInt(1)){
				name=rs1.getString(2);
				passkey = rs1.getString(3);
				//System.out.println("Credentials=> name: "+rs1.getInt(1)+" passkey: "+passkey);
				break;
			}
		}
		System.out.println( "Id: "+id+" Name: "+name+" Passkey: "+passkey);
		driverFactory.sendKeysByXpath(nameXpath, name);
		driverFactory.sendKeysByXpath(passkeyXpath, passkey);
		driverFactory.clickByXpath(proceed);
		System.out.println("Proceeded from Query Gate.........................................");
	}
}
