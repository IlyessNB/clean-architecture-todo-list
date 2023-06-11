package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.domain.errors.FileReaderException;
import fr.esgi.todolist.domain.errors.TodoListRepositoryException;

import java.util.Optional;
import java.util.UUID;

public class TodoListFileRepository implements TodoListRepository {
    private final String TODO_LIST_PATH = String.format("%s/consoleagenda/data.json", System.getProperty("user.home"));
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final TodoListSerializer todoListSerializer;
    private final TodoListDeserializer todoListDeserializer;
    private final TaskId taskId;

    public TodoListFileRepository(FileReader fileReader, FileWriter fileWriter, TodoListSerializer todoListSerializer, TodoListDeserializer todoListDeserializer) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.todoListSerializer = todoListSerializer;
        this.todoListDeserializer = todoListDeserializer;
        this.taskId = new TaskId(UUID.randomUUID().toString());
    }

    public void save(TodoList todoList) {
        var serializedTodoList = todoListSerializer.serialize(todoList);
        fileWriter.write(TODO_LIST_PATH, serializedTodoList);
    }

    public Optional<TodoList> get() {
        try {
            var serializedTodoList = fileReader.read(TODO_LIST_PATH);
            if (serializedTodoList.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(todoListDeserializer.deserialize(serializedTodoList));
        } catch (FileReaderException e) {
            return Optional.empty();
        } catch (Exception e) {
            throw new TodoListRepositoryException("Error while getting todo list");
        }
    }

    public TaskId nextTaskId() {
        return new TaskId(String.valueOf(taskId));
    }
}