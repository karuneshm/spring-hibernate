package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			
			
			session.beginTransaction();
			
			int theId = 1 ;
			
			Student myStudent = session.get(Student.class, theId);
			
			//session.delete(myStudent);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}

}
