package com.example.model.REPO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.model.MODEL.Course;
import com.example.model.MODEL.Teacher;

@SpringBootTest
class CourseRepoTest {
    
	@Autowired
	private CourseRepo courseRepo;
	
	@Test
	public void printAllCourses() {
		List<Course> cour=courseRepo.findAll();
		System.out.println(cour);
		
	}

	
	@Test
	public void saveCourseWithTeacher() {
		
		
		Teacher teccher=Teacher.builder().firstName("Priyanka").lastName("Vardhia").build();
		Course course=Course.builder().title("python").credit(4).teacher(teccher).build();
		courseRepo.save(course);
	}
	
	
	@Test
	public void findAllPagination() {
		Pageable pageWithThree =PageRequest.of(0, 3);
		Pageable pageWithTwo=PageRequest.of(1,2);
		
		List<Course> courses=courseRepo.findAll(pageWithThree).getContent();
		System.out.println(courses);
		
		long totalPage=courseRepo.findAll(pageWithThree).getSize();
		System.out.println(totalPage);
		
		
	}
	
	@Test
	public void sortAllPagination() {
		Pageable sortWithTitle=PageRequest.of(1, 2,Sort.by("title").descending());
		
		List<Course> sortCourse=courseRepo.findAll(sortWithTitle).getContent();
		System.out.println(sortCourse);
		
		
		Pageable sortWithTitleandCredit=PageRequest.of(0,3,Sort.by("title").descending().and(Sort.by("credit")));
		
		List<Course> sortC=courseRepo.findAll(sortWithTitleandCredit).getContent();
		System.out.println(sortC);
		
		
	
	}
	
	
	@Test
	public void findAllCoursesByTitle() {
		Pageable findFirstTenCourses=PageRequest.of(0, 10);
		List<Course> courses= courseRepo.findCourseByTitle("DB", findFirstTenCourses).getContent();
		System.out.println(courses);
	}
	
	

}
