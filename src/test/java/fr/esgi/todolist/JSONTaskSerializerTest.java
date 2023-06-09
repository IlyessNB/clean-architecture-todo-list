package fr.esgi.todolist;

import fr.esgi.todolist.domain.*;
import fr.esgi.todolist.infrastructure.JSONTodoListSerializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class JSONTaskSerializerTest {

    @Test
    void test_serialize_should_return_a_string_of_todo_list() {
        TodoListSerializer todoListSerializer = new JSONTodoListSerializer();

        TodoList todoList = TodoList.of();
        Task firstTask = new Task(new TaskId("1"), "First task");
        Task secondTask = new Task(new TaskId("2"), "Second task", LocalDateTime.of(2020, 12, 25, 12, 0));
        todoList.addTask(firstTask);
        todoList.addTask(secondTask);

        String serializedTodoList = todoListSerializer.serialize(todoList);
        Assertions.assertEquals("[{\"id\":\"1\",\"description\":\"First task\",\"creationDate\":\"2021-01-01T00:00:00\",\"dueDate\":null,\"closeDate\":null,\"state\":\"TODO\",\"tag\":null,\"subtasks\":[]},{\"id\":\"2\",\"description\":\"Second task\",\"creationDate\":\"2021-01-01T00:00:00\",\"dueDate\":\"2020-12-25T12:00:00\",\"closeDate\":null,\"state\":\"TODO\",\"tag\":null,\"subtasks\":[]}]", serializedTodoList);

    }
}
