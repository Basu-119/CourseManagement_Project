package com.digit.course_management.Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.digit.course_management.CourseManagementApp;

public class StudentService {
	Scanner sc = new Scanner(System.in);
	private Statement stmt;
	private ResultSet resultSet;
	static String user_name;
	static String password;
	private static PreparedStatement pstmt;
	private static ResultSet res;
ProfessorService p5=new ProfessorService();
	public void createStu() {
		try {
			System.out.println("Enter the number of courses:");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String sql = "insert into student values(?,?,?,?)";
				pstmt = CourseManagementApp.con.prepareStatement(sql);

				System.out.println("Enter the Id of the Studenr");
				pstmt.setString(1, sc.next());

				System.out.println("Enter the Name of the student");
				pstmt.setString(2, sc.next());

				System.out.println("Enter the Course");
				pstmt.setString(3, sc.next());

				System.out.println("Enter the professor");
				pstmt.setString(4, sc.next());
				int x = pstmt.executeUpdate();
				if (x > 0) {
					System.out.println("Course Added");

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removeStu() {
		try {

			String sql = "select * from student";

			stmt = CourseManagementApp.con.createStatement();
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next() == true) {

				System.out.println(resultSet.getString("stu_name"));
				System.out.println("-----");

			}
			String sql1 = "delete from student where stu_name=?";
			pstmt = CourseManagementApp.con.prepareStatement(sql1);

			System.out.println("Enter the name of the Student to delete");
			pstmt.setString(1, sc.next());

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("student deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayStu() {
		try {
			String sql = "select * from student";

			stmt = CourseManagementApp.con.createStatement();
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next() == true) {
				System.out.print(resultSet.getString(1) + "\t");
				System.out.print(resultSet.getString(2) + "\t");
				System.out.print(resultSet.getString(3) + "\t");
				System.out.print(resultSet.getString(4) + "\t");
				System.out.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void regiStu() {
		try {
			String sql = "insert into users values(?,?,?)";
			pstmt = CourseManagementApp.con.prepareStatement(sql);
			System.out.println("Enter Student User Id");
			pstmt.setString(1, sc.next());

			System.out.println("Enter the Password");
			pstmt.setString(2, sc.next());

			pstmt.setString(3, "Student");

			int x = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			regiStu();
		}
	}

	public static boolean stulogin() {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the user_name:");
			user_name = sc.next();
			System.out.println("Enter the password:");
			password = sc.next();
			String sql = "select * from users where user_name=? and user_pass=? and role='student'";
			pstmt = CourseManagementApp.con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			if (res.next()) {
				System.out.println("Login Successfully as a student");
				return true;
			} else {
				System.out.println("Login Failed...");
				System.out.println("Login again");
				stulogin();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void sturole() {
		System.out.println("Press\033[1m R \033[0m to register as \033[1mStudent\033[0m\n"
				+ "Press \033[1mL\033[0m to login \033[1m Student\033[0m");

		String roles = sc.next();
		if (roles.equalsIgnoreCase("r")) {
			regiStu();
		} else if (roles.equalsIgnoreCase("l")) {
			stulogin();
		} else {
			System.out.println("Enter a valid option");
			sturole();
		}
	}
}
