package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.LogBuilder;

import java.time.LocalDateTime;

public class ErrLogBuilder implements LogBuilder {
    @Override
    public String createLog(String log) {
        return "[err][" + LocalDateTime.now() + "]" +  log + "\n";
    }
}
