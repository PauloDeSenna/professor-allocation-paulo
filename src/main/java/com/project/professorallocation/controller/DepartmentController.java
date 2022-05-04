package com.project.professorallocation.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Department> findall(){
		List<Department> allDepartments = service.findAll();
		
		return allDepartments;
	}
}
