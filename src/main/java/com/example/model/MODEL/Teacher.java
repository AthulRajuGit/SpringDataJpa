package com.example.model.MODEL;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

	
	@Id
	@SequenceGenerator(
			name="techer_seq",
			sequenceName="teacher_seq",
			allocationSize=1
			)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="teacher_seq")
	private Long teacherId;
	private String firstName;
	private String lastName; 

	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="teacherId")
    //private List<Course> courses;
}
