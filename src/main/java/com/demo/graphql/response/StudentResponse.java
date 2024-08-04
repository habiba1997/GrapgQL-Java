package com.demo.graphql.response;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.graphql.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

    private long id;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private Student student;

    private List<SubjectResponse> learningSubjects;

    private String fullName;

    public StudentResponse(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();

        this.student = student;
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();

//		if (student.getLearningSubjects() != null) {
//			learningSubjects = new ArrayList<SubjectResponse>();
//			for (Subject subject: student.getLearningSubjects()) {
//				learningSubjects.add(new SubjectResponse(subject));
//			}
//		}
    }


    public static List<StudentResponse> StudentResponses(List<Student> students) {
        return students.stream().map(StudentResponse::new).collect(Collectors.toList());
    }


}
