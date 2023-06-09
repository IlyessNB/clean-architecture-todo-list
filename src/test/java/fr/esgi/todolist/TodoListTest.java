package fr.esgi.todolist;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.errors.TaskNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    void test_update_task_should_update_task() throws TaskNotFoundException {
        TodoList todoList = TodoList.of();
        Task task = new Task(new TaskId("0"), "First task");
        Task firstSubTask =
                new Task(new TaskId("1"), "Subtask");
        Task secondSubTask =
                new Task(new TaskId("2"), "Subtask");
        Task thirdSubTask =
                new Task(new TaskId("3"), "Subtask");
        Task fourthSubTask =
                new Task(new TaskId("4"), "Subtask");
        task.addSubtask(firstSubTask);
        secondSubTask.addSubtask(thirdSubTask);
        thirdSubTask.addSubtask(fourthSubTask);
        task.addSubtask(secondSubTask);

        todoList.addTask(task);

        var updatedTask = todoList.updateTask(new Task(new TaskId("4"), "Updated task"));

        Assertions.assertEquals("Updated task", updatedTask.getDescription());
    }
}