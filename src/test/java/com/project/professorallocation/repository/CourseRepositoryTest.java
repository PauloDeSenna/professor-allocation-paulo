package com.project.professorallocation.repository;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professorallocation.model.Course;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class CourseRepositoryTest {
	@Autowired
	CourseRepository repository;
	
	@Test
    public void findAll() {
    	List<Course> itemC = repository.findAll();
    	
    	System.out.println("Qtd de elementos retornados: " + itemC.size());
    	
    	for(Course item3 : itemC) {
          System.out.println(item3);
    	}
    	
       } 		
	@Test
    public void findSpecificCourse() {
    	Course curs = repository.findById(5425L).orElse(null); 
    	System.out.println(curs);
	}	
	@Test
    public void create() {
		Course CourseBeingCreated = new Course();
		CourseBeingCreated.setName("curso");
		
		System.out.println("Id atual: "+CourseBeingCreated.getId());
		CourseBeingCreated = repository.save(CourseBeingCreated);
		System.out.println("Id após salvar: "+CourseBeingCreated.getId());
		
		
    }
	@Test
    public void update() {
    	Course CourseBeingCreated = new Course();
    	
    	CourseBeingCreated.setId(1L);
    	CourseBeingCreated.setName("313");
		
		System.out.println("Id atual: "+CourseBeingCreated.getId());
		CourseBeingCreated = repository.save(CourseBeingCreated);
		System.out.println("Id após salvar: "+CourseBeingCreated.getId());
    	
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



