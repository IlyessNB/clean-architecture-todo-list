package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskState;
import fr.esgi.todolist.kernel.command.Command;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AddTask implements Command {
    public final String description;
    public final LocalDateTime creationDate;
    public final LocalDateTime dueDate;
    public final LocalDateTime closeDate;
    public final TaskState state;
    public final String tag;
    public final List<Task> subtasks;
    public final String parentTaskId;

    public AddTask(Map<String, Object> attributes) {
        this.description = Objects.requireNonNull(attributes.get("description")).toString();
        this.creationDate = Objects.requireNonNull(LocalDateTime.now());
        this.dueDate = attributes.containsKey("dueDate")
                ? (LocalDateTime) attributes.get("dueDate")
                : null;
        this.closeDate = null;
        this.state = Objects.requireNonNull(TaskState.TODO);
        this.tag = null;
        this.subtasks = List.of();
        this.parentTaskId = attributes.containsKey("parentId")
                ? attributes.get("parentId").toString()
                : null;
    }

    @Override
    public String toString() {
        return String.format("add description=%s dueDate=%s parentId=%s", description, dueDate, parentTaskId);
    }
}
