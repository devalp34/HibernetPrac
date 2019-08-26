package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class CourseHbMap {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		int id = 1;
		
		try
		{
			Course cs = new Course("Chem23");
			Course cs1 = new Course("Maths45");
			//tempinst.setInstructrDetail(id);
			session.beginTransaction();
			Instructor inst = session.get(Instructor.class,id);
			inst.add(cs);
			inst.add(cs1);
			session.save(cs);
			session.save(cs1);
			session.getTransaction().commit();
		}
		
		finally
		{
			sf.close();
		}
	}

}
