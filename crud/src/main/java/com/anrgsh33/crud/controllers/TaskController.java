package com.anrgsh33.crud.controllers;

import com.anrgsh33.crud.models.TaskModel;
import com.anrgsh33.crud.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tms")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskModel>> getTasks() {
        List<TaskModel> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskModel> getTaskById(@PathVariable int id) {
        TaskModel task = taskService.getTaskById(id);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create-task")
    public ResponseEntity<TaskModel> createTask(@RequestBody TaskModel task) {
        TaskModel createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/update-task/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable int id, @RequestBody TaskModel taskDetails) {
        TaskModel updatedTask = taskService.updateTask(id, taskDetails);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>("Task Deleted", HttpStatus.OK);
    }
}
