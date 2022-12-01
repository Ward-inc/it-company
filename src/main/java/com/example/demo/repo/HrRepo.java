package com.example.demo.repo;

import com.example.demo.models.Director;
import com.example.demo.models.HR;
import org.springframework.data.repository.CrudRepository;

public interface HrRepo extends CrudRepository<HR, Integer> {
}
