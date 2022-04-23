package com.project.professorallocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.professorallocation.model.Allocation;

import java.util.List;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation, Long> {
	
     List<Allocation> findByprofessorId(Long professorId);
     
     List<Allocation> findBycourseId(Long courseId);
}
