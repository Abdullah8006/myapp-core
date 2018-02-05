package com.aslam.haris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aslam.haris.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Todo findById(int id);
}
