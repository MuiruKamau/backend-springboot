package com.example.demo.controller;

import com.example.demo.Model.Tasks;
import com.example.demo.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
@RestController
@RequestMapping("/api/tasks")
@Slf4j
public class TaskController {

    @Autowired
    TaskService taskService;

    @GetMapping("/all")
    public List<Tasks> getAllTasks() {
        log.info("ALL-OBJECT" + taskService.getAllTasks());
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tasks> getTaskById(@PathVariable Long id, Tasks task) {

        log.info("CHECKINGS -->" + taskService.getTasksById(id));
        return  new ResponseEntity<>(taskService.getTasksById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks task) {
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable Long id,@RequestBody Tasks task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

