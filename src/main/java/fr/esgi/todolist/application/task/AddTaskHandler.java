package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListRepository;
import fr.esgi.todolist.kernel.command.CommandHandler;

public class AddTaskHandler implements CommandHandler<AddTask, Task> {
    private final TodoListRepository todoListRepository;

    public AddTaskHandler(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public Task handle(AddTask command) {
        TaskId taskId = todoListRepository.nextTaskId();
        Task task = command.dueDate != null
                ? new Task(taskId, command.description, command.dueDate)
                : new Task(taskId, command.description);
        TodoList todoList = todoListRepository.get().orElse(TodoList.of());

        if (command.parentTaskId != null) {
            Task parentTask = todoList.getTaskById(new TaskId(command.parentTaskId));
            parentTask.addSubtask(task);
            todoList.updateTask(parentTask);
        } else {
            todoList.addTask(task);
        }

        todoListRepository.save(todoList);
        return task;
    }
}
