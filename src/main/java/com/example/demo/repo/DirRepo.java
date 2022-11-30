package com.example.demo.repo;

import com.example.demo.models.Director;
import com.example.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface DirRepo extends CrudRepository<Director, Integer> {
}
