package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListRepository;
import fr.esgi.todolist.kernel.command.CommandHandler;

public class RemoveTaskHandler implements CommandHandler<RemoveTask, Task> {
    final private TodoListRepository todoListRepository;

    public RemoveTaskHandler(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public Task handle(RemoveTask removeTask) {
        TaskId taskId = removeTask.taskId;
        TodoList todoList = todoListRepository.get().orElse(TodoList.of());
        Task task = todoList.getTaskById(taskId);
        todoList.removeTask(task);
        return task;
    }
}
