package com.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class CourseStudentDemo {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = sf.getCurrentSession();
		//String title = "Maths";
		int id = 2;
		try
		{
			Course cs = new Course("Structure");
			Course cs1 = new Course("Design");
			Course cs2 = new Course("Planning");
			
//			Student tempStudent = new Student("Megha","Patel","hello@gmail.com");
//			Student tempStudent1 = new Student("Deval","Patel","hello246@gmail.com");
//			Student tempStudent2 = new Student("Harsh","Dave","hello###@gmail.com");
//			cs.addStudent(tempStudent);
//			cs.addStudent(tempStudent1);
//			cs.addStudent(tempStudent2);
			
			session.beginTransaction();
		
			Student tempStudent = session.get(Student.class, id);
			tempStudent.add(cs);
			tempStudent.add(cs1);
			tempStudent.add(cs2);
			
			session.save(cs);
			session.save(cs1);
			session.save(cs2);
			
//			System.out.println("Selected Course is :"+cs);
//			session.save(cs);
//			session.save(tempStudent);
//			session.save(tempStudent1);
//			session.save(tempStudent2);
			session.getTransaction().commit();
		}
		
		finally
		{
			session.close();
			sf.close();
		}
	}

}
