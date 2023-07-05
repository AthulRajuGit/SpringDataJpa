package com.example.model.REPO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.MODEL.Course;
import com.example.model.MODEL.Teacher;

@SpringBootTest
class TeacherRepoTest {

	@Autowired
	private TeacherRepo teacherRepo;
	
	@Test
	public void saveTeacher() {
		
		Course courseDB=Course.builder().title("DB").credit(6).build();
		Course courseSP=Course.builder().title("Spring").credit(6).build();
		
		Teacher teacher=Teacher.builder().firstName("Shabbir").lastName("Khan")
				//.courses(List.of(courseDB,courseSP))
				.build();
		
		teacherRepo.save(teacher);
	}

}
