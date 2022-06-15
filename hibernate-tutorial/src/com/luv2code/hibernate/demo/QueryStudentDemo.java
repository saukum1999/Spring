package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();
		
		try {
			
//			System.out.println("Creating new object");
//			Student temp = new Student("Sam","Witvicky","sam_witvickey@gmail.com");
			session.beginTransaction();
			
			List<Student> std = session.createQuery("from Student s where s.firstName = 'Sam'").getResultList();
			
//			System.out.println("Saving student object");
//			session.save(temp);
			
			displayStudents(std);
			
			session.getTransaction().commit();
			System.out.println("Done!");
		}
	
		finally{
			
		factory.close();
			
		}
	}

	private static void displayStudents(List<Student> std) {
		for (Student student : std) {
			System.out.println(student);
		}
	}

}
