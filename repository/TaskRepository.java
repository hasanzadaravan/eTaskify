package com.eTaskifyApi.eTaskify.repository;

import com.eTaskifyApi.eTaskify.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
