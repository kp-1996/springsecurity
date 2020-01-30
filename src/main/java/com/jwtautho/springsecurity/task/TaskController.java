package com.jwtautho.springsecurity.task;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	private TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", required = true, dataType = "String", paramType = "header")})
    @PostMapping
    public void addTask(@ApiParam(name = "request", value = "HttpServletRequest", required = true)HttpServletRequest req,
    		@ApiParam(name = "payload", value = "Request body", required = true)@RequestBody Task task) {
        taskRepository.save(task);
    }

    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", required = true, dataType = "String", paramType = "header")})
    @GetMapping
    public List<Task> getTasks(@ApiParam(name = "request", value = "HttpServletRequest", required = true)HttpServletRequest req) {
        return taskRepository.findAll();
    }

    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", required = true, dataType = "String", paramType = "header")})
    @PutMapping("/{id}")
    public void editTask(@ApiParam(name = "request", value = "HttpServletRequest", required = true)HttpServletRequest req,
    		@ApiParam(name = "payload", value = "Request body", required = true)@PathVariable long id, @RequestBody Task task) {
        Task existingTask = taskRepository.findById(id).get();
        Assert.notNull(existingTask, "Task not found");
        existingTask.setDescription(task.getDescription());
        taskRepository.save(existingTask);
    }

    @ApiImplicitParams({
    	@ApiImplicitParam(name = "Authorization", required = true, dataType = "String", paramType = "header")})
    @DeleteMapping("/{id}")
    public void deleteTask(@ApiParam(name = "request", value = "HttpServletRequest", required = true)HttpServletRequest req,
    		@ApiParam(name = "payload", value = "Request body", required = true)@PathVariable long id) {
        Task taskToDel = taskRepository.findById(id).get();
        taskRepository.delete(taskToDel);
    }
}
