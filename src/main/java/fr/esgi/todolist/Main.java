package fr.esgi.todolist;

import fr.esgi.todolist.application.task.*;
import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.infrastructure.*;
import fr.esgi.todolist.kernel.UserActionHandler;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new JavaIoFileReader();
        FileWriter fileWriter = new JavaIoFileWriter();
        TodoListSerializer todoListSerializer = new JSONTodoListSerializer();
        TodoListDeserializer todoListDeserializer = new JSONTodoListDeserializer();

        TodoListRepository todoListRepository = new TodoListFileRepository(fileReader, fileWriter, todoListSerializer, todoListDeserializer);
        UserActionReader commandLine = new CommandLine();

        final Map<Class<? extends UserAction>, UserActionHandler> userActionHandlerMap =
                Map.of(
                        AddTask.class, new AddTaskHandler(todoListRepository),
                        RemoveTask.class, new RemoveTaskHandler(todoListRepository),
                        UpdateTask.class, new UpdateTaskHandler(todoListRepository),
                        GetTasks.class, new GetTasksHandler(todoListRepository)
                );

        OkMessageGenerator okMessageGenerator = new LogOkMessageGenerator();
        ErrorMessageGenerator errorMessageGenerator = new LogErrorMessageGenerator();
        Printer printer = new SystemPrinter();

        TodoListFileHandler todoListFileHandler = new TodoListFileHandler(commandLine, userActionHandlerMap, okMessageGenerator, errorMessageGenerator, fileWriter, printer);
        todoListFileHandler.handle(args);
    }
}
