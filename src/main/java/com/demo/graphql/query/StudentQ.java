package com.demo.graphql.query;

import com.demo.graphql.response.StudentResponse;
import com.demo.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

import static com.demo.graphql.response.StudentResponse.StudentResponses;

@Controller
public class StudentQ             {

	// todo change default  /graphql and /graphiql endpoints
// todo separate the queries into different files if possible
	@Autowired
	private StudentService studentService;

	@QueryMapping
	public StudentResponse getStudent(@Argument Long id) {
		return new StudentResponse(studentService.getStudentById(id));
	}

	@QueryMapping
	public List<StudentResponse> getStudents() {
		return StudentResponses(studentService.getAllStudents());
	}

//	getStudent(id: "4") {
//		id
//				firstName
//		lastName
//		learningSubjects{
//			id
//					subjectName
//			marksObtained
//		}
//	}
}


