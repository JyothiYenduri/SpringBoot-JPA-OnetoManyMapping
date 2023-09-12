package com.bitlabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlabs.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}
