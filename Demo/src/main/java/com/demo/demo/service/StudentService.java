package com.demo.demo.service;


import com.demo.demo.models.Student;
import com.demo.demo.models.Subject;
import com.demo.demo.repository.StudentRepository;
import com.demo.demo.repository.SubjectRepository;
import com.demo.demo.models.requests.CreateStudentRequest;
import com.demo.demo.models.requests.CreateSubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    SubjectRepository subjectRepository;


    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);

        // save student to database
        student = studentRepository.save(student);

        List<Subject> subjectsList = new ArrayList<Subject>();

        if (createStudentRequest.getSubjectsLearning() != null) {
            for (CreateSubjectRequest request : createStudentRequest.getSubjectsLearning()) {
                Subject subject = new Subject();
                subject.setSubjectName(request.getSubjectName());
                subject.setMarksObtained(request.getMarksObtained());
                subject.setStudent(student);

                subjectsList.add(subject);
            }

            subjectRepository.saveAll(subjectsList);

        }

        student.setLearningSubjects(subjectsList);

        return student;
    }

}
