package com.project.professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.professorallocation.model.Department;
import com.project.professorallocation.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

	private DepartmentService service;

	public DepartmentController(DepartmentService service) {
		super();
		this.service = service;
	}
	
	@GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Department>> findall(){
		List<Department> allDepartments = service.findAll();
		
		return new ResponseEntity<>(allDepartments, HttpStatus.OK);
	}
	@GetMapping(path = "/{dept_id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Department> searchById(@PathVariable(name = "dept_id") Long id){
		Department item = service.searchById(id);
		
		if(item == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(item, HttpStatus.OK);
		
	}
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Department> create(@RequestBody Department dept){
	Department item = service.create(dept);

	return new ResponseEntity<>(item, HttpStatus.OK);
	}
}
