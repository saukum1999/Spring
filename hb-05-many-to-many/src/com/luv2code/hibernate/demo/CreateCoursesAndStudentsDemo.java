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

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Course tempCourse1 = new Course("Packman - How to score 1 million points");
			Course tempCourse2 = new Course("Java");
			Course tempCourse3 = new Course("Python");
			
			System.out.println("Saving Course");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			Student s1 = new Student("Sam", "Jackson", "sam.jackson@gmail.com");
			Student s2 = new Student("Amy", "Ferorfouler", "amy@gmail.com");
			Student s3 = new Student("Penny", "Hofstater", "penny@gmail.com");
			
//			System.out.println(tempCourse.getReviews());
//			System.out.println();
			
			session.save(s1);
			session.save(s2);
			session.save(s3);
			
			tempCourse2.addStudent(s1);
			tempCourse2.addStudent(s2);
			tempCourse2.addStudent(s3);
			
			s2.addCourse(tempCourse1);
//			s2.addCourse(tempCourse2);
			s2.addCourse(tempCourse3);
			
						
			session.getTransaction().commit();
			System.out.println("Done!");
		}

		finally {

			session.close();

			factory.close();

		}
	}

}
