package com.dcoder;

import com.dcoder.controller.TodoController;
import com.dcoder.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListSpringWebMVCApplication {
    public static void main(String[] args) {
        SpringApplication.run(ToDoListSpringWebMVCApplication.class, args);
    }
}
