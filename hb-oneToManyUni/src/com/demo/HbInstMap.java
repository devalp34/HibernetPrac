package com.demo;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class HbInstMap {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		
		try
		{
			InstructorDetail id = new InstructorDetail("sleepy","travelling");
			Instructor tempinst = new Instructor("deval","patel","devalp34@gmail.com");
			id.setInst(tempinst);
			session.beginTransaction();
			session.save(id);
			session.getTransaction().commit();
		}
		
		finally
		{
			sf.close();
		}
	}

}
