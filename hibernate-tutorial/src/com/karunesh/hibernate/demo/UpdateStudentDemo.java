package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			session.beginTransaction();
			
			int theId = 1;
			
			Student student = session.get(Student.class,theId);
			
			System.out.println(student);
			
			student.setLastName("Kamble");
			
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			int rowsUpdated = session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			System.out.println(rowsUpdated);
			
			session.getTransaction().commit();
			
			
			
			
		} finally {
			factory.close();
		}
	}

}
