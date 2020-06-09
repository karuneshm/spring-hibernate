package com.karunesh.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			session.beginTransaction();
			
			List<Student> studentList = session.createQuery("from Student").getResultList();
			
			displayStudent(studentList);
			
			
			studentList = session.createQuery("from Student s where s.lastName='maisalge'").getResultList();
			
			displayStudent(studentList);
			
			studentList = session.createQuery("from Student s where s.lastName='maisalge' OR s.firstName='lokesh'").getResultList();
			
			displayStudent(studentList);
			
			studentList = session.createQuery("from Student s where s.email Like '%gmail.com'").getResultList();
			
			displayStudent(studentList);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> studentList) {
		for(Student tempStudent: studentList) {
			System.out.println(tempStudent);
		}
	}

}
