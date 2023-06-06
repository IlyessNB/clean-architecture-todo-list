package fr.esgi.todolist.domain;

public interface TodoListHandler {
    TodoList getTodoList();
    void addTask(Task task);
    void removeTask(Task task);
    void updateTask(Task task);
}