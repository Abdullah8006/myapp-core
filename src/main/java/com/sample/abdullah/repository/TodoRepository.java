package com.sample.abdullah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.abdullah.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

	Todo findById(int id);
}
