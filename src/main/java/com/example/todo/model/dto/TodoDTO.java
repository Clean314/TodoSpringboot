package com.example.todo.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDTO {
    private Long id;
    private String contents;
    private boolean completed;
}
