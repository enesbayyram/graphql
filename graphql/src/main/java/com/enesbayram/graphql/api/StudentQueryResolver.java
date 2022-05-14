package com.enesbayram.graphql.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.enesbayram.graphql.model.Student;
import com.enesbayram.graphql.model.dao.StudentRepository;

@Component
public class StudentQueryResolver implements GraphQLQueryResolver{

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents(){
		return studentRepository.getStudents();
	}
	
	public Student getStudentById(Long id) {
		return studentRepository.getStudentById(id);
	}
	
	
}
