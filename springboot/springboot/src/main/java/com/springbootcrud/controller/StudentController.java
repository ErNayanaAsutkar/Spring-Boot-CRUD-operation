package com.springbootcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.entity.Student;
import com.springbootcrud.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;

	@GetMapping("/findallstudents")
	public List<Student> findAllStudents(List<Student> students) {
		return service.getStudents(students);
	}

	@GetMapping("/findstudentbyid/{id}")
	public Optional<Student> findStudentById(@PathVariable int id) {
		return service.getStudentsById(id);
	}

	@GetMapping("/findstudentbyname/{name}")
	public Optional<Student> findStudentByname(@PathVariable String name) {
		return service.getStudentsByName(name);
	}

	@PostMapping("/addstudent")
	public Student addStudent(@RequestBody Student student) {
		return service.AddStudent(student);

	}

	@PostMapping("/addstudents")
	public List<Student> addStudent(@RequestBody List<Student> students) {
		return service.AddStudents(students);

	}
	@PutMapping("/update")
	public Student updateStudent(@RequestBody Student students) {
		return service.updateStudent(students);

	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
		
	}

}
