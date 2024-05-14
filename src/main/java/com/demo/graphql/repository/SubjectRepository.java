package com.demo.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.graphql.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
