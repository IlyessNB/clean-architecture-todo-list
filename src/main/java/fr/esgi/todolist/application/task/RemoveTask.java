package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.kernel.command.Command;

public class RemoveTask implements Command {
    public final TaskId taskId;

    public RemoveTask(TaskId taskId) {
        this.taskId = taskId;
    }
}
