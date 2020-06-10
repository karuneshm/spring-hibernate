package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Course;
import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
			
			int theId = 1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println(tempInstructor.getCourses());
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
