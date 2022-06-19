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

public class DeleteStudentPennyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();
			
			int id = 6;
			Student s1 = session.get(Student.class,id);
			
			System.out.println("Deleting Student : "+ s1);

			session.delete(s1);
//			System.out.println("Courses opted by Student : "+ s1.getCourses());
			session.getTransaction().commit();
			System.out.println("Done!");
		}

		finally {

			session.close();

			factory.close();

		}
	}

}
