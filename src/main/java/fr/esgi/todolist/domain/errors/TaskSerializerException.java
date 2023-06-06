package fr.esgi.todolist.domain.errors;

public class TaskSerializerException extends RuntimeException {
    public TaskSerializerException(String message) {
        super(message);
    }
}
