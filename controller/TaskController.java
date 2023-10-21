package com.eTaskifyApi.eTaskify.controller;

import com.eTaskifyApi.eTaskify.dto.TaskRequest;
import com.eTaskifyApi.eTaskify.model.Status;
import com.eTaskifyApi.eTaskify.model.Task;
import com.eTaskifyApi.eTaskify.model.User;
import com.eTaskifyApi.eTaskify.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setDeadline(taskRequest.getDeadline());
        task.setStatus(Status.TODO);
        task.setAssignees(new HashSet<>(taskRequest.getAssigneeIds().stream()
                .map(id -> new User(id))
                .collect(Collectors.toSet())));

        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
}
