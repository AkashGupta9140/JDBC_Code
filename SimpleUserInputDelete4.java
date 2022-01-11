package com.simple.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SimpleUserInputDelete4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter srno :: ");
		int srno=sc.nextInt();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AkashGupta","AkashGupta");
		Statement st=con.createStatement();
		
		
		String query="delete from customer_table where srno="+srno;
		int del=st.executeUpdate(query);
		if(del==1)
		{
			System.out.println("Deleted");
		}
		else
		{
			System.out.println("not deleted");
		}

		st.close();
		con.close();
	}

}
