package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			Student theStudent = new Student("Daffy","duck","Daffy@gmail.com");
			
			session.beginTransaction();
			
			session.save(theStudent);
			
			session.getTransaction().commit();
			
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			Student retrivedStudent = session.get(Student.class, theStudent.getId());
			session.getTransaction().commit();
			
			System.out.println(retrivedStudent.toString());
			
		} finally {
			factory.close();
		}
	}

}
