package fr.esgi.todolist.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Task {
    TaskId id;
    String description;
    LocalDateTime creationDate;
    Optional<LocalDateTime> dueDate;
    Optional<LocalDateTime> closeDate;
    State state;
    Optional<String> tag;
    List<Task> subtasks;

    private Task(TaskId id, String description) {
        this.id = id;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.dueDate = Optional.empty();
        this.closeDate = Optional.empty();
        this.state = State.todo;
        this.tag = Optional.empty();
        this.subtasks = List.of();
    }

    private Task(TaskId id, String description, LocalDateTime dueDate) {
        this.id = id;
        this.description = description;
        this.creationDate = LocalDateTime.now();
        this.dueDate = Optional.of(dueDate);
        this.closeDate = Optional.empty();
        this.state = State.todo;
        this.tag = Optional.empty();
        this.subtasks = List.of();
    }

    public TaskId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Optional<LocalDateTime> getDueDate() {
        return dueDate;
    }

    public Optional<LocalDateTime> getCloseDate() {
        return closeDate;
    }

    public State getState() {
        return state;
    }

    public Optional<String> getTag() {
        return tag;
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateDueDate(LocalDateTime dueDate) {
        this.dueDate = Optional.of(dueDate);
    }

    public void updateCloseDate(LocalDateTime closeDate) {
        this.closeDate = Optional.of(closeDate);
    }

    public void updateState(State state) {
        this.state = state;
    }

    public void updateTag(String tag) {
        this.tag = Optional.of(tag);
    }

    public void addSubtask(Task subtask) {
        this.subtasks.add(subtask);
    }

    public void removeSubtask(Task subtask) {
        this.subtasks.remove(subtask);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description) && Objects.equals(creationDate, task.creationDate) && Objects.equals(dueDate, task.dueDate) && Objects.equals(closeDate, task.closeDate) && state == task.state && Objects.equals(tag, task.tag) && Objects.equals(subtasks, task.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, creationDate, dueDate, closeDate, state, tag, subtasks);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", closeDate=" + closeDate +
                ", state=" + state +
                ", tag=" + tag +
                ", subtasks=" + subtasks +
                '}';
    }
}
