package com.dcoder.service;

import com.dcoder.model.Todo;

import java.util.List;
import java.util.Map;

public interface TodoService {
    public List<Todo> getAll();
    public Todo getById(Integer id);
    public Todo create(Todo todo);
    public Todo updateById(Integer id, Todo todo);
    public void deleteById(Integer id);
    public List<Todo> getByTask(Map<String, String> params);
    public List<Todo> getByIsDone(Map<String, Boolean> params);

}
