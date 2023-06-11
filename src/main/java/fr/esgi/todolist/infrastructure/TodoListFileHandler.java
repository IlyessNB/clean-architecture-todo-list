package fr.esgi.todolist.infrastructure;

import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.kernel.UserActionHandler;

import java.util.Map;

public class TodoListFileHandler {
    private final UserActionReader commandLine;
    private final Map<Class<? extends UserAction>, UserActionHandler> userActionHandlerMap;
    private final OkMessageGenerator okMessageGenerator;
    private final ErrorMessageGenerator errorMessageGenerator;
    private final FileWriter fileWriter;
    private final Printer printer;

    public TodoListFileHandler(
            UserActionReader commandLine,
            Map<Class<? extends UserAction>, UserActionHandler> userActionHandlerMap,
            OkMessageGenerator okMessageGenerator,
            ErrorMessageGenerator errorMessageGenerator,
            FileWriter fileWriter,
            Printer printer
    ) {
        this.commandLine = commandLine;
        this.userActionHandlerMap = userActionHandlerMap;
        this.okMessageGenerator = okMessageGenerator;
        this.errorMessageGenerator = errorMessageGenerator;
        this.fileWriter = fileWriter;
        this.printer = printer;
    }

    public void handle(String[] args) {
        var logFilePath = System.getProperty("user.home") + "/consoleagenda/log.txt";
        UserAction userAction = commandLine.parse(args);
        UserActionHandler userActionHandler = userActionHandlerMap.get(userAction.getClass());
        var log = "";
        try {
            var result = userActionHandler.handle(userAction);
            this.printer.print("Result: " + result.toString());
            log = okMessageGenerator.createLog(userAction.toString());
        } catch (Exception e) {
            System.out.println("Sorry, an error occurred: " + e.getMessage());
            log = errorMessageGenerator.createLog(userAction.toString(), e.getMessage());
        } finally {
            fileWriter.append(logFilePath, log);
        }
    }
}
