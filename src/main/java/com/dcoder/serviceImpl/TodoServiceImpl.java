package com.dcoder.serviceImpl;

import com.dcoder.model.Todo;
import com.dcoder.repository.TodoRepository;
import com.dcoder.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getById(Integer id) {
        return todoRepository.findById(id);
    }

    @Override
    public Todo create(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateById(Integer id, Todo todo) {
        return todoRepository.updateById(id, todo);
    }

    @Override
    public void deleteById(Integer id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> getByTask(Map<String, String> params) {
        return todoRepository.findByTask(params);
    }

    @Override
    public List<Todo> getByIsDone(Map<String, Boolean> params) {
        return todoRepository.getByIsDone(params);
    }

}
