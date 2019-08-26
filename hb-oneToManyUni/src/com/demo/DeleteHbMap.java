package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class DeleteHbMap {

	public static void main(String[] args) {

		int id = 1;
		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		try
		{
//			InstructorDetail id = new InstructorDetail("hello","travelling");
//			Instructor tempinst = new Instructor("khushi","patel","devalp34@gmail.com");
//			tempinst.setInstructrDetail(id);
			session.beginTransaction();
			Instructor inst = session.get(Instructor.class, id);
			session.delete(inst);
			session.getTransaction().commit();
		}
		
		finally
		{
			sf.close();
		}
	}

}
