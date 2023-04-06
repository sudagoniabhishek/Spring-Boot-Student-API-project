package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.StudentNotFound;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);

	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> std = studentRepository.findAll();
		return std;
	}

	@Override
	public Student getStudent(Integer stdId) {
		Student std = studentRepository.findById(stdId)
				.orElseThrow(() -> new StudentNotFound(String.format("Student Id %d Not  Found", stdId)));

		return std;
	}

	@Override
	public void deleteStudent(Integer stdId) {

		 studentRepository.findById(stdId)
				.orElseThrow(() -> new StudentNotFound(String.format("Student Id %d Not  Found", stdId)));

		studentRepository.deleteById(stdId);

	}

	@Override
	public Student updateStudent(Integer stdId, Student student) {

		Student std = studentRepository.findById(stdId)
				.orElseThrow(() -> new StudentNotFound(String.format("Student Id %d Not  Found", stdId)));
		std.setStudentName(student.getStudentName());
		std.setStudentCourse(student.getStudentCourse());
		std.setFee(student.getFee());
		std.setM1(student.getM1());
		std.setM2(student.getM2());
		std.setM2(std.getM3());
		return std;

	}
}