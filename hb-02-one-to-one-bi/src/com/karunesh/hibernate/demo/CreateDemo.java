package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
//			Instructor tempInstructor = 
//					new Instructor("Karunesh", "Maisalge", "karunesh42@gmail.com");
//			
//			InstructorDetail tempInstructorDetail = 
//					new InstructorDetail("http://karunesh.com", "coding");
			
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "karunesh42@gmail.com");
			
			InstructorDetail tempInstructorDetail = 
					new InstructorDetail("http://youtube.com", "Guitar");
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
