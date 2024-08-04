package com.demo.demo.models.requests;


import lombok.Data;

@Data
public class CreateSubjectRequest {

    private String subjectName;

    private Double marksObtained;

}