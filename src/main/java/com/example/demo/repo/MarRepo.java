package com.example.demo.repo;

import com.example.demo.models.Director;
import com.example.demo.models.Marketing;
import org.springframework.data.repository.CrudRepository;

public interface MarRepo extends CrudRepository<Marketing, Integer> {
}
