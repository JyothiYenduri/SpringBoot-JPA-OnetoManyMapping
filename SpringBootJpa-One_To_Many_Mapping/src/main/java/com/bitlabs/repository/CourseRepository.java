package com.bitlabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitlabs.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

}
