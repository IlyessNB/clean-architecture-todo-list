package fr.esgi.todolist.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListSerializer;
import fr.esgi.todolist.domain.errors.TodoListSerializerException;

public class JSONTodoListSerializer implements TodoListSerializer {
    @Override
    public String serialize(TodoList todoList) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(todoList.getTasks());
            ;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TodoListSerializerException("Error while serializing TodoList (TodoList = " + todoList + ")");
        }
    }
}