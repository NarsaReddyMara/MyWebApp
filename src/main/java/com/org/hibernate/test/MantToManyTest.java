package com.org.hibernate.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.org.hibernate.student.model.Course;
import com.org.hibernate.student.model.Student;
import com.org.hibernate.utility.HibernateUtils;

public class MantToManyTest {

	public static void main(String[] args) {
		Session session = HibernateUtils.createSession();
		
		Student student1 = new Student();
		student1.setStudentId(12345);
		student1.setStudentName("NarsaReddy");
		
		Student student2 = new Student();
		student2.setStudentId(12346);
		student2.setStudentName("Ram");
		
		Student student3 = new Student();
		student3.setStudentId(12347);
		student3.setStudentName("Sridher");
		
		Course course1 = new Course();
		course1.setCourseId(98765);
		course1.setCourseName("Java");
		course1.setCourseDuration(60);
		
		Course course2 = new Course();
		course2.setCourseId(98766);
		course2.setCourseName(".Net");
		course2.setCourseDuration(60);
		
		Course course3 = new Course();
		course3.setCourseId(98767);
		course3.setCourseName("SQL");
		course3.setCourseDuration(60);
		
		Set<Course> s1 = new HashSet<>();
		s1.add(course1);
		s1.add(course2);
		
		Set<Course> s2 = new HashSet<>();
		s2.add(course1);
		s2.add(course3);
		
		Set<Course> s3 = new HashSet<>();
		s3.add(course2);
		s3.add(course3);
		
		Set<Student> c1 = new HashSet<>();
		c1.add(student1);
		c1.add(student2);
		
		Set<Student> c2 = new HashSet<>();
		c2.add(student3);
		c2.add(student2);
		
		Set<Student> c3 = new HashSet<>();
		c3.add(student1);
		c3.add(student3);
		
		student1.setCourses(s1);
		student2.setCourses(s2);
		student3.setCourses(s3);
		
		course1.setStudents(c1);
		course2.setStudents(c2);
		course3.setStudents(c3);
		
		
		Transaction tx = session.beginTransaction();
		session.save(student1);
		session.save(course1);
		session.save(student2);
		session.save(course2);
		session.save(student3);
		session.save(course3);
		tx.commit();

	}

}
