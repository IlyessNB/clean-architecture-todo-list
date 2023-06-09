package fr.esgi.todolist.domain;

import java.util.Optional;

public interface TodoListRepository {
    void save(TodoList todoList);

    Optional<TodoList> get();

    TaskId nextTaskId();
}