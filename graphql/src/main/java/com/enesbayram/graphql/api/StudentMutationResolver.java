package com.enesbayram.graphql.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.enesbayram.graphql.model.Student;
import com.enesbayram.graphql.model.dao.StudentRepository;

@Component
public class StudentMutationResolver implements GraphQLMutationResolver{

	@Autowired
	private StudentRepository studentRepository;
	
	public Student create(StudentDto studentDto) {
		return studentRepository.create(convertToDtoObject(studentDto));
	}
	
	
	private Student convertToDtoObject(StudentDto studentDto) {
		Student student  = new Student();
		student.setFirstName(studentDto.getFirstName());
		student.setLastName(studentDto.getLastName());
		student.setGender(studentDto.getGender());
		return student;
	}
}
