package com.jeclipse.testDrive.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "name")
	String name;
	
	@Column(name = "lastName")
	String lastName;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "email")
	String email;
	
	@Column(name = "teacher")
	String teacher;

	public Student() {
	}

	public Student(String name, String lastName, int age, String email, String teacher) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.teacher = teacher;
	}
	
	

	public Student(int id, String name, String lastName, int age, String email, String teacher) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.teacher = teacher;
	}

	public int getId() {
		return id;
	}
	


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", age=" + age + ", email=" + email
				+ ", teacher=" + teacher + "]";
	}

}
