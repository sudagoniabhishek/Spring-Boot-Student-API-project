package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

	public Student saveStudent(Student std);
	
	public List<Student> getAllStudent();
	
	public Student getStudent(Integer student_Id);
	
	public void deleteStudent(Integer student_id);
	
	public Student updateStudent(Integer student_Id,Student std);
}