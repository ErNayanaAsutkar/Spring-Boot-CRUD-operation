package com.springbootcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootcrud.entity.Student;
import com.springbootcrud.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository  repository;
	
	// add single student
	public Student AddStudent(Student student) {
		return repository.save(student);
	}
	
	//add List of student
	public List<Student> AddStudents(List<Student> students) {
		return repository.saveAll(students);
	}
	
	//to get the product By Id
    public Optional<Student> getStudentsById(int id) {
    	return repository.findById(id);
    }
     //to get the product By name
    public Optional<Student> getStudentsByName(String name) {
    	return repository.findByName(name);
    }
	//to get Student Object
	public List<Student> getStudents(List<Student> students){
		return repository.findAll();
	}
	
	//Delete Student
	public String deleteStudent(int id) {
		repository.deleteById(id);
		return "Student Removed "+id;
	}
	
	//Update Student data
	public Student updateStudent(Student student) {
		Student st = repository.findById(student.getId()).orElse(null);
		st.setName(student.getName());
		return repository.save(st);
	}

}
