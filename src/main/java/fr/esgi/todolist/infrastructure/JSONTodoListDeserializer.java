package fr.esgi.todolist.infrastructure;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListDeserializer;
import fr.esgi.todolist.domain.errors.TodoListDeserializerException;

public class JSONTodoListDeserializer implements TodoListDeserializer {
    @Override
    public TodoList deserialize(String jsonTask) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Task> tasks = mapper.readValue(jsonTask, new TypeReference<List<Task>>() {
            });
            var todoList = TodoList.of();
            todoList.setTasks(tasks);
            return todoList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TodoListDeserializerException("Error while deserializing JSON task (JSON = " + jsonTask + ")");
        }
    }
}
