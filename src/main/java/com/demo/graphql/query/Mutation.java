package com.demo.graphql.query;


import com.demo.graphql.request.CreateStudentRequest;
import com.demo.graphql.response.StudentResponse;
import com.demo.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Mutation {
    @Autowired
    private StudentService studentService;

    @MutationMapping
    public StudentResponse createStudent(@Argument CreateStudentRequest request) {
        return new StudentResponse(studentService.createStudent(request));
    }
//    mutation MyMutation {
//  createStudent(
//    request:{
//      city: "Riyadh",
//      email: "habiba@gmail.com",
//      firstName: "habiba",
//      lastName: "shara",
//      street: "Aziz el Masry",
//      subjectsLearning: [
//        {marksObtained: 20, subjectName: "Math"},
//        {marksObtained: 50, subjectName: "Science"}
//      ]}
//  ) {
//    id
//   city
//    firstName
//    id
//    email
//    fullName
//    lastName
//    learningSubjects {
//      marksObtained
//      subjectName
//    }
//  }
//}





}
