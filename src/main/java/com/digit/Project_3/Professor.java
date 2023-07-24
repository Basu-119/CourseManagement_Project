package com.digit.Project_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Professor {
	Scanner sc = new Scanner(System.in);
	String pro_id;
	String pro_name, grade;
	String pro_exp;
	String pro_sub;
	Course c1 = new Course();
	Student s1 = new Student();
	int fmark = 100, mark, r = 0;
	boolean proflag = false;
	String feedback, remark;
	public static ArrayList pro = new ArrayList();
	public static ArrayList proid = new ArrayList();
	public static ArrayList prosub = new ArrayList();
	public static ArrayList proexp = new ArrayList();
	public static ArrayList grading = new ArrayList();
	public static ArrayList remarking = new ArrayList();
	public static ArrayList stumark = new ArrayList();

	void createPro() {
		System.out.println("Enter the number of professor-");
		int no_pro = sc.nextInt();
		for (int i = 0; i < no_pro; i++) {
			pro_id = "P601-" + (i + 1);
			proid.add(pro_id);
			System.out.println("The id Of the Professor " + (i + 1) + " is " + proid.get(i));

			System.out.println("Enter The Name Of the Professor-" + (i + 1));
			pro_name = sc.next();
			pro.add(pro_name);

//			System.out.println("Enter The Exp Of the Professor");
//			pro_exp = sc.next();
//			proexp.add(pro_exp);

			addsub();
			if (!c1.courseList.contains(pro_sub)) {
				System.out.println("Select the courses that are available");
				addsub();
			} else {
				System.out.println("Successfully added");
			}

		}
		for (int i = 0; i < no_pro; i++) {
			System.out.println("ID- \033[1m" + proid.get(i) + "\033[0m Name- \033[1m" + pro.get(i)
					+ "\033[0m Course- \033[1m" + prosub.get(i) + "\033[0m");

		}
	}

	void markep() {
		System.out.println("Enter the mark :");
		mark = sc.nextInt();
		if (fmark < mark) {
			System.out.println("Full mark is 100");
			System.out.println("Enter the mark :");
			mark = sc.nextInt();

		}

		stumark.add(mark);
	}

	void addsub() {
		System.out.println("Select course for the Professor from the available courses:");
		Iterator itr = c1.courseList.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + "   ");
		}
		System.out.println();

		pro_sub = sc.next();
		prosub.add(pro_sub);

	}

	void markstu(int i) {
		System.out.println("\033[1mWelcome professor " + pro.get(i) + " " + "\nGrade the student\033[0m\n");
		System.out.println("ID of the student :\033[1m" + s1.stuid.get(i) + "\033[0m");
		System.out.println("Name of the student :\033[1m" + s1.stuname.get(i) + "\033[0m");
		System.out.println("Course :\033[1m" + s1.stuCou.get(i) + "\033[0m");
		System.out.println("The Total mark for " + s1.stuCou.get(i) + " is :\033[1m100\033[0m ");
		markep();
		System.out.println("Enter Grade: ");
		grade = sc.next();
		grading.add(remark);
		System.out.println("Any remark :");
		remark = sc.next();
		remarking.add(remark);

		r = r + 1;
	}

	void getStumark(int i) {
		System.out.println("\n");
		System.out.println("\033[1mReport Card \033[0m");
		System.out.println("\\033[1mStudent ID :" + s1.stuid.get(i));
		System.out.println("Student Name :" + s1.stuname.get(i));
		System.out.println("Course ID:" + c1.courseId.get(i));
		System.out.println("Course :" + s1.stuCou.get(i));
		System.out.println("You Scored Mark :" + stumark.get(i));
		System.out.println("Your Grade :" + grading.get(i));
		System.out.println("Your Remark :" + remarking.get(i) + "\033[0m");

	}

	void prologin() {
		String orgid = "Pro";
		String orgpass = "123";

		System.out.println("Enter Professor Username");
		String name = sc.next();
		System.out.println("Enter Password");
		String pass = sc.next();

		if (orgid.equals(name) && orgpass.equals(pass)) {
			System.out.println("Login Succesfully.");
			System.out.println("\nWELCOME PROFESSOR");
			System.out.println("");
			proflag = true;
		} else {
			System.out.println("Failed...");
			System.out.println("Enter username and password again");
			prologin();
		}
	}

	// Getter And Setter
	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_exp() {
		return pro_exp;
	}

	public void setPro_exp(String pro_exp) {
		this.pro_exp = pro_exp;
	}

	public Course getC1() {
		return c1;
	}

	public void setC1(Course c1) {
		this.c1 = c1;
	}

	public int getFullmark() {
		return fmark;
	}

	public void setFullmark(int fullmark) {
		this.fmark = fullmark;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		this.mark = mark;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}
