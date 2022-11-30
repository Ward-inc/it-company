package com.example.demo.repo;

import com.example.demo.models.Director;
import com.example.demo.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Integer> {
}
