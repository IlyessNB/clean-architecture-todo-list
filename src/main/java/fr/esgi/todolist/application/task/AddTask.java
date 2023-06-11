package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.State;
import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.kernel.command.Command;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class AddTask implements Command {
    public final String description;
    public final LocalDateTime creationDate;
    public final LocalDateTime dueDate;
    public final LocalDateTime closeDate;
    public final State state;
    public final String tag;
    public final List<Task> subtasks;

    public AddTask(Map<String, Object> attributes) {
        this.description = Objects.requireNonNull(attributes.get("description")).toString();
        this.creationDate = Objects.requireNonNull(LocalDateTime.now());
        this.dueDate = attributes.containsKey("dueDate")
                ? (LocalDateTime) attributes.get("dueDate")
                : null;
        this.closeDate = null;
        this.state = Objects.requireNonNull(State.todo);
        this.tag = null;
        this.subtasks = List.of();
    }
}
