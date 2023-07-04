package com.example.model.REPO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.MODEL.Course;
import com.example.model.MODEL.CourseMaterial;

@SpringBootTest
class CourseMaterialRepoTest {

	@Autowired
	private CourseMaterialRepo courseMaterialRepo;
	
	@Test
	public void saveCourseMaterial() {
		
		
		
		Course cour=Course.builder().title("DSA").credit(6).build();
		
		CourseMaterial courseMaterial=CourseMaterial.builder().url("www.google.com").course(cour).build();
		
		courseMaterialRepo.save(courseMaterial);
		
		
	}

	@Test
	public void printAllCourseMaterial() {
		List<CourseMaterial> courseM=courseMaterialRepo.findAll();
		System.out.println(courseM);
	}
	
}
