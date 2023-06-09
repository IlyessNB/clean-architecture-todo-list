package fr.esgi.todolist.infrastructure;


import com.fasterxml.jackson.databind.JsonSerializer;
import fr.esgi.todolist.domain.TaskId;

import java.io.IOException;

public class JSONTaskIdSerializer extends JsonSerializer<TaskId> {
    @Override
    public void serialize(TaskId taskId, com.fasterxml.jackson.core.JsonGenerator jsonGenerator, com.fasterxml.jackson.databind.SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(taskId.toString());
    }
}
