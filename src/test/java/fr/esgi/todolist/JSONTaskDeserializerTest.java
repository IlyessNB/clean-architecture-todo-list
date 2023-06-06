package fr.esgi.todolist;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskDeserializer;
import fr.esgi.todolist.infrastructure.JSONTaskDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONTaskDeserializerTest {

    @Test
    public void test_deserialize_should_return_task() {
        String jsonTask = "{\"id\":\"1\",\"description\":\"description\"}";
        TaskDeserializer taskDeserializer = new JSONTaskDeserializer();
        Task task = taskDeserializer.deserialize(jsonTask);
        // TODO
//        Assertions.assertEquals(new TaskId(1), task.getId());
//        Assertions.assertEquals("title", task.getTitle());
    }
}
