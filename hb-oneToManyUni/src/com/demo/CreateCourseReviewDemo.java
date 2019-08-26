package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;

public class CreateCourseReviewDemo {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		int id = 10;
		
		try
		{
//			Course course = new Course("Psychology");
//			Review review = new Review("Very Good Course");
//			
//			course.add(review);
//			course.add(new Review("Boring Course"));
//			course.add(new Review("Do Hard Work"));
//			
			session.beginTransaction();
			Course course = session.get(Course.class, id);
			System.out.println(course.getReview());
			//session.save(course);
			session.delete(course);
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			sf.close();
		}
	}

}
