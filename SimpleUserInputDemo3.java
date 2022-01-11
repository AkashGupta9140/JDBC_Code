package com.simple.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SimpleUserInputDemo3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Srno:: ");
		int srno = sc.nextInt();
		
		System.out.println("Enter cus_name:: ");
		String cus_name = sc.next();
		cus_name = "'"+cus_name+"'";
		
		System.out.println("Enter cus_add");
		String cus_add = sc.next();
		cus_add = "'"+cus_add+"'";
		
		System.out.println("Enter cus_mobno");
		int cus_mobno =sc.nextInt();
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AkashGupta","AkashGupta");
		
		Statement st = con.createStatement();
		//String que="insert into customer_table values(srno,cus_name,cus_add,cus_mobno)";
		
		String que="insert into customer_table values("+srno+","+cus_name+","+cus_add+","+cus_mobno+")";
		int result=st.executeUpdate(que);
		if(result==1)
		{
			System.out.println("data insert Successfully");
		}
		else
		{
			System.out.println("NO data ");
		}
		st.close();
		con.close();
		

	}

}
