package com.example.demo.repo;

import com.example.demo.models.Development;
import com.example.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DevRepo extends CrudRepository<Development, Integer> {
}
