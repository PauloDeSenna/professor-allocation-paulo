package com.project.professorallocation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", length= 100, nullable= false)
	private String name;
	
	public Department() {
		super();
	}
	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		this.name = nome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;	
		
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	
	
	}

	
	

