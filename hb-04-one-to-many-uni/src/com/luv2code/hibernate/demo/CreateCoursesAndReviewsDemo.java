package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
//import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		// TODO Auto-generated method stub

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Course tempCourse = new Course("Packman - How to score 1 million points");
			
			tempCourse.addReview(new Review("Cool course!"));
			tempCourse.addReview(new Review("Great  course "));
			tempCourse.addReview(new Review("What a waste of time."));
			
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
//			System.out.println();
			
			session.save(tempCourse);
			
						
			session.getTransaction().commit();
			System.out.println("Done!");
		}

		finally {

			session.close();

			factory.close();

		}
	}

}
