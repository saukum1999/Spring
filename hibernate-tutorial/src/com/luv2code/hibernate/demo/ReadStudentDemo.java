package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		
		try {
			
			Session session = factory.getCurrentSession();

			System.out.println("Creating new object");
			Student temp1 = new Student("Sam","Witvicky","sam_witvickey@gmail.com");

			session.beginTransaction();
			
			System.out.println(temp1);
			System.out.println("Saving student object");
			session.save(temp1);
			
			
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();			
			session.beginTransaction();
			
			Student std = session.get(Student.class,temp1.getId());
			
			session.getTransaction().commit();
			System.out.println(std);
			System.out.println("Done!");
		}
	
		finally{
			
		factory.close();
			
		}

	}

}
