package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.TaskState;
import fr.esgi.todolist.kernel.command.Command;

import java.time.LocalDateTime;
import java.util.Map;

public class UpdateTask implements Command {
    public final TaskId taskId;
    public final String description;
    public final LocalDateTime dueDate;
    public final TaskState state;

    public UpdateTask(TaskId taskId, Map<String, Object> attributes) {
        this.taskId = taskId;
        this.description = attributes.containsKey("description")
                ? attributes.get("description").toString()
                : null;
        this.dueDate = attributes.containsKey("dueDate")
                ? (LocalDateTime) attributes.get("dueDate")
                : null;
        this.state = attributes.containsKey("state")
                ? TaskState.valueOf(attributes.get("state").toString())
                : null;
    }

    @Override
    public String toString() {
        return String.format("update id=%s description=%s dueDate=%s state=%s", taskId, description, dueDate, state);
    }
}
