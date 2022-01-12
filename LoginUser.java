package com.user.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginUser {

	public static void main(String[] args) {
		int result = 0;
		ResultSet rs=null;
		Connection con=null;
		Statement st=null;
		try {
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter UserName:: ");
			String userName=sc.next();
			userName="'"+userName+"'";
			
			System.out.println("Enter Password:: ");
			String pass=sc.next();
			pass = "'"+pass+"'";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","AkashGupta","AkashGupta");
			
			st=con.createStatement();
			String query="select count(*) from records where username="+userName+"and pass="+pass;
			 rs=st.executeQuery(query);
			if(rs!=null)
			{
				if(rs.next()!=false)
				{
					result=rs.getInt(1);
				}
			}
			
			if(result==0)
			{
				System.out.println("Invalid credentials");
			}
			else
			{
				System.out.println("Valid Credentials");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		finally
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
