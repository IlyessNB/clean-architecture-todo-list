package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.OkMessageGenerator;

import java.time.LocalDateTime;

public class LogOkMessageGenerator implements OkMessageGenerator {
    @Override
    public String createLog(String log) {
        return "[ok+][" + LocalDateTime.now() + "] " + log + "\n";
    }
}
