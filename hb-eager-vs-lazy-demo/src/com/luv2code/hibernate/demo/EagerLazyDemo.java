package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			int id =1;
			
			Instructor tempInstructor = session.get(Instructor.class,id);
			
			System.out.println("SauKum : Instructor : " + tempInstructor);
			
			System.out.println("SauKum : Courses : " + tempInstructor.getCourses());
//			tempInstructor.getCourses();
			session.getTransaction().commit();
			System.out.println("SauKum : Done!");
			
			session.close();
			
			System.out.println("SauKum : Courses : " + tempInstructor.getCourses());
		}
		
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

		finally {

			session.close();

			factory.close();

		}
	}

}
