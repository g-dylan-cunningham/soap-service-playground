package com.in28minutes.soap.webservices.soapcoursemanagement.soap.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28minutes.soap.webservices.soapcoursemanagement.soap.bean.Course;


@Component
public class CourseDetailsService {
	
	private static List<Course> courses = new ArrayList<>();
	
	static {
		Course course1 = new Course(1, "Spring", "10 Steps");
		courses.add(course1);
		
		Course course2 = new Course(2, "Spring MVC", "10 steps to success");
		courses.add(course2);
		
		Course course3 = new Course(3, "Spring Boot", "10 Steps til youre there");
		courses.add(course3);
		
		Course course4 = new Course(4, "Spring and Maven", "10 Steps more");
		courses.add(course4);
	}

	// course - get one
	public Course findById(int id) {
		for(Course course:courses) {
			if(course.getId()==id) {
				return course;
			}
		}
		return null;
	}
	
	// courses - get all
	public List<Course> findAll(){
		return courses;
	}
	
	// delete course
	public int deleteById(int id) {
		
		Iterator<Course> iterator = courses.iterator();
		
		while(iterator.hasNext()) {
			Course course = iterator.next();
			if(course.getId()==id) {
				iterator.remove();
				return 1;
			}
		}
		return 0;
	}
	
	
}
