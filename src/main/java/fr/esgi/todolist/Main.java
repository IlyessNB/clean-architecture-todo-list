package fr.esgi.todolist;

import fr.esgi.todolist.infrastructure.TodoListFileHandler;

public class Main {
    public static void main(String[] args) {
        TodoListFileHandler todoListFileHandler = new TodoListFileHandler(null);
        todoListFileHandler.handle();
    }
}
