package fr.esgi.todolist.domain;

import java.util.List;

public interface TodoListRepository {
    void save(TodoList todoList);

    TodoList get();
}