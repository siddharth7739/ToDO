package com.app.ToDO.controller;

import com.app.ToDO.models.Task;
import com.app.ToDO.services.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {
    private final ToDoService toDoService;

    public TaskController(ToDoService toDoService){
        this.toDoService = toDoService;
    }

    @GetMapping
    public String getTask(Model model){
        List<Task> tasks = toDoService.getAllTask();
        model.addAttribute("tasks",tasks);
        return "tasks";
    }

    @PostMapping
    public String addTask(@RequestParam String title){
        toDoService.addTask(title);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String addTask(@PathVariable Long id){
        toDoService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id){
        toDoService.toggleTask(id);
        return "redirect:/";
    }
}
