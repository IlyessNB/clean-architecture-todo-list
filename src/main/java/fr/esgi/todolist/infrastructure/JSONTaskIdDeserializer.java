package fr.esgi.todolist.infrastructure;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import fr.esgi.todolist.domain.TaskId;

import java.io.IOException;

public class JSONTaskIdDeserializer extends JsonDeserializer<TaskId> {
    @Override
    public TaskId deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return new TaskId(jsonParser.getValueAsString());
    }
}
