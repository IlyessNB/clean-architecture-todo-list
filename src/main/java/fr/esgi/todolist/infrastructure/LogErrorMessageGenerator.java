package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.ErrorMessageGenerator;

import java.time.LocalDateTime;

public class LogErrorMessageGenerator implements ErrorMessageGenerator {
    @Override
    public String createLog(String userAction, String errorMessage) {
        return "[err][" + LocalDateTime.now() + "] " +  userAction + " : " + errorMessage + "\n";
    }
}
