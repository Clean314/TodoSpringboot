package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.model.dto.TodoDTO;
import com.example.todo.repository.TodoRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private TodoDTO convertToDto(Todo todo) {
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todo.getId());
        todoDTO.setContents(todo.getContents());
        todoDTO.setCompleted(todo.isCompleted());
        return todoDTO;
    }

    // ???
    public List<TodoDTO> getAllTodo(){
        return todoRepository.findAll()
                .stream().map(this::convertToDto)
                .collect(Collectors.toList());
    }
    public void createSample() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/sample.json");
        List<Todo> todos = objectMapper.readValue(inputStream, new TypeReference<List<Todo>>() {});
        todoRepository.saveAll(todos);
    }

    public TodoDTO createTodo(TodoDTO todoDTO){
        Todo todo = new Todo();
        todo.setContents(todoDTO.getContents());
        todo.setCompleted(todoDTO.isCompleted());
        return convertToDto(todoRepository.save(todo));
    }

    public TodoDTO updateTodo(Long id, TodoDTO newTodo){
        Todo updateTodo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo id " + id + "not found."));

        updateTodo.setContents(newTodo.getContents());
        updateTodo.setCompleted(newTodo.isCompleted());

        return convertToDto(todoRepository.save(updateTodo));
    }

    public void deleteTodo(Long id){
        Todo deleteTodo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo id " + id + "not found."));
        todoRepository.delete(deleteTodo);
    }

    public void deleteAll(){
        todoRepository.deleteAll();
    }
}
