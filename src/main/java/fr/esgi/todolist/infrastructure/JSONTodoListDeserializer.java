package fr.esgi.todolist.infrastructure;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListDeserializer;
import fr.esgi.todolist.domain.errors.TodoListDeserializerException;

public class JSONTodoListDeserializer implements TodoListDeserializer {
    @Override
    public TodoList deserialize(String jsonTodoList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Task> tasks = mapper.readValue(jsonTodoList, new TypeReference<List<Task>>() {
            });
            var todoList = TodoList.of();
            todoList.setTasks(tasks);
            return todoList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TodoListDeserializerException("Error while deserializing JSON task (JSON = " + jsonTodoList + ")");
        }
    }
}
