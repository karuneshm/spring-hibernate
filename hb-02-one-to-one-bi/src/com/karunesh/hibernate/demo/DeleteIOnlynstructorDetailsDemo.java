package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Student;

public class DeleteIOnlynstructorDetailsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();

			int theID = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theID);
			
			System.out.println(instructorDetail);
			
			
			System.out.println(instructorDetail.getInstructor());
			
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);
			
			session.getTransaction().commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			finally {
		
				session.close();
			factory.close();
		}
	}

}
