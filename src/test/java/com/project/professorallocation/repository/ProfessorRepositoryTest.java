package com.project.professorallocation.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorRepositoryTest {
	@Autowired
	ProfessorRepository repository;
	
	@Test
    public void findAll() {
    	List<Professor> itemP = repository.findAll();
    	
    	System.out.println("Qtd de elementos retornados: " + itemP.size());
    	
    	for(Professor item2 : itemP) {
          System.out.println(item2);
    	}
    	
       } 		
	@Test
    public void findSpecificProfessor() {
    	Professor prof = repository.findById(5425L).orElse(null); 
    	System.out.println(prof);
	}	
	@Test
    public void create() {
		Professor ProfessorBeingCreated = new Professor();
		ProfessorBeingCreated.setName("Aderbal Júnior");
		ProfessorBeingCreated.setDepartmentId(1L);
		
		System.out.println("Id atual: "+ProfessorBeingCreated.getId());
		ProfessorBeingCreated = repository.save(ProfessorBeingCreated);
		System.out.println("Id após salvar: "+ProfessorBeingCreated.getId());
		
		
    }
	@Test
    public void update() {
    	Professor ProfessorBeingCreated = new Professor();
    	
    	ProfessorBeingCreated.setId(4L);
    	ProfessorBeingCreated.setName("");
		
		System.out.println("Id atual: "+ProfessorBeingCreated.getId());
		ProfessorBeingCreated = repository.save(ProfessorBeingCreated);
		System.out.println("Id após salvar: "+ProfessorBeingCreated.getId());
    	
    }
	@Test
    public void delete() {
    	repository.deleteById(431L);
    	
    }
    @Test
    public void deleteAll() {
    	repository.deleteAllInBatch();
    }
    }

