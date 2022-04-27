package com.project.professorallocation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.professorallocation.model.Allocation;
import com.project.professorallocation.repository.AllocationRepository;

@Service
public class AllocationService {
	private final AllocationRepository repository;

	public AllocationService(AllocationRepository repository) {
		super();
		this.repository = repository;
	}

	public Allocation findbyId(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Allocation> findAll() {
		return repository.findAll();
	}

	public void deleteById(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
		}

	}

	public Allocation create(Allocation allocation) throws Exception {
		allocation.setId(null);
		return saveInternal(allocation);
	}

	private Allocation saveInternal(Allocation allocation) throws Exception {
		if (hasCollision(allocation)) {
			throw new Exception("there is a time collision for this allocation.");
		}
		Allocation createdAllocation = repository.save(allocation);
		return createdAllocation;
	}

	public Allocation update(Allocation allocation) throws Exception {
		Long id = allocation.getId();
		if (id == null || !repository.existsById(id)) {
			return null;
		} else {
			return saveInternal(allocation);
		}

	}

	public boolean hasCollision(Allocation newAllocation) {
		boolean collisionFound = false;
		List<Allocation> currentAllocations = repository.findByprofessorId(newAllocation.getProfessorId());

		for (Allocation currentAllocation : currentAllocations) {
			if (hasCollision(currentAllocation, newAllocation)) {
				collisionFound = true;
				break;
			}
		}
		return collisionFound;
	}

	public boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		boolean collision = !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getProfessorId().equals(newAllocation.getProfessorId())
				&& currentAllocation.getDayOfWeek().equals(newAllocation.getDayOfWeek())
				&& currentAllocation.getStartHour().compareTo(newAllocation.getEndHour()) < 0
				&& newAllocation.getStartHour().compareTo(currentAllocation.getEndHour()) < 0;
		return collision;

	}

}
