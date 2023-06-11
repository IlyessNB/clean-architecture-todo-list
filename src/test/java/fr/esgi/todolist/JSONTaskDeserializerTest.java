package fr.esgi.todolist;

import fr.esgi.todolist.domain.Task;
import fr.esgi.todolist.domain.TaskId;
import fr.esgi.todolist.domain.TodoList;
import fr.esgi.todolist.domain.TodoListDeserializer;
import fr.esgi.todolist.infrastructure.JSONTodoListDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JSONTaskDeserializerTest {

    @Test
    void test_deserialize_should_return_a_todo_list() {
        TodoListDeserializer todoListDeserializer = new JSONTodoListDeserializer();

        String jsonTodoList = "[{\"id\":{\"value\": \"1\"},\"description\":\"title\",\"creationDate\":\"2021-01-01T00:00:00\",\"dueDate\":\"2021-01-01T00:00:00\",\"closeDate\":\"2021-01-01T00:00:00\",\"state\":\"TODO\",\"tag\":\"tag\",\"subtasks\":[{\"id\":{\"value\": \"2\"},\"description\":\"title\",\"creationDate\":\"2021-01-01T00:00:00\",\"dueDate\":\"2021-01-01T00:00:00\",\"closeDate\":\"2021-01-01T00:00:00\",\"state\":\"TODO\",\"tag\":\"tag\",\"subtasks\":[]}]}]";

        TodoList todoList = todoListDeserializer.deserialize(jsonTodoList);

        Assertions.assertEquals(1, todoList.getTasks().size());
        Task task = todoList.getTasks().get(0);
        Assertions.assertEquals(new TaskId("1"), task.getId());
        Assertions.assertEquals("title", task.getDescription());
        Assertions.assertEquals("2021-01-01T00:00", task.getCreationDate().toString());
        Assertions.assertEquals("2021-01-01T00:00", task.getDueDate().toString());
        Assertions.assertEquals("2021-01-01T00:00", task.getCloseDate().toString());
        Assertions.assertEquals("TODO", task.getState().toString());
        Assertions.assertEquals("tag", task.getTag());
        Assertions.assertEquals(1, task.getSubtasks().size());
        Task subtask = task.getSubtasks().get(0);
        Assertions.assertEquals(new TaskId("2"), subtask.getId());
        Assertions.assertEquals("title", subtask.getDescription());
    }
}
