package com.demo.demo.models.responses;

import com.demo.demo.models.Subject;

public class SubjectResponse {

    private Long id;
    private String subjectName;
    private Double marksObtained;

    public SubjectResponse(Subject subject) {
        // Initialization from a Subject entity
        this.id = subject.getId();
        this.subjectName = subject.getSubjectName();
        this.marksObtained = subject.getMarksObtained();
    }
}