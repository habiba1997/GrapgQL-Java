package com.demo.graphql.repository;

import com.demo.graphql.entity.Address;
import com.demo.graphql.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
