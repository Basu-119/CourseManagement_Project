package com.digit.course_management.Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.digit.course_management.CourseManagementApp;
import com.digit.course_management.bean.Professor;
import com.digit.course_management.bean.Users;

public class ProfessorService {

	Professor p1 = new Professor();
	Users u1 = new Users();
	private Statement stmt;
	private ResultSet resultSet;
	Scanner sc = new Scanner(System.in);
	private ResultSet resultSet1;
	static String user_name;
	static String password;
	private static PreparedStatement pstmt;
	private static ResultSet res;
	ArrayList courseList = new ArrayList();

	public void createPro() {
		try {
			System.out.println("Enter the number of Professor:");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				String sql = "insert into professor values(?,?,?,?)";
				pstmt = CourseManagementApp.con.prepareStatement(sql);
				System.out.println("Enter the ID of the Professor");
				pstmt.setString(1, sc.next());

				System.out.println("Enter the Name of the Professor");
				pstmt.setString(2, sc.next());

				System.out.println("Enter the Exp of the Professor");
				pstmt.setString(3, sc.next());
				String sql1 = "select * from courses";

				stmt = CourseManagementApp.con.createStatement();
				resultSet = stmt.executeQuery(sql1);
				while (resultSet.next() == true) {
					courseList.add(resultSet.getString("c_name"));
					System.out.println(resultSet.getString("c_name"));
				}
				System.out.println("Enter the sub of the Professor");
				String subs = sc.next();
				try {
					if (courseList.contains(subs)) {
						pstmt.setString(4, subs);

					} else {
						System.out.println("not");
					}
				} catch (Exception e) {
					System.out.println("Enter Correct option");
				}

				int x = pstmt.executeUpdate();
				System.out.println(courseList);
				if (x > 0) {
					System.out.println("Course Added is :");

				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removePro() {
		try {

			String sql = "select * from professor";

			stmt = CourseManagementApp.con.createStatement();
			resultSet = stmt.executeQuery(sql);
			while (resultSet.next() == true) {

				System.out.println(resultSet.getString("pro_name"));
				System.out.println("-----");

			}
			String sql1 = "delete from courses where pro_name=?";
			pstmt = CourseManagementApp.con.prepareStatement(sql1);

			System.out.println("Enter the name of the Professor name to remove");
			pstmt.setString(1, sc.next());

			int x = pstmt.executeUpdate();
			if (x > 0) {
				System.out.println("Professor deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayPro() {
		try {
			String sql = "select * from professor";

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

	public void regiPro() {
		try {
			String sql = "insert into users values(?,?,?)";
			pstmt = CourseManagementApp.con.prepareStatement(sql);
			System.out.println("Enter Professor User Id");
			pstmt.setString(1, sc.next());

			System.out.println("Enter the Password");
			pstmt.setString(2, sc.next());

			pstmt.setString(3, "Professor");

			int x = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			regiPro();
		}
	}

	public static boolean prologin() {
		try {
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the user_name:");
			user_name = sc.next();
			System.out.println("Enter the password:");
			password = sc.next();
			String sql = "select * from users where user_name=? and user_pass=? and role='Professor'";
			pstmt = CourseManagementApp.con.prepareStatement(sql);
			pstmt.setString(1, user_name);
			pstmt.setString(2, password);
			res = pstmt.executeQuery();
			if (res.next()) {
				System.out.println("Login Successfully as a Professor");
				return true;
			} else {
				System.out.println("Login Failed...");
				System.out.println("Login again");
				prologin();
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void prorole() {
		System.out.println("Press\033[1m R \033[0m to register as \033[1mProfessor\033[0m\n"
				+ "Press \033[1mL\033[0m to login \033[1m Professor\033[0m");

		String roles = sc.next();
		if (roles.equalsIgnoreCase("r")) {
			regiPro();

		} else if (roles.equalsIgnoreCase("l")) {
			prologin();
		} else {
			System.out.println("Enter a valid option");
			prorole();

		}
	}

}
