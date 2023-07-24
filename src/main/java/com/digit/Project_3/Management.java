package com.digit.Project_3;

import java.util.ArrayList;
import java.util.Scanner;

class Admin {
	Scanner sc = new Scanner(System.in);
//	Course c1;
//	Professor p1;
//	Student s1;
	boolean flag;
	String roles;
	Student stu1 = new Student();
	Professor pro1 = new Professor();
	Course cou1 = new Course();

	void adminlogin() {
		System.out.println("\033[1mWELCOME TO COURSE MANAGEMENT APPLICATION\033[0m\n");
		String orgid = "Admin";
		String orgpass = "123";

		System.out.println("Enter Admin Username");
		String name = sc.next();
		System.out.println("Enter Admin Password");
		String pass = sc.next();

		if (orgid.equals(name) && orgpass.equals(pass)) {
			System.out.println("Login Succesfully.");
			System.out.println("WELCOME ADMIN");
			System.out.println("");
			flag = true;
			System.out.println("Register the Courses\n");
			cou1.createCou();
			System.out.println("Register the Professor\n");
			pro1.createPro();
			System.out.println("Register the Students\n");
			stu1.createStu();

		} else {
			System.out.println("Login Failed...");
			System.out.println("Enter username and password again");
			adminlogin();
		}

		role();
		System.out.println("Thank You...");
	}

	void role() {
		System.out.println("Press\033[1m P \033[0mto login as a \033[1mProfessor\033[0m\n"
				+ "Press \033[1mS\033[0m to login as a  \033[1m Student\033[0m");

		roles = sc.next();
		if (roles.equalsIgnoreCase("p")) {
			professorlogin();
		} else if (roles.equalsIgnoreCase("s")) {
			studentlogin();
		}
	}

	void professorlogin() {

		System.out.println("\nTo Grade the Student Login as Professor");
		pro1.prologin();
		if (pro1.proflag) {
			
			for (int i = 0; i < stu1.stuid.size(); i++) {
				pro1.markstu(i);

			}
			studentlogin();
		}
	}

	void studentlogin() {
		System.out.println("To Check Student Mark please login");
		stu1.stulogin();
		if (stu1.stuflag) {
			if (pro1.r == 0) {
				System.out.println("Your are not Grade by the Professor.");
				System.out.println("Login as Professor");
				professorlogin();
			} else {
				for (int i = 0; i < stu1.stuid.size(); i++) {
					pro1.getStumark(i);
				}
			}
		}
	}

}

public class Management {
	Scanner sc = new Scanner(System.in);
	boolean flag = false;

	public static void main(String[] args) {

		Admin adm = new Admin();
		adm.adminlogin();

	}
}
