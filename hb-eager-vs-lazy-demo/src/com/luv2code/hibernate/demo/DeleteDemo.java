package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int id = 5;
			Instructor tempInstructor = session.get(Instructor.class,id);
			
			System.out.println("Found Instructor: "+tempInstructor);
			if(tempInstructor != null) {
				System.out.println("Deleting Instructor: " + tempInstructor);
				session.delete(tempInstructor);
			}
					
			session.getTransaction().commit();
			System.out.println("Done!");
		}
	
		finally{
			
		factory.close();
			
		}
	}

}
