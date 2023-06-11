package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.LogBuilder;

import java.time.LocalDateTime;

public class OkLogBuilder implements LogBuilder {
    @Override
    public String createLog(String log) {
        return "[ok+][" + LocalDateTime.now() + "]" + log + "\n";
    }
}
