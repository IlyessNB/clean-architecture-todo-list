package fr.esgi.todolist.domain.errors;

public class TodoListDeserializerException extends RuntimeException {
    public TodoListDeserializerException(String message) {
        super(message);
    }
}
