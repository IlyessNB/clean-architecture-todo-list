package fr.esgi.todolist.domain.errors;

public class TodoListRepositoryException extends RuntimeException {
    public TodoListRepositoryException(String message) {
        super(message);
    }
}
