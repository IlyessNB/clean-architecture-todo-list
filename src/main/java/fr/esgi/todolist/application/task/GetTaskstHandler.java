package fr.esgi.todolist.application.task;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListRepository;
import fr.esgi.todolist.kernel.query.QueryHandler;

import java.util.List;
import java.util.Optional;

public class GetTaskstHandler implements QueryHandler<GetTasks, List<Task>> {
    private final TodoListRepository todoListRepository;

    public GetTaskstHandler(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<Task> handle(GetTasks query) {
        final Optional<TodoList> getTodoList = todoListRepository.get();
        TodoList todoList = getTodoList.orElse(TodoList.of());
        return todoList.getTasks();
    }
}
