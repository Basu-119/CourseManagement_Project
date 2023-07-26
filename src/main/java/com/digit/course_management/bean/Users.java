package com.digit.course_management.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.digit.course_management.CourseManagementApp;
import com.digit.course_management.Services.AdminServices;
import com.digit.course_management.Services.ProfessorService;
import com.digit.course_management.Services.StudentService;

public class Users {
	static String user_name;
	static String password;
	private static PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet resultSet;
	private static ResultSet res;
	
	
	
	Scanner sc1 = new Scanner(System.in);
	StudentService ss=new StudentService();
	public static boolean admlogin() {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the user_name:");
			user_name=sc.next();
			System.out.println("Enter the password:");
			password=sc.next();
			String sql = "select * from users where user_name=? and user_pass=?";
			pstmt = CourseManagementApp.con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			if(res.next()) {
				System.out.println("Login Successfully");
				return true;
			}
			else {
				System.out.println("Login Failed...");
				System.out.println("Login again");
				admlogin();
				return false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void displayUser() {
		try {
			String sql = "select * from users";

			stmt = CourseManagementApp.con.createStatement();
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next() == true) {
				System.out.print(resultSet.getString(1)+"\t");
				System.out.print(resultSet.getString(2)+"\t");
				System.out.print(resultSet.getString(3)+"\t");
				System.out.println();
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void role() {
		System.out.println("Press\033[1m P \033[0m to change the role to \033[1mProfessor\033[0m\n"
				+ "Press \033[1mS\033[0m to  change the role to \033[1m Student\033[0m");

		String roles = sc1.next();
		if (roles.equalsIgnoreCase("p")) {
			
			
		} else if (roles.equalsIgnoreCase("s")) {
			ss.sturole();
			
		} else {
			System.out.println("Enter a valid option");
			role();
		}
	}
	
	
	public static String getUser_name() {
		return user_name;
	}
	public static void setUser_name(String user_name) {
		Users.user_name = user_name;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Users.password = password;
	}
	
	
	
}
