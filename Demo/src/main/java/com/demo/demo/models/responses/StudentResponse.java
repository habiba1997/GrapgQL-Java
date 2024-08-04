package com.demo.demo.models.responses;

import com.demo.demo.models.Student;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class StudentResponse {

    private long id;
    private String name;
    private String email;
    private Student student;
    private List<SubjectResponse> learningSubjects ;

    public StudentResponse(Student student) {
        // Initialization StudentResponse from a Student entity
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();

        // Student entity will not be displayed in client response as it is not mentioned as a field in graphql schema
        this.student = student;
    }

    public static List<StudentResponse> StudentResponses(List<Student> students) {
        return students.stream().map(StudentResponse::new).collect(Collectors.toList());
    }
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Student getStudent() {
        return student;
    }

    public List<SubjectResponse> getLearningSubjects() {
        return learningSubjects;
    }

}