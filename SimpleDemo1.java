package com.simple.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//Load the Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Establish Connection 
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AkashGupta","AkashGupta");
		
		// Statement 
		Statement st = con.createStatement();
		// query;
		String com ="select * from customer_table";
		// Resultset 
		ResultSet rs = st.executeQuery(com);
		while(rs.next()!=false)
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4));
		}
		rs.close();
		st.close();
		con.close();
		
		
	}

}
