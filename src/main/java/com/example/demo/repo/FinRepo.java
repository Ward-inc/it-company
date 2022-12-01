package com.example.demo.repo;

import com.example.demo.models.Director;
import com.example.demo.models.Finances;
import org.springframework.data.repository.CrudRepository;

public interface FinRepo extends CrudRepository<Finances, Integer> {
}
