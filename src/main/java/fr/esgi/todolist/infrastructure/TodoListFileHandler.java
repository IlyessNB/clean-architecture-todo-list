package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.TodoListRepository;

public class TodoListFileHandler {
    private final TodoListRepository taskRepository;

    public TodoListFileHandler(TodoListRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void handle() {
        // TODO: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
