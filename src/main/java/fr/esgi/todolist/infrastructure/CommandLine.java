package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.application.task.AddTask;
import fr.esgi.todolist.application.task.GetTasks;
import fr.esgi.todolist.application.task.RemoveTask;
import fr.esgi.todolist.application.task.UpdateTask;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.UserAction;
import fr.esgi.todolist.domain.errors.UserActionException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CommandLine {

    public UserAction parse(String[] userActionInCommandLine) {
        String typeOfUserAction = userActionInCommandLine[0];
        String[] userActionOptions = Arrays.copyOfRange(userActionInCommandLine, 1, userActionInCommandLine.length);
        TaskId taskId;
        Map<String, Object> attributes = new HashMap<>();
        switch (typeOfUserAction) {
            case "add":
                for (int i = 0; i < userActionOptions.length; i += 2) {
                    String key = userActionOptions[i];
                    String value = userActionOptions[i + 1];
                    switch (key) {
                        case "-c" -> attributes.put("description", value);
                        case "-d" -> attributes.put("dueDate", LocalDateTime.parse(value));
                        case "-p" -> attributes.put("parentId", value);
                        default -> throw new UserActionException("Unknown option : " + key);
                    }
                }
                return new AddTask(attributes);
            case "list":
                return new GetTasks();
            case "remove":
                taskId = new TaskId(userActionOptions[0]);
                return new RemoveTask(taskId);
            case "update":
                taskId = new TaskId(userActionOptions[0]);
                userActionOptions = Arrays.copyOfRange(userActionOptions, 1, userActionOptions.length);
                for (int i = 0; i < userActionOptions.length; i += 2) {
                    String key = userActionOptions[i];
                    String value = userActionOptions[i + 1];
                    switch (key) {
                        case "-c" -> attributes.put("description", value);
                        case "-d" -> attributes.put("dueDate", LocalDateTime.parse(value));
                        case "-s" -> attributes.put("state", value);
                        default -> throw new UserActionException("Unknown option : " + key);
                    }
                }
                return new UpdateTask(taskId, attributes);
            default:
                throw new UserActionException("Unknown action");
        }
    }
}
