package com.anrgsh33.crud.services;

import com.anrgsh33.crud.models.TaskModel;
import com.anrgsh33.crud.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskModel> getAllTasks() {
        return taskRepository.findAll();
    }

    public TaskModel getTaskById(int id) {
        Optional<TaskModel> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    public TaskModel createTask(TaskModel task) {
        return taskRepository.save(task);
    }

    public TaskModel updateTask(int id, TaskModel taskDetails) {
        Optional<TaskModel> taskOptional = taskRepository.findById(id);
        if (taskOptional.isPresent()) {
            TaskModel task = taskOptional.get();
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setDue_Date(taskDetails.getDue_Date());
            task.setPriority_level(taskDetails.getPriority_level());
            task.setAssignment(taskDetails.getAssignment());
            return taskRepository.save(task);
        }
        return null;
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
