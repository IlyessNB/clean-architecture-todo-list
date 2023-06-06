package fr.esgi.todolist.domain;

import java.util.List;

public class TodoList {
    private List<Task> tasks;

    private TodoList() {
        this.tasks = List.of();
    }

    public static TodoList of() {
        return new TodoList();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }
}
