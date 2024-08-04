package com.demo.demo.resolvers;

import com.demo.demo.models.Subject;
import com.demo.demo.models.responses.SubjectResponse;
import com.demo.demo.enums.SubjectNameFilter;
import com.demo.demo.models.responses.StudentResponse;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@SchemaMapping(typeName = "StudentResponse")
public class StudentResponseResolver {


    @SchemaMapping(typeName = "StudentResponse")
    public List<SubjectResponse> learningSubjects(StudentResponse studentResponse, @Argument("subjectNameFilter") SubjectNameFilter subjectNameFilter) {
        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
                if (subjectNameFilter == null || subjectNameFilter == SubjectNameFilter.ALL || subject.getSubjectName().equalsIgnoreCase(subjectNameFilter.name())) {
                    learningSubjects.add(new SubjectResponse(subject));
                }
            }
        }

        return learningSubjects;
    }

}