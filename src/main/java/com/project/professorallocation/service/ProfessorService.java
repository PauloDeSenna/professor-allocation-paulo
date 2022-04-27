package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Professor;
import com.project.professorallocation.repository.ProfessorRepository;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;

	public ProfessorService(ProfessorRepository repository) {
		super();
		this.repository = repository;
	}
	private Professor saveInternal(Professor professor) {
		Professor insertedDepartment = repository.save(professor);
		return insertedDepartment;
	}

	public Professor create(Professor professor) {
		professor.setId(null);
		return saveInternal(professor);
	}

	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveInternal(professor);
		}
	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}
	}
	public Professor searchById(Long id) {
		return repository.findById(id).orElse(null);
	}
	public List<Professor> findAll() {
		return repository.findAll();
	}
}
