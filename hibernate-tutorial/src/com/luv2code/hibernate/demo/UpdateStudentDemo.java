package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		
		try {
			
			int id = 1;
			Session session = factory.getCurrentSession();

			session.beginTransaction();
			
			Student std = session.get(Student.class,id);
			
			System.out.println(std);
			std.setFirstName("Hello");
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
//			std = session.get(Student.class,id);
			
			session.createQuery("update Student  set email='hey_google@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			System.out.println(std);
			System.out.println("Done!");
		}
	
		finally{
			
		factory.close();
			
		}

	}

}
