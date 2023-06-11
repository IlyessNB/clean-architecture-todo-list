package fr.esgi.todolist.domain;

import fr.esgi.todolist.domain.errors.TaskNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private List<Task> tasks;

    private TodoList() {
        this.tasks = new ArrayList<>();
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

    public Task getTaskById(TaskId taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task updateTask(Task task) throws TaskNotFoundException {
        for (Task t : this.tasks) {
            if (t.getId().equals(task.getId())) {
                t = task;
                return t;
            } else {
                Task subtask = t.updateSubtask(task);
                if (subtask != null) {
                    return subtask;
                }
            }
        }

        throw new TaskNotFoundException("Task not found");
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
    }
}
