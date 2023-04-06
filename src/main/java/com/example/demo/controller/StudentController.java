package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;



@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<Student> saveTask(@RequestBody Student std) {

		return new ResponseEntity<>(studentService.saveStudent(std), HttpStatus.CREATED);

	}

	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudent() {

		return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
	}

	@GetMapping("/getStudent/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable(name = "id") Integer stdId) {
		return new ResponseEntity<>(studentService.getStudent(stdId), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Integer id) {
		studentService.deleteStudent(id);
		return new ResponseEntity<>("student removed successfully", HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") Integer stdId,
			@RequestBody Student student) {
		return new ResponseEntity<>(studentService.updateStudent(stdId, student), HttpStatus.OK);

	}

}