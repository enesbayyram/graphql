package com.enesbayram.graphql.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.enesbayram.graphql.model.Student;
import com.enesbayram.graphql.model.dao.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager em;

	@Override
	public List<Student> getStudents() {
		List<Student> students = null;
		try {
			students = em.createQuery("from Student", Student.class).getResultList();
		} catch (Exception e) {
			System.out.println("Hata olustu : " + e.getMessage());
		}
		return students;
	}

	@Override
	public Student getStudentById(Long id) {
		Student student = null;
		try {
			student = em.createQuery("from Student where id=:id", Student.class).setParameter("id", id)
					.getSingleResult();
		} catch (Exception e) {
			System.out.println("Hata olustu : " + e.getMessage());
		}
		return student;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Student create(Student student) {
		try {
			em.persist(student);
		} catch (Exception e) {
			System.out.println("Ogrenci eklenirken hata olustu : " + e.getMessage());
		}
		return student;
	}

}
