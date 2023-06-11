package fr.esgi.todolist.domain;

public interface ErrorMessageGenerator {
    String createLog(String userAction, String errorMessage);
}
