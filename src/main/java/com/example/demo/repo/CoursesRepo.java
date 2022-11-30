package com.example.demo.repo;

import com.example.demo.models.Courses;
import com.example.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface CoursesRepo extends CrudRepository<Courses, Integer> {
}
