package com.example.model.REPO;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.MODEL.Course;

public interface CourseRepo extends JpaRepository<Course,Long>{

	
	Page<Course> findCourseByTitle(String title,Pageable pageable);
}
