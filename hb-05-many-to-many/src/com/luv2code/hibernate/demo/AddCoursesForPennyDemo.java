package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
//import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForPennyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id = 4;
			Student s1 = session.get(Student.class, id);
//			System.out.println(tempCourse.getReviews());
//			System.out.println();
			
			int course_id1 = 13;			
			int course_id2 = 15;			
			
			Course tempCourse1 = session.get(Course.class, course_id1);
			Course tempCourse2 = session.get(Course.class, course_id2);
//			tempCourse2.addStudent(s2);
			
			s1.addCourse(tempCourse1);
			s1.addCourse(tempCourse2);
			
			
						
			session.getTransaction().commit();
			System.out.println("Done!");
		}

		finally {

			session.close();

			factory.close();

		}
	}

}
