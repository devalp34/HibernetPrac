package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class TestHbMap {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		//String title = "Maths";
		int id = 10;
		try
		{
			session.beginTransaction();
			Course cs = session.get(Course.class, id);
			System.out.println("Selected Course is :"+cs);
			session.delete(cs);
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			sf.close();
		}
	}

}
