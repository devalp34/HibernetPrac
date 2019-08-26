package com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "title")
	String title;
	
	@JoinColumn(name = "instructor_id")
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	Instructor inst;

	@OneToMany(cascade = CascadeType.ALL,
				fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	List<Review> review ;
	
	@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH},
				fetch = FetchType.LAZY)
	@JoinTable(name = "course_student",
				joinColumns = @JoinColumn(name = "course_id"),
				inverseJoinColumns = @JoinColumn(name = "student_id"))
	List<Student> student;
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInst() {
		return inst;
	}

	public void setInst(Instructor inst) {
		this.inst = inst;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

	public Course(String title) {
		this.title = title;
	}

	public Course() {
	}

	public void add(Review tempReview)
	{
		if(review == null)
		{
			review = new ArrayList<>();
		}
		review.add(tempReview);
	}
	
	public void addStudent(Student tempStudent)
	{
		if(student == null)
		{
			student = new ArrayList<>();
		}
		student.add(tempStudent);
	}
}
