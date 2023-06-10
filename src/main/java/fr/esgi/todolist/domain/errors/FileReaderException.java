package fr.esgi.todolist.domain.errors;

public class FileReaderException extends RuntimeException {
    public FileReaderException(String message) {
        super(message);
    }
}
