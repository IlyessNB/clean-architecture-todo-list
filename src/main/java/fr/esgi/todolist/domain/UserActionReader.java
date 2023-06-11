package fr.esgi.todolist.domain;

public interface UserActionReader {
    UserAction parse(String[] args);
}
