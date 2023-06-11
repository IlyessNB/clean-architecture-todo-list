package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListRepository;
import fr.esgi.todolist.kernel.command.CommandHandler;

public class UpdateTaskHandler implements CommandHandler<UpdateTask, Task> {
    final private TodoListRepository todoListRepository;

    public UpdateTaskHandler(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public Task handle(UpdateTask udpateTask) {
        TaskId taskId = udpateTask.taskId;
        TodoList todoList = todoListRepository.get().orElse(TodoList.of());
        Task task = todoList.getTaskById(taskId);
        task.updateDescription(udpateTask.description != null
                ? udpateTask.description
                : task.getDescription()
        );
        task.updateDueDate(udpateTask.dueDate != null
                ? udpateTask.dueDate
                : task.getDueDate().get()
        );
        task.updateState(udpateTask.state != null
                ? udpateTask.state
                : task.getState()
        );
        todoList.updateTask(task);
        todoListRepository.save(todoList);
        return task;
    }
}
