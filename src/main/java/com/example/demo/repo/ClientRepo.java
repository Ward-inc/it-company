package com.example.demo.repo;

import com.example.demo.models.Client;
import com.example.demo.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, Integer> {
}
