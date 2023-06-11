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
        CommandLine commandLine = new CommandLine();

        final Map<Class<? extends UserAction>, UserActionHandler> userActionHandlerMap =
                Map.of(
                        AddTask.class, new AddTaskHandler(todoListRepository),
                        RemoveTask.class, new RemoveTaskHandler(todoListRepository),
                        UpdateTask.class, new UpdateTaskHandler(todoListRepository),
                        GetTasks.class, new GetTasksHandler(todoListRepository)
                );

        OkMessageGenerator okMessageGenerator = new LogOkMessageGenerator();
        ErrorMessageGenerator errorMessageGenerator = new LogErrorMessageGenerator();

        TodoListFileHandler todoListFileHandler = new TodoListFileHandler(commandLine, userActionHandlerMap, okMessageGenerator, errorMessageGenerator, fileWriter);
        todoListFileHandler.handle(args);
    }
}
