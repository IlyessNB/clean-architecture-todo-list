package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.application.task.AddTask;
import fr.esgi.todolist.application.task.GetTasks;
import fr.esgi.todolist.application.task.RemoveTask;
import fr.esgi.todolist.application.task.UpdateTask;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.UserAction;
import fr.esgi.todolist.domain.errors.UserActionException;

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
                for (String option : userActionOptions) {
                    String[] keyValue = option.split(" ");
                    switch (keyValue[0]) {
                        case "-c" -> attributes.put("description", keyValue[1]);
                        case "-d" -> attributes.put("dueDate", keyValue[1]);
                    }
                }
                return new AddTask(attributes);
            case "list":
                return new GetTasks();
            case "remove":
                taskId = new TaskId(userActionInCommandLine[1]);
                return new RemoveTask(taskId);
            case "update":
                taskId = new TaskId(userActionInCommandLine[1]);
                for (String option : userActionOptions) {
                    String[] keyValue = option.split(" ");
                    switch (keyValue[0]) {
                        case "-c" -> attributes.put("description", keyValue[1]);
                        case "-d" -> attributes.put("dueDate", keyValue[1]);
                        case "-s" -> attributes.put("state", keyValue[1]);
                    }
                }
                return new UpdateTask(taskId, attributes);
            default:
                throw new UserActionException("Unknown action");
        }
    }
}
