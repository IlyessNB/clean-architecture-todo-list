package fr.esgi.todolist.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskDeserializer;
import fr.esgi.todolist.domain.errors.TaskDeserializerException;

public class JSONTaskDeserializer implements TaskDeserializer {
    @Override
    public Task deserialize(String jsonTask) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Task task = mapper.readValue(jsonTask, Task.class);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TaskDeserializerException("Error while deserializing JSON task (JSON = " + jsonTask + ")");
        }
    }
}
