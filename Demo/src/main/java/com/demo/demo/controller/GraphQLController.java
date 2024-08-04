package com.demo.demo.controller;

import com.demo.demo.models.requests.SampleRequest;
import com.demo.demo.models.responses.StudentResponse;
import com.demo.demo.models.requests.CreateStudentRequest;
import com.demo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.demo.demo.models.responses.StudentResponse.StudentResponses;

@Controller
public class GraphQLController {

    @MutationMapping
    public String fetchFullName(@Argument SampleRequest sampleRequest) {
        System.out.println("hello1 ");
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    @Autowired
    private StudentService studentService;

    @QueryMapping
    public StudentResponse getStudent(@Argument Long id) {
        System.out.println("hello2 ");
        return new StudentResponse(studentService.getStudentById(id));
    }

    @QueryMapping
    public List<StudentResponse> getStudents() {
        System.out.println("hello3 ");
        return StudentResponses(studentService.getAllStudents());
    }


    @MutationMapping
    public StudentResponse createStudent(@Argument CreateStudentRequest request) {
        return new StudentResponse(studentService.createStudent(request));
    }

}
