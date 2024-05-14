package com.demo.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.graphql.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
