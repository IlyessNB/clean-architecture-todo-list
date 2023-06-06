package fr.esgi.todolist.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskDeserializer;
import fr.esgi.todolist.domain.TaskSerializer;
import fr.esgi.todolist.domain.errors.TaskDeserializerException;

public class JSONTaskSerializer implements TaskSerializer {
    @Override
    public String serialize(Task task) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonTask = mapper.writeValueAsString(task);
            return jsonTask;
        } catch (Exception e) {
            e.printStackTrace();
            throw new TaskDeserializerException("Error while serializing task (task = " + task + ")");
        }
    }
}