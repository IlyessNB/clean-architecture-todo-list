package fr.esgi.todolist.domain;

import java.util.List;

public interface FileWriter {
    void write(String filename, TodoList todoList);
}
