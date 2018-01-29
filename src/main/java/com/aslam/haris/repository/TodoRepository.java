package com.aslam.haris.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aslam.haris.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Todo findById(int id);
}
