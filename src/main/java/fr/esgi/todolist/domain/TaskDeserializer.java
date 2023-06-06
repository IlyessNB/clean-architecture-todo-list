package fr.esgi.todolist.domain;

public interface TaskDeserializer {
    Task deserialize(String task);
}
