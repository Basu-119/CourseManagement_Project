package com.digit.course_management.Services;

import java.util.Scanner;

import com.digit.course_management.bean.Users;

public class AdminServices {
	ProfessorService p2 = new ProfessorService();
	CourseService c2 = new CourseService();
	StudentService s2 = new StudentService();
	Users us = new Users();

	public void first() {

		System.out.println("Welcome Admin");
		System.out.println("Log-in Yourself here ");
		if (us.admlogin() == true) {
			register();
		}

	}


	public void register() {
		System.out.println();
		System.out.println("1. Add course\n" + "2. Add Student\n" + "3. Add Professor\n" + "4. Remove Course\n"
				+ "5. Remove Professor\n" + "6. Remove Student\n" + "7. View All Students\n" + "8. View All Courses\n"
				+ "9. View All Professors\n" + "10. View All Users\n" + "0. Swap role\n");

		

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		try {
			switch (n) {
			case 1: {
				c2.createCou();
				register();
				break;
			}
			case 2: {
				s2.createStu();
				register();
				break;
			}
			case 3: {
				p2.createPro();
				register();
				break;
			}
			case 4: {
				c2.removeCou();
				register();
				break;

			}
			case 5: {
				p2.removePro();
				register();
				break;
			}
			case 6: {
				s2.removeStu();
				register();
				break;
			}
			case 7: {
				s2.displayStu();
				register();
				break;
			}
			case 8: {
				c2.displayCou();
				register();
				break;
			}
			case 9: {
				p2.displayPro();
				register();
				break;
			}
			case 10: {
				us.displayUser();
				register();
				break;
			}

			case 0: {
				us.role();
				break;
			}
			default:
			}
			
			
			
		} catch (Exception e) {
			System.out.println("Input mismatch");
		}
	}
}
