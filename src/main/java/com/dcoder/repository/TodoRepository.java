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
    public TodoRepository (){
        todoList.add(new Todo(1, "Java Programming", "Hall booking", true, LocalDate.now()));
        todoList.add(new Todo(2, "JavaScript", "Fetch data from api", true, LocalDate.now()));
        todoList.add(new Todo(3, "ReactJS", "Props and State", false, LocalDate.now()));
        todoList.add(new Todo(4, "NextJS", "Render card from api", true, LocalDate.now()));
        todoList.add(new Todo(5, "Spring Boot", "Build banking api", false, LocalDate.now()));
        todoList.add(new Todo(6, "Spring Security", "Implementation jwt", true, LocalDate.now()));
        todoList.add(new Todo(7, "Flutter", "Clone instagram", false, LocalDate.now()));
    }
    public List<Todo> findAll(){
        return todoList;
    }
    public Todo findById(Integer id){
        return todoList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalided id "+id));
    }

    public Todo save(Todo todo){
        todo.setId(todoList.size()+1);
        todoList.add(todo);
        return todo;
    }

    public void updateById(Todo todo){
        todoList.stream().filter(e -> e.getId().equals(todo.getId()))
                .forEach(e -> {
                    e.setTask(todo.getTask());
                    e.setDescription(todo.getDescription());
                    e.setIsDone(todo.getIsDone());
                    e.setCreatedAt(todo.getCreatedAt());
                });
    }
    public void deleteById(Integer id){
        todoList.stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .ifPresent(todo -> todoList.remove(todo));
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
