package com.testing.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnection{ 
	

	public void DB(String forname , String hostname, String portname, String 
		jdbc , String databaseName, String userName, String passWord, 
		String query, String printStatement) throws SQLException, ClassNotFoundException{
		
		Class.forName(forname);
		
		String host = hostname;
		String port = portname;
		
		Connection Con = DriverManager.getConnection( jdbc + host + ":" + port + databaseName ,userName, passWord );
		
		Statement s = Con.createStatement();
		ResultSet rs = s.executeQuery(query); 
		System.out.println(printStatement);
		
		while(rs.next()){
		
		System.out.println(rs.getString("location")+ " , "+rs.getString("name"));
		
		}
	
	}

}