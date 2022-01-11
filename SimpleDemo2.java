package com.simple.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleDemo2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AkashGupta","AkashGupta");
		
		Statement st = con.createStatement();
		String que="insert into customer_table values(777,'Pappu','RDA head office',0000000)";
		int result=st.executeUpdate(que);
		if(result==1)
		{
			System.out.println("one Row Inserted Successfully");
		}
		else
		{
			System.out.println("Data insertion failed");
		}
		
	}

}
