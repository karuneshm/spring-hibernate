package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.karunesh.hibernate.demo.entity.Course;
import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Student;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ " where i.id=:theInstructorId", Instructor.class);
			
			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor "+tempInstructor);
			
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println(tempInstructor.getCourses());
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
