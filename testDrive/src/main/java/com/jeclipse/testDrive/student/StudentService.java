package com.jeclipse.testDrive.student;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	public final StudentInterf repoObj;
	
	@Autowired
	public StudentService(StudentInterf repository) {
		this.repoObj = repository;
	}

	public List<Student> studentInfo() {
		return repoObj.findAll();
	}
	
	public void saveStudent(Student student) {
		repoObj.save(student);
	}
	
	public void updateStudent(Student student) {
		//student.id=0;
		repoObj.save(student);
	}
	
	public Student getStudentById(int id) {
		Optional<Student> optional = repoObj.findById(id);
		Student student = null;
		if (optional.isPresent()) {
			student = optional.get();
		} else {
			throw new RuntimeException(" Student not found for id :: " + id);
		}
		return student;
	}
	
	public void deleteStudent(Integer id) {
		repoObj.deleteById(id);
	}
	

}
