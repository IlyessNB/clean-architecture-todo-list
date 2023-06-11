package fr.esgi.todolist.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListSerializer;
import fr.esgi.todolist.domain.errors.TodoListDeserializerException;

public class JSONTodoListSerializer implements TodoListSerializer {
    @Override
    public String serialize(TodoList todoList) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        try {
            return objectMapper.writeValueAsString(todoList.getTasks());
        } catch (Exception e) {
            throw new TodoListDeserializerException(e.getMessage());
        }
    }
}
