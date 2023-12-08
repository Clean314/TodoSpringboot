package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.model.dto.TodoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class TodoServiceTest {
    @Autowired
    private TodoService todoService;

    @Test
    public void crud(){
//        TodoDTO todo1 = todoService.createTodo("todo1");
//        TodoDTO todo2 = todoService.createTodo("todo2");
//        TodoDTO todo3 = todoService.createTodo("todo3");
//        todoService.getAllTodo().forEach(System.out::println);
//
//        todo1.setContents("completed todo");
//        todo1.setCompleted(true);
//        todoService.updateTodo(todo1.getId(), todo1);
//        todoService.getAllTodo().forEach(System.out::println);
//
//        todoService.deleteTodo(todo3.getId());
//        todoService.getAllTodo().forEach(System.out::println);

    }
}