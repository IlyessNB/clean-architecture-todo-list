package fr.esgi.todolist;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TodoListDeserializer;
import fr.esgi.todolist.infrastructure.JSONTodoListDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONTaskDeserializerTest {

    @Test
    public void test_deserialize_should_return_task() {
        String jsonTask = "{\"id\":\"1\",\"description\":\"description\"}";
        TodoListDeserializer taskDeserializer = new JSONTodoListDeserializer();
        Task task = taskDeserializer.deserialize(jsonTask);
        // TODO
        // Assertions.assertEquals(new TaskId(1), task.getId());
        // Assertions.assertEquals("title", task.getTitle());
    }
}
