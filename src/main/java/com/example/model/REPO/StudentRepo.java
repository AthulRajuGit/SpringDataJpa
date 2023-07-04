package com.example.model.REPO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.MODEL.Student;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student,Long>{

	
	public List<Student> findByFirstName(String firstName);
	public List<Student> findByFirstNameContaining(String name);
	
	List<Student> findByGuardianName(String name );
	
	@Query("select s.firstName from Student s where s.emailId=?1")
	String  getStudentfirstNameByEmailAddress(String name);
	
	@Query(
			value="Select * from tbl_student s where s.email_address=?1",
			nativeQuery=true
			)
	Student getStudentByEmailAddress(String emailId);
	
	@Query(
			value="select *from tbl_student s where s.email_address= :emailId",
			nativeQuery=true
			)
	Student getStudentByEmaidAddressNativeParam(@Param("emailId") String emailId);
	
	@Transactional
	@Modifying
	@Query(
			value="update  tbl_student  set first_name= :firstName where email_address= :emailId",
			nativeQuery=true
			)
	int updateStudentNameByEmailId(@Param("firstName") String firstName,@Param("emailId") String emailId);
	
}
