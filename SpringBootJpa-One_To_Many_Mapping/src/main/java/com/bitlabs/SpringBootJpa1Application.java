package com.bitlabs;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.bitlabs.entity.Course;
import com.bitlabs.entity.Student;
import com.bitlabs.repository.CourseRepository;
import com.bitlabs.repository.StudentRepository;

@SpringBootApplication
public class SpringBootJpa1Application implements CommandLineRunner{
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpa1Application.class, args);
	}



	@Transactional
public void run(String...args) throws Exception{
		
	
	//create a course
	ArrayList<Student> al=new ArrayList<Student>();
	
	Course course= new Course();
	course.setName("java");

	
	Student s1=new Student();
	s1.setName("bhagya");
	s1.setCourse(course);
	
	Student s2=new Student();
	s2.setName("Ram");
	s2.setCourse(course);
	
	
	
	
	al.add(s1);
al.add(s2);
	
	course.setStudents(al);
	
	
	
	 // Save the course and students to the database
	courseRepository.save(course);
	studentRepository.save(s1);
	studentRepository.save(s2);
	
	Course retrievedCourse = courseRepository.getById(course.getId());
	if (retrievedCourse != null) {
	    System.out.println("course name is " + retrievedCourse.getName());
	   java.util.List<Student> students = retrievedCourse.getStudents(); // Explicitly fetch students
	    if (students != null) {
	        for (Student student : students) {
	            System.out.println("Student name is " + student.getName());
	        }
	    }
	}

	
}


}
