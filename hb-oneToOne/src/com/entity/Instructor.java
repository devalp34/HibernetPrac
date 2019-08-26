package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	int id;
	
	@Column(name = "first_name")
	String fname;
	
	@Column(name = "last_name")
	String lname;
	
	@Column(name = "email")
	String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "instructor_detail_id")
	InstructorDetail instructrDetail;

	public InstructorDetail getInstructrDetail() {
		return instructrDetail;
	}

	public void setInstructrDetail(InstructorDetail instructrDetail) {
		this.instructrDetail = instructrDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Instructor(String fname, String lname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}

	
	public Instructor() {
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", instructrDetail=" + instructrDetail + "]";
	}
}
