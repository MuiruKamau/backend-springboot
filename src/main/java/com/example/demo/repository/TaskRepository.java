package com.example.demo.repository;

import com.example.demo.Model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{

}
