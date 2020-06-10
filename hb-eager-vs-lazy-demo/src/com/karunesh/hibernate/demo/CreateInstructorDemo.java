package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Course;
import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

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
			Instructor tempInstructor = 
					new Instructor("Susan", "Public", "susan@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://youtube.com", "Video Games");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
