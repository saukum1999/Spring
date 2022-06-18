package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			int id = 222;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,id);
			
			System.out.println("Found Instructor Detail: "+tempInstructorDetail);
			
			System.out.println("Print associate Instructor: "+ tempInstructorDetail.getInstructor());
//			if(tempInstructorDetail != null) {
//				System.out.println("Deleting Instructor: " + tempInstructorDetail);
//				session.delete(tempInstructorDetail);
//			}
					
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
		finally{
			session.close();
		factory.close();
			
		}
	}

}
