package com.demo.demo.models;

import com.demo.demo.models.requests.CreateStudentRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	

	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "student")
	private List<Subject> learningSubjects;
	
	public Student (CreateStudentRequest createStudentRequest) {
		this.name = createStudentRequest.getName();
		this.email = createStudentRequest.getEmail();
	}
}
