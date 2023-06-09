package fr.esgi.todolist.domain.errors;

public class TodoListSerializerException extends RuntimeException {
    public TodoListSerializerException(String message) {
        super(message);
    }
}
