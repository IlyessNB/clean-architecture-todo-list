package fr.esgi.todolist.domain.errors;

public class FileWriterException extends RuntimeException {
    public FileWriterException(String message) {
        super(message);
    }
}
