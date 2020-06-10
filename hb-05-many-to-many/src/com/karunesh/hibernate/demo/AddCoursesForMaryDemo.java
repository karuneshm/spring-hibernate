package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Course;
import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Review;
import com.karunesh.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
		
		
		try {
			

			session.beginTransaction();
			
			int studentId = 2;
			
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println(tempStudent);
			
			System.out.println(tempStudent.getCourses());
			
			Course course1 = new Course("SudoKo solve");
			
			Course course2 = new Course("Rubik's Cube");
			
			course1.addStudent(tempStudent);
			course2.addStudent(tempStudent);
			
			session.save(course1);
			session.save(course2);
			
			
			
		
			
			session.getTransaction().commit();
			
		
			
		} finally {
			session.close();
			factory.close();
		}
	}

}
