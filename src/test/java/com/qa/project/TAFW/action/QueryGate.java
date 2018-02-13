package com.qa.project.TAFW.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.ResultSetMetaData;
import com.qa.project.TAFW.driverfactory.DriverFactory;
import com.qa.project.TAFW.utils.QueryGateUtils;

public class QueryGate {
	public static void databaseConnection() throws SQLException, ClassNotFoundException{
		int id=0;
		System.out.println("symbolText "+QueryGateUtils.symbolText);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(QueryGateUtils.url, QueryGateUtils.userName ,QueryGateUtils.password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from identity;");
		ResultSetMetaData identityMetaData = (ResultSetMetaData) rs.getMetaData();
		System.out.println("Total columns in Identity table are: "+identityMetaData.getColumnCount());
		System.out.println("Column name are : "+identityMetaData.getColumnLabel(1)+" "+identityMetaData.getColumnLabel(2));
		while (rs.next()){
			if(rs.getString(2).equalsIgnoreCase(QueryGateUtils.symbolText)){
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
				QueryGateUtils.name=rs1.getString(2);
				QueryGateUtils.passkey = rs1.getString(3);
				//System.out.println("Credentials=> name: "+rs1.getInt(1)+" passkey: "+passkey);
				break;
			}
		}
		System.out.println( "Id: "+id+" Name: "+QueryGateUtils.name+" Passkey: "+QueryGateUtils.passkey);
		DriverFactory.sendKeysByXpath(QueryGateUtils.nameXpath, QueryGateUtils.name);
		DriverFactory.sendKeysByXpath(QueryGateUtils.passkeyXpath, QueryGateUtils.passkey);
		DriverFactory.clickByXpath(QueryGateUtils.proceed);
		System.out.println("Proceeded from Query Gate.........................................");
	}
}

