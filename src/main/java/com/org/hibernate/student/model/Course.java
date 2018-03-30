package com.org.hibernate.student.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="COURSE")
public class Course {
	
	@Column(name="COURSE_ID",precision=15,scale=0)
	@Id
	private long courseId;
	@Column(name="COURSE_NAME",length=20)
	private String courseName;
	@Column(name="COURSE_DURATION",precision=3,scale=0)
	private int courseDuration;
	@ManyToMany(mappedBy="courses")
	private Set<Student> students;
	
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	
}
