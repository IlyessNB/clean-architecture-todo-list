package fr.esgi.todolist.infrastructure;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class JavaIoFileWriterTest {
    String jsonTodoList = """
            [
              {
                "Created": "2022-02-15T22:14:30.486798+01:00",
                "DueDate": "2022-02-16T14:14:30.535929+01:00",
                "CloseDate": null,
                "Description": "init a project to create an app for my tasks",
                "State": 0,
                "Tag": null,
                "SubTasks": [
                  {
                    "Created": "2022-02-15T22:14:30.535975+01:00",
                    "DueDate": null,
                    "CloseDate": null,
                    "Description": "init repo for the project",
                    "State": 3,
                    "Tag": null,
                    "SubTasks": null
                  },
                  {
                    "Created": "2022-02-15T22:14:30.536022+01:00",
                    "DueDate": null,
                    "CloseDate": null,
                    "Description": "create solution and project",
                    "State": 3,
                    "Tag": null,
                    "SubTasks": null
                  },
                  {
                    "Created": "2022-02-15T22:14:30.536022+01:00",
                    "DueDate": null,
                    "CloseDate": null,
                    "Description": "create a small poc to test formats",
                    "State": 2,
                    "Tag": null,
                    "SubTasks": null
                  }
                ]
              },
              {
                "Created": "2022-02-13T22:14:30.536023+01:00",
                "DueDate": "2022-02-16T21:14:30.536024+01:00",
                "CloseDate": null,
                "Description": "make a design of my needs to manage my tasks",
                "State": 2,
                "Tag": null,
                "SubTasks": null
              },
              {
                "Created": "2022-02-16T22:14:30.536024+01:00",
                "DueDate": "2022-03-16T22:14:30.536025+01:00",
                "CloseDate": null,
                "Description": "get first feedback on my app with peers",
                "State": 0,
                "Tag": null,
                "SubTasks": null
              },
              {
                "Created": "2022-01-16T22:14:30.536143+01:00",
                "DueDate": "2022-02-01T22:14:30.536144+01:00",
                "CloseDate": "2022-02-11T22:14:30.536144+01:00",
                "Description": "brainstorm on what project to work on",
                "State": 5,
                "Tag": null,
                "SubTasks": null
              }
            ]""";
    @Test
    void test_write_in_a_none_existing_file() {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/fr/esgi/infrastructure/todolist/JavaIoFileWriterTest.json");
        file.delete();
        JavaIoFileWriter javaIoFileWriter = new JavaIoFileWriter();
        javaIoFileWriter.write(System.getProperty("user.dir") + "/src/test/resources/fr/esgi/infrastructure/todolist/JavaIoFileWriterTest.json", jsonTodoList);

        JavaIoFileReader javaIoFileReader = new JavaIoFileReader();
        String content = javaIoFileReader.read(System.getProperty("user.dir") + "/src/test/resources/fr/esgi/infrastructure/todolist/JavaIoFileWriterTest.json");
        assertEquals(jsonTodoList, content);
        file.delete();
    }

    @Test
    void test_write_in_an_existing_file() {
        JavaIoFileWriter javaIoFileWriter = new JavaIoFileWriter();
        javaIoFileWriter.write(System.getProperty("user.dir") + "/src/test/resources/fr/esgi/infrastructure/todolist/JavaIoFileWriterTest.json", jsonTodoList);
        javaIoFileWriter.write(System.getProperty("user.dir") + "/src/test/resources/fr/esgi/infrastructure/todolist/JavaIoFileWriterTest.json", "[]");

        JavaIoFileReader javaIoFileReader = new JavaIoFileReader();
        String content = javaIoFileReader.read(System.getProperty("user.dir") + "/src/test/resources/fr/esgi/infrastructure/todolist/JavaIoFileWriterTest.json");
        assertEquals("[]", content);
    }
}