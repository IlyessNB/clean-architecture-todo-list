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
        for (Task task : this.tasks) {
            if (task.getId().equals(taskId)) {
                return task;
            } else {
                Task subtask = task.getSubtaskById(taskId);
                if (subtask != null) {
                    return subtask;
                }
            }
        }
        throw new TaskNotFoundException("Task with id " + taskId + " not found");
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

    public Task removeTask(Task taskToRemove) {
        for (Task task : this.tasks) {
            if (task.getId().equals(taskToRemove.getId())) {
                this.tasks.remove(task);
                return task;
            } else {
                Task subtask = task.removeSubtask(taskToRemove);
                if (subtask != null) {
                    return subtask;
                }
            }
        }
        throw new TaskNotFoundException("Task not found");
    }

@Override
    public String toString() {
        // JSON Beautifier on list of tasks
        return "{\n" +
                "  \"tasks\": [\n" +
                "    {\n" +
                "      \"id\": \"1\",\n" +
                "      \"title\": \"Task 1\",\n" +
                "      \"description\": \"Description of task 1\",\n" +
                "      \"subtasks\": [\n" +
                "        {\n" +
                "          \"id\": \"1\",\n" +
                "          \"title\": \"Subtask 1\",\n" +
                "          \"description\": \"Description of subtask 1\",\n" +
                "          \"subtasks\": []\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": \"2\",\n" +
                "          \"title\": \"Subtask 2\",\n" +
                "          \"description\": \"Description of subtask 2\",\n" +
                "          \"subtasks\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"2\",\n" +
                "      \"title\": \"Task 2\",\n" +
                "      \"description\": \"Description of task 2\",\n" +
                "      \"subtasks\": []\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
