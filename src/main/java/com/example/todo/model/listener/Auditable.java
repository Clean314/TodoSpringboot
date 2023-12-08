package com.example.todo.model.listener;

import java.time.LocalDateTime;

public interface Auditable {
    public LocalDateTime getCreatedAt();
    public LocalDateTime getUpdatedAt();
    public void setCreatedAt(LocalDateTime localDateTime);
    public void setUpdatedAt(LocalDateTime localDateTime);
}
