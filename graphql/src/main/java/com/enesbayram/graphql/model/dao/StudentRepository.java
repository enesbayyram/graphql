package com.enesbayram.graphql.model.dao;

import java.util.List;

import com.enesbayram.graphql.model.Student;

public interface StudentRepository {

	public List<Student> getStudents();
	
	public Student getStudentById(Long id);
	
	public Student create(Student student);
}
