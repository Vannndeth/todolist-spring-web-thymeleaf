package com.dcoder.repository;


import com.dcoder.model.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TodoRepository {
    List<Todo> todoList = new ArrayList<>();
    public List<Todo> findAll(){
        for (int i = 1; i <= 10; i++) {
            Todo todo = new Todo();
            todo.setId(i);
            todo.setTask("Task " + i);
            todo.setDescription("Description for Task " + i);
            todo.setIsDone(false);
            todo.setCreatedAt(LocalDate.now());
            todoList.add(todo);
        }
        return todoList;
    }

    public Todo findById(Integer id){
        return todoList.stream()
                .filter(e -> e.equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalided id "+id));
    }

    public Todo save(Todo todo){
        todo.setId(todoList.size()+1);
        todoList.add(todo);
        return todo;
    }

    public Todo updateById(Integer id, Todo todo){
        todoList.stream().filter(e -> e.equals(id))
                .findFirst()
                .ifPresent(e -> {
                    e.setTask(todo.getTask());
                    e.setDescription(todo.getDescription());
                    e.setIsDone(todo.getIsDone());
                    e.setCreatedAt(todo.getCreatedAt());
                });
        return todo;
    }
    public void deleteById(Integer id){
        todoList.removeIf(e -> e.equals(id));
    }

    public List<Todo> findByTask(Map<String, String> params){
        return todoList.stream()
                .filter(todo -> params.getOrDefault("task", "").isEmpty()
                        || todo.getTask().toLowerCase().contains(params.get("task").toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Todo> getByIsDone(Map<String, Boolean> params) {
        return todoList.stream()
                .filter(todo -> params.getOrDefault("isDone", null) == null
                        || todo.getIsDone() == params.get("isDone"))
                .collect(Collectors.toList());
    }


}
