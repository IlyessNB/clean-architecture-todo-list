package fr.esgi.todolist.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.esgi.todolist.domain.errors.TaskNotFoundException;
import fr.esgi.todolist.infrastructure.JSONTaskIdDeserializer;
import fr.esgi.todolist.infrastructure.JSONTaskIdSerializer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Task {
    @JsonProperty("id")
    @JsonSerialize(using = JSONTaskIdSerializer.class)
    @JsonDeserialize(using = JSONTaskIdDeserializer.class)
    TaskId id;
    @JsonProperty("description")
    String description;
    @JsonProperty("creationDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime creationDate;
    @JsonProperty("dueDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime dueDate;
    @JsonProperty("closeDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    LocalDateTime closeDate;
    @JsonProperty("state")
    TaskState state;
    @JsonProperty("tag")
    String tag;
    @JsonProperty("subtasks")
    List<Task> subtasks;

    public Task() {
    }

    public Task(TaskId id, String description) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
        this.creationDate = Objects.requireNonNull(LocalDateTime.now());
        this.dueDate = null;
        this.closeDate = null;
        this.state = Objects.requireNonNull(TaskState.TODO);
        this.tag = null;
        this.subtasks = new ArrayList<>();
    }

    public Task(TaskId id, String description, LocalDateTime dueDate) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
        this.creationDate = Objects.requireNonNull(LocalDateTime.now());
        this.dueDate = dueDate;
        this.closeDate = null;
        this.state = Objects.requireNonNull(TaskState.TODO);
        this.tag = null;
        this.subtasks = new ArrayList<>();
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
        return Optional.ofNullable(dueDate);
    }

    public Optional<LocalDateTime> getCloseDate() {
        return Optional.ofNullable(closeDate);
    }

    public TaskState getState() {
        return state;
    }

    public Optional<String> getTag() {
        return Optional.ofNullable(tag);
    }

    public List<Task> getSubtasks() {
        return subtasks;
    }

    public void updateDescription(String description) {
        this.description = Objects.requireNonNull(description);
    }

    public void updateDueDate(LocalDateTime dueDate) {
        this.dueDate = Objects.requireNonNull(dueDate);
    }

    public void updateCloseDate(LocalDateTime closeDate) {
        this.closeDate = Objects.requireNonNull(closeDate);
    }

    public void updateState(TaskState state) {
        this.state = Objects.requireNonNull(state);
        if (state == TaskState.DONE) {
            updateCloseDate(LocalDateTime.now());
        }
    }

    public void updateTag(String tag) {
        this.tag = Objects.requireNonNull(tag);
    }

    public void addSubtask(Task subtask) {
        this.subtasks.add(Objects.requireNonNull(subtask));
    }

    public void removeSubtask(Task subtask) {
        this.subtasks.remove(Objects.requireNonNull(subtask));
    }


    public Task updateSubtask(Task task) {
        if (this.id.equals(task.id)) {
            this.description = task.description;
            this.dueDate = task.dueDate;
            this.closeDate = task.closeDate;
            this.state = task.state;
            return this;
        }
        for (Task subtask : this.subtasks) {
            Task current = subtask.updateSubtask(task);
            if (current != null) {
                return current;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) && Objects.equals(description, task.description)
                && Objects.equals(creationDate, task.creationDate) && Objects.equals(dueDate, task.dueDate)
                && Objects.equals(closeDate, task.closeDate) && state == task.state && Objects.equals(tag, task.tag)
                && Objects.equals(subtasks, task.subtasks);
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
