package com.digit.Project_3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Course {
	Scanner sc = new Scanner(System.in);
	String cou_id;
	String cou_name;
	String cou_time;
	int cou_mark, n;

	public static ArrayList courseList = new ArrayList();
	public static ArrayList courseId = new ArrayList();

	void createCou() {
		System.out.println("Enter the number of Courses");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			
			cou_id="C-"+(i+1);
			courseId.add(cou_id);
			System.out.println("The id Of the Course " + (i + 1)+" is "+courseId.get(i));
			System.out.println("Enter The name  Of the Course-" + (i + 1));
			cou_name = sc.next();

			courseList.add(cou_name);
		}
		Iterator itr1 = courseId.iterator();
		Iterator itr2 = courseList.iterator();

		while (itr1.hasNext()) {
			System.out.println("Course ID:\033[1m"+itr1.next()+"\033[0m    Course Name- \033[1m"+itr2.next()+"\033[0m\n");
		}
	}

}
