package com.dcoder.controller;

import com.dcoder.model.Todo;
import com.dcoder.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    private final TodoService todoService;
    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("todos", todoService.getAll());
        return "index";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("todo", todoService.getById(id));
        return "index";
    }

    @GetMapping("/new")
    public String createPage(Model model) {
        model.addAttribute("todo", new Todo(null, "", "", false, LocalDate.now()));
        return "new";
    }

    @PostMapping("/")
    public String create(@ModelAttribute Todo todo){
        todoService.create(todo);
        return "redirect:/todos/";
    }

    @GetMapping("/update")
    public String updateById(@PathVariable("id") Integer id, Todo todo, Model model){
        model.addAttribute("todo", todoService.updateById(id, todo));
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteById(@PathVariable("id") Integer id){
        todoService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String getByTask(@RequestParam Map<String, String> params, Model model) {
        List<Todo> todos = todoService.getByTask(params);
        model.addAttribute("todos", todos);
        return "redirect:/";
    }

//    @GetMapping("/search")
    public String getByIsDone(@RequestParam Map<String, Boolean> params, Model model) {
        List<Todo> todos = todoService.getByIsDone(params);
        model.addAttribute("todos", todos);
        return "redirect:/";
    }


}
