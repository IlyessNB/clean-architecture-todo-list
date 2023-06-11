package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListRepository;
import fr.esgi.todolist.kernel.query.QueryHandler;

import java.util.List;
import java.util.Optional;

public class GetTasksHandler implements QueryHandler<GetTasks, TodoList> {
    private final TodoListRepository todoListRepository;

    public GetTasksHandler(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public TodoList handle(GetTasks query) {
        final Optional<TodoList> getTodoList = todoListRepository.get();
        return getTodoList.orElse(TodoList.of());
    }
}
