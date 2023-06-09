package fr.esgi.todolist.domain;

public interface TodoListDeserializer {
    TodoList deserialize(String todoList);
}
