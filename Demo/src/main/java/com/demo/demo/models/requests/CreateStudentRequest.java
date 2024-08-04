package com.demo.demo.models.requests;

import lombok.Data;

import java.util.List;

@Data
public class CreateStudentRequest {

    private String name;
    private String email;
    private List<CreateSubjectRequest> subjectsLearning;
}