package com.org.hibernate.student.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Column(name="STUDENT_ID",precision=15,scale=0)
	@Id
	private long studentId;
	@Column(name="STUDENY_NAME",length=25)
	private String studentName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="STUDENT_COURSE",joinColumns={@JoinColumn(name="STUDENT_ID")},
				inverseJoinColumns={@JoinColumn(name="COURSE_ID")})
	private Set<Course> courses;
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
