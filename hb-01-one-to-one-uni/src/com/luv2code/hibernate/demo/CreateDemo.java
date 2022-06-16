package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
//import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("Creating new object");
			Instructor temp = new Instructor ("Sam","Witvicky","sam_witvickey@gmail.com");
			InstructorDetail tempDetail = new InstructorDetail("youtube.com/sam","Youtube");
//			
//			Instructor temp = new Instructor ("Abhi","ram","abhiram@gmail.com");
//			InstructorDetail tempDetail = new InstructorDetail("youtube.com/abhiram","basketball");
			
			temp.setInstructorDetail(tempDetail);
			
			session.beginTransaction();
			
			System.out.println("Saving student object" + temp);
			session.save(temp);
			
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
	
		finally{
			
		factory.close();
			
		}
	}

}
