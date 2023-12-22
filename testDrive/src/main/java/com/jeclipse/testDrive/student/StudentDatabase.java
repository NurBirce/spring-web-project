package com.jeclipse.testDrive.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDatabase {

public static Connection connection = null;
	
	public static Connection getConnection() throws SQLException{
		
		if(connection != null) {
			return connection;
		}else {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/nurproject?useSSL=false";
			String user = "root";
			String password = "";
			
			try {
				Class.forName(driver);
				System.out.println("baglanti oluyor..");
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("baglanti saglandi, "+ connection);
				PreparedStatement state = connection.prepareStatement("SELECT * FROM student");
				ResultSet rs = state.executeQuery();

				while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String lastName = rs.getString("lastName");
	                int age = rs.getInt("age");
	                String email = rs.getString("email");
	                String teacher = rs.getString("teacher");
	                

	                System.out.println(id + "," + name + "," + lastName + "," + age + "," + email + "," + teacher + "," );
	            }
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return connection;
	}
}
