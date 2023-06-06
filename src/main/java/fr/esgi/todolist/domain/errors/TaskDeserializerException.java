package fr.esgi.todolist.domain.errors;

public class TaskDeserializerException extends RuntimeException {
    public TaskDeserializerException(String message) {
        super(message);
    }
}
