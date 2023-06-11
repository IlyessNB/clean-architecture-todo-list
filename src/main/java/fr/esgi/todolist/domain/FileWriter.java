package fr.esgi.todolist.domain;

public interface FileWriter {
    void write(String filename, String todoList);
    void append(String filename, String todoList);
}
