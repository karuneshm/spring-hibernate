package com.karunesh.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.karunesh.hibernate.demo.entity.Course;
import com.karunesh.hibernate.demo.entity.Instructor;
import com.karunesh.hibernate.demo.entity.InstructorDetail;
import com.karunesh.hibernate.demo.entity.Review;
import com.karunesh.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			Course course = new Course("Java Hibernate");
		
			session.save(course);
			
			
			Student tempStudent1 = new Student("John","Doe","john@gmail.com");
			Student tempStudent2 = new Student("Mary","Public","mary@gmail.com");
			
			
			course.addStudent(tempStudent1);
			course.addStudent(tempStudent2);
			
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			System.out.println(course.getStudents());
			
			session.getTransaction().commit();} finally {
			session.close();
			factory.close();
		}
	}

}
