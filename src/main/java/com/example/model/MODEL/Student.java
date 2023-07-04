package com.example.model.MODEL;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(
		name="tbl_student",
		uniqueConstraints=@UniqueConstraint(
				name="emailId_unique",
				columnNames="email_address"
			)
		)
public class Student {
    
	@Id
	@SequenceGenerator(
			name="student_sequnce",
			sequenceName="student_sequnce",
			allocationSize=1
			)
	@GeneratedValue( strategy=GenerationType.SEQUENCE,generator="student_sequnce")
	private long studentId;
	
	private String firstName;
	private String lastName;
	
	@Column(
			name="email_address",
			nullable=false
			)
	
	private String emailId;
	
	@Embedded
	private Guardian guardian;
	
	
	
}
