package fr.esgi.todolist.domain;

import java.util.List;

public interface FileReader {
    List<Task> read(String filename);
}
