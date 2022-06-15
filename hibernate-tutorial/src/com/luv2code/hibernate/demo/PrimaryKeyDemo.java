package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new object");
			Student temp1 = new Student("Sam","Witvicky","sam_witvickey@gmail.com");
			Student temp2 = new Student("Tom","Riddle","tom@gmail.com");
			Student temp3 = new Student("Harry","Potter","harry@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("Saving student object");
			session.save(temp1);
			session.save(temp2);
			session.save(temp3);
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
	
		finally{
			
		factory.close();
			
		}

	}

}
