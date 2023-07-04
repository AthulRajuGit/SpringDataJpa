package com.example.model.REPO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.MODEL.Guardian;
import com.example.model.MODEL.Student;

@SpringBootTest
class StudentRepoTest {
	
	@Autowired
    private StudentRepo studentRepo;
	
	@Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepo.save(student);

    }

	@Test
    public void printByFirstName() {
    	List<Student> student=studentRepo.findByFirstName("Shivam");
    	
    	System.out.println(student);
    	
    	
    }
    
    @Test
    public void printByFirstNameContaining() {
    	List<Student> student=studentRepo.findByFirstNameContaining("sh");
    	System.out.println(student);
    }
    
    @Test
    public void printByGuardianName() {
    	List<Student> student =studentRepo.findByGuardianName("Nikhil");
    	System.out.println(student);
    }
    
    @Test
    public void getfirstNameStudentByEmailAddress() {
    	String stu=studentRepo.getStudentfirstNameByEmailAddress("shivam@gmail.com");
    	
    	System.out.println(stu);
    }
    
    @Test
    public void getStudentByemailAddress() {
    	Student student=studentRepo.getStudentByEmailAddress("shivam@gmail.com");
    	System.out.println(student);
    }
    
    @Test
    public void getStudentByEmaidAddressNative() {
    	Student student=studentRepo.getStudentByEmaidAddressNativeParam("shivam@gmail.com");
    	System.out.println(student);
    }
    
    @Test
    public void updateNameByemailAddress() {
    	studentRepo.updateStudentNameByEmailId("athul","shivam@gmail.com");
    }
}
